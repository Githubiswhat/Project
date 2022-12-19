package com.example.seckill.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.User;
import com.example.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserUtil {

    @Autowired
    DataSource dataSource;

    @Test
    public void createUser(){
        int count = 5000;
        List<User> users = new ArrayList<User>(count);
        log.info("create user");
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(13000000000L + i);
            user.setLoginCount(1);
            user.setNickname("user" + i);
            user.setRegisterDate(new Date());
            user.setSalt("1a2b3c");
            user.setPassword(MD5Util.inputPassToDbPass("123456", user.getSalt()));
            users.add(user);
        }

        String sql = "replace into sk_user(login_count, nickname, register_date, salt, password, id)values(?,?,?,?,?,?)";
        log.info("insert to db");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement(sql)){
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                prepareStatement.setInt(1, user.getLoginCount());
                prepareStatement.setString(2, user.getNickname());
                prepareStatement.setTimestamp(3, new Timestamp(user.getRegisterDate().getTime()));
                prepareStatement.setString(4, user.getSalt());
                prepareStatement.setString(5, user.getPassword());
                prepareStatement.setLong(6, user.getId());
                prepareStatement.addBatch();
            }
            prepareStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //登录，生成token
        String urlString = "http://localhost:8080/login/do_login";
        File file = new File("tokens.txt");
        if (file.exists()) {
            file.delete();
        }

        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            file.createNewFile();
            raf.seek(0);
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                OutputStream out = connection.getOutputStream();
                String params = "mobile=" + user.getId() + "&password=" + MD5Util.inputPassToFormPass("123456");
                out.write(params.getBytes());
                out.flush();

                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buff)) >= 0) {
                    bout.write(buff, 0, len);
                }
                inputStream.close();
                bout.close();
                String response = bout.toString();
                JSONObject jo = JSON.parseObject(response);
                String token = jo.getString("data");
                System.out.println("create token : " + user.getId());

                String row = user.getId() + "," + token;
                raf.seek(raf.length());
                raf.write(row.getBytes());
                raf.write("\r\n".getBytes());
                System.out.println("write to file : " + user.getId());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("over");
    }
}
