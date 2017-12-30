package blservice.accountblservice;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.accountVO.InitAccountVO;
import VO.goodsVO.GoodsVO;
import resultmessage.ResultMessage;

public interface AccountInitService {

	
	//得到所有商品
	public List<GoodsVO> getGoodsInfo();
	
	//得到所有会员信息
	 public List<VIPVO> getVIPInfo();
	
	//保存期初建账信息
	 public ResultMessage saveInitAccountInfo(InitAccountVO vo);
	
}
