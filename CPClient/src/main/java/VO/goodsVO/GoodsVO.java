package VO.goodsVO;

import util.GoodsUtil;

public class GoodsVO {
	/**
	 * 商品编号
	 */
	String goodsID;
	/**
	 * 商品名称
	 */
	String goodsName;
	/**
	 * 商品分类
	 */
	String goodsCategory;
	/**
	 * 商品类型
	 */
	String goodsType;
	/**
	 * 商品进价
	 */
	double goodsBuyPrice;
	/**
	 * 商品零售价
	 */
	double goodsSellPrice;
	/**
	 * 最近进价
	 */
	double recentBuyPrice;
	/**
	 * 最近零售价
	 */
	double recentSellPrice;
	/**
	 * 数据库主键
	 */
	int autoId;
    /**
     * 商品状态 即是否被删除
     */
	GoodsUtil state = GoodsUtil.EXIST;
	
	public GoodsVO(String goodsID,String goodsCategory,String goodsName,String goodsType
			,double goodsBuyPrice,double goodsSellPrice,double recentBuyPrice,double recentSellPrice) {
		this.goodsID = goodsID;
		this.goodsCategory = goodsCategory;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsBuyPrice = goodsBuyPrice;
		this.goodsSellPrice = goodsSellPrice;
		this.recentBuyPrice = recentBuyPrice;
		this.recentSellPrice = recentSellPrice;
	}

    public void setState(GoodsUtil state) {
        this.state = state;
    }

    public GoodsUtil getState() {
        return state;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsID() {
		return  goodsID;
	}
	
	public String getGoodsCategory() {
		return goodsCategory;
	}
	
	public String getGoodsType() {
		return goodsType;
	}

	public double getGoodsBuyPrice() {
		return goodsBuyPrice;
	}
	
	public double getGoodsSellPrice() {
		return goodsSellPrice;
	}
	
	public double recentBuyPrice() {
		return recentBuyPrice;
	}
	
	public double recentSellPrice() {
		return recentSellPrice;
	}

	public void setGoodsName(String newGoodsName){
	    this.goodsName = newGoodsName;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public void setGoodsID(String id) {
		this.goodsID = id;
	}

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public void setGoodsBuyPrice(double goodsBuyPrice) {
        this.goodsBuyPrice = goodsBuyPrice;
    }

    public void setGoodsSellPrice(double goodsSellPrice) {
        this.goodsSellPrice = goodsSellPrice;
    }

    public void setRecentBuyPrice(double recentBuyPrice) {
        this.recentBuyPrice = recentBuyPrice;
    }

    public void setRecentSellPrice(double recentSellPrice) {
        this.recentSellPrice = recentSellPrice;
    }

    public double getRecentBuyPrice() {
        return recentBuyPrice;
    }

    public double getRecentSellPrice() {
        return recentSellPrice;
    }
}
