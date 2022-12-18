package com.example.pojo;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品实体类型
 * Lombok技术不是通用的。在很多商业环境中，lombok并不适用。
 * 因为lombok相对来说，太死板。
 * 在使用lombok注解的同时，还需要，自定义增加一些辅助的getter和setter方法。
 */
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Item {
    private String id;
    private String title;// 标题，字符串
    // private String img;//商品图片，字符串，推导属性，是可以通过当前类型中其他属性推导技术得出结果的。
    // private String link;//跳转链接，字符串，推导属性。
    private Long sales;//销量，数学
    private Boolean recommendation;//是否为热门，布尔
    private Byte recoSort;//热门排序|权重，数学
    private String city;//所属城市，字符串
    private Long price;// 价格，数学, 单位是元
    private String rentType;//租赁方式，整租，合租等。 字符串
    private String houseType;// 房屋面积，字符串
    private Map<String, String> info;// 房屋特性， Map集合。集合存储数据内容为： years: "建造年份", type: "房屋类型，几室几厅", level: "所在楼层", style: "装修标准", orientation: "房屋朝向"
    private List<String> imgs;// 图片集合。字符串数组或集合
    private String houseType4Search;
    private Date buytime;
    private Boolean rented;

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return imgs.get(0);
    }

    public void setImg(String img) {
    }

    public String getLink() {
        return "/details/" + id;
    }

    public void setLink(String link) {
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Boolean getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Boolean recommendation) {
        this.recommendation = recommendation;
    }

    public Byte getRecoSort() {
        return recoSort;
    }

    public void setRecoSort(Byte recoSort) {
        this.recoSort = recoSort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseType4Search() {
        // "楼层 | 几室几厅 - 面积"
        return info.get("level") + " | " + info.get("type") + " - " + houseType;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
