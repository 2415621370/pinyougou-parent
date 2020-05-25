package com.pinyougou.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品表(TbItem)实体类
 *
 * @author makejava
 * @since 2020-05-24 19:21:35
 */
public class TbItem implements Serializable {
    private static final long serialVersionUID = 676719188256637401L;
    /**
    * 商品id，同时也是商品编号
    */
    private Long id;
    /**
    * 商品标题
    */
    private String title;
    /**
    * 商品卖点
    */
    private String sellPoint;
    /**
    * 商品价格，单位为：元
    */
    private Double price;
    
    private Integer stockCount;
    /**
    * 库存数量
    */
    private Integer num;
    /**
    * 商品条形码
    */
    private String barcode;
    /**
    * 商品图片
    */
    private String image;
    /**
    * 所属类目，叶子类目
    */
    private Long categoryid;
    /**
    * 商品状态，1-正常，2-下架，3-删除
    */
    private String status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    
    private String itemSn;
    
    private Double costPirce;
    
    private Double marketPrice;
    
    private String isDefault;
    
    private Long goodsId;
    
    private String sellerId;
    
    private String cartThumbnail;
    
    private String category;
    
    private String brand;
    
    private String spec;
    
    private String seller;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
    }

    public Double getCostPirce() {
        return costPirce;
    }

    public void setCostPirce(Double costPirce) {
        this.costPirce = costPirce;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCartThumbnail() {
        return cartThumbnail;
    }

    public void setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

}