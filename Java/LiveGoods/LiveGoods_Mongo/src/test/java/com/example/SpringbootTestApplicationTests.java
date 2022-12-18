package com.example;


import com.example.pojo.Banner;
import com.example.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class SpringbootTestApplicationTests {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void insertItems() {
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCity("北京");
        item.setHouseType("150 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h38yASwjzABLGy04UWBI722.png",
                        "group1/M00/00/00/CtM3BV9h4BmAQkL1AAjIoXS-cuE085.png",
                        "group1/M00/00/00/CtM3BV9h4B2AXvLBAAro96E3Lio828.png"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("北京高档公寓");
        Map<String, String> info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("230 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h4CCAaSTAAAuC40wnByU864.png",
                        "group1/M00/00/00/CtM3BV9h4CSADcQxABS0LiTh-88659.png",
                        "group1/M00/00/00/CtM3BV9h4CeAOucVABHVEPBnO7M969.png"
                )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("整租");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5室3厅");
        info.put("level", "2/2层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        item.setTitle("北京联排别墅");
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("310 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h4CCAaSTAAAuC40wnByU864.png",
                        "group1/M00/00/00/CtM3BV9h4CSADcQxABS0LiTh-88659.png",
                        "group1/M00/00/00/CtM3BV9h4CeAOucVABHVEPBnO7M969.png"
                )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("整租");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6室4厅");
        info.put("level", "3/3层");
        info.put("style", "豪华装修");
        info.put("orientation", "四面环海");
        item.setInfo(info);
        item.setTitle("北京独栋别墅");
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("60 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h38yASwjzABLGy04UWBI722.png",
                        "group1/M00/00/00/CtM3BV9h4BmAQkL1AAjIoXS-cuE085.png",
                        "group1/M00/00/00/CtM3BV9h4B2AXvLBAAro96E3Lio828.png"
                )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2室1厅");
        info.put("level", "6/6层");
        info.put("style", "简单装修");
        info.put("orientation", "朝南");
        item.setInfo(info);
        item.setTitle("北京老小区");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("150 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h38yASwjzABLGy04UWBI722.png",
                        "group1/M00/00/00/CtM3BV9h4BmAQkL1AAjIoXS-cuE085.png",
                        "group1/M00/00/00/CtM3BV9h4B2AXvLBAAro96E3Lio828.png"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("上海高档公寓");
        info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("230 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h4CCAaSTAAAuC40wnByU864.png",
                        "group1/M00/00/00/CtM3BV9h4CSADcQxABS0LiTh-88659.png",
                        "group1/M00/00/00/CtM3BV9h4CeAOucVABHVEPBnO7M969.png"
                )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("整租");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5室3厅");
        info.put("level", "2/2层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        item.setTitle("上海联排别墅");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("310 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h4CCAaSTAAAuC40wnByU864.png",
                        "group1/M00/00/00/CtM3BV9h4CSADcQxABS0LiTh-88659.png",
                        "group1/M00/00/00/CtM3BV9h4CeAOucVABHVEPBnO7M969.png"
                )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("整租");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6室4厅");
        info.put("level", "3/3层");
        info.put("style", "豪华装修");
        info.put("orientation", "四面环海");
        item.setInfo(info);
        item.setTitle("上海独栋别墅");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("60 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/CtM3BV9h38yASwjzABLGy04UWBI722.png",
                        "group1/M00/00/00/CtM3BV9h4BmAQkL1AAjIoXS-cuE085.png",
                        "group1/M00/00/00/CtM3BV9h4B2AXvLBAAro96E3Lio828.png"
                )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2室1厅");
        info.put("level", "6/6层");
        info.put("style", "简单装修");
        info.put("orientation", "朝南");
        item.setInfo(info);
        item.setTitle("上海老小区");
        items.add(item);

        mongoTemplate.insert(items, Item.class);
    }

    @Test
    public void insert() {
        ArrayList<Banner> list = new ArrayList<>();
        Date date = new Date();
        Banner banner1 = new Banner();
        banner1.setUrl("group1/M00/00/00/CtM3BV9h38yASwjzABLGy04UWBI722.png");
        banner1.setCreateTime(date);

        Banner banner2 = new Banner();
        banner2.setUrl("group1/M00/00/00/CtM3BV9h4BmAQkL1AAjIoXS-cuE085.png");
        banner2.setCreateTime(date);

        Banner banner3 = new Banner();
        banner3.setUrl("group1/M00/00/00/CtM3BV9h4B2AXvLBAAro96E3Lio828.png");
        banner3.setCreateTime(date);

        Banner banner4 = new Banner();
        banner4.setUrl("group1/M00/00/00/CtM3BV9h4CCAaSTAAAuC40wnByU864.png");
        banner4.setCreateTime(date);

        Banner banner5 = new Banner();
        banner5.setUrl("group1/M00/00/00/CtM3BV9h4CSADcQxABS0LiTh-88659.png");
        banner5.setCreateTime(date);

        Banner banner6 = new Banner();
        banner6.setUrl("group1/M00/00/00/CtM3BV9h4CeAOucVABHVEPBnO7M969.png");
        banner6.setCreateTime(date);

        list.add(banner1);
        list.add(banner2);
        list.add(banner3);
        list.add(banner4);
        list.add(banner5);
        list.add(banner6);

        mongoTemplate.insert(list, Banner.class);
    }


}
