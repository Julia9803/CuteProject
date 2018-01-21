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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + autoId;
		long temp;
		temp = Double.doubleToLongBits(goodsBuyPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((goodsCategory == null) ? 0 : goodsCategory.hashCode());
		result = prime * result + ((goodsID == null) ? 0 : goodsID.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		temp = Double.doubleToLongBits(goodsSellPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((goodsType == null) ? 0 : goodsType.hashCode());
		temp = Double.doubleToLongBits(recentBuyPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(recentSellPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsVO other = (GoodsVO) obj;
		if (autoId != other.autoId)
			return false;
		if (Double.doubleToLongBits(goodsBuyPrice) != Double.doubleToLongBits(other.goodsBuyPrice))
			return false;
		if (goodsCategory == null) {
			if (other.goodsCategory != null)
				return false;
		} else if (!goodsCategory.equals(other.goodsCategory))
			return false;
		if (goodsID == null) {
			if (other.goodsID != null)
				return false;
		} else if (!goodsID.equals(other.goodsID))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (Double.doubleToLongBits(goodsSellPrice) != Double.doubleToLongBits(other.goodsSellPrice))
			return false;
		if (goodsType == null) {
			if (other.goodsType != null)
				return false;
		} else if (!goodsType.equals(other.goodsType))
			return false;
		if (Double.doubleToLongBits(recentBuyPrice) != Double.doubleToLongBits(other.recentBuyPrice))
			return false;
		if (Double.doubleToLongBits(recentSellPrice) != Double.doubleToLongBits(other.recentSellPrice))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
    
}
