package VO.goodsVO;

import util.GoodsUtil;

/**
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class GoodsCategoryVO {
	String goodsCategoryName;
	String parentName;
	int autoId;
	GoodsUtil state = GoodsUtil.EXIST;

    public GoodsUtil getState() {
        return state;
    }

    public void setState(GoodsUtil state) {
        this.state = state;
    }

    public String getGoodsCategoryName() {
		return goodsCategoryName;
	}

	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	    
	public GoodsCategoryVO(String goodsCategoryName, String parentName) {
	this.goodsCategoryName = goodsCategoryName;
	this.parentName = parentName;
	}

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getAutoId() {
        return autoId;
    }
}
