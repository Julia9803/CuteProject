package PO;

import util.GoodsUtil;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class GoodsCategoryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9022883235329228560L;
	String goodsCategoryName;
    String parentName;
    private int autoId;
    private GoodsUtil state = GoodsUtil.EXIST;

    public GoodsCategoryPO(String goodsCategoryName, String parentName, GoodsUtil state) {
        this.goodsCategoryName = goodsCategoryName;
        this.parentName = parentName;
        this.state = state;
    }

    public GoodsCategoryPO() {
    }

    public void setState(GoodsUtil state) {
        this.state = state;
    }

    public GoodsUtil getState() {
        return state;
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

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + autoId;
		result = prime * result + ((goodsCategoryName == null) ? 0 : goodsCategoryName.hashCode());
		result = prime * result + ((parentName == null) ? 0 : parentName.hashCode());
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
		GoodsCategoryPO other = (GoodsCategoryPO) obj;
		if (goodsCategoryName == null) {
			if (other.goodsCategoryName != null)
				return false;
		} else if (!goodsCategoryName.equals(other.goodsCategoryName))
			return false;
		if (parentName == null) {
			if (other.parentName != null)
				return false;
		} else if (!parentName.equals(other.parentName))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
}