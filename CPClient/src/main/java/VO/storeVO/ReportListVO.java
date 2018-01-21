package VO.storeVO;

import util.State;
import util.StoreListType;

public class ReportListVO {
   public  StoreListType st;
   public State statetype;
    public int actualNum;
    public int Num;
   public  int delta;
   public  String goodsID;
   public  String listID;
   public  String GoodsName;
   
   public String time;//操作时间
   public String operator;//操作员

   public  ReportListVO(int actualNum,int Num,String goodsID,String listID,String GoodsName){
        this.actualNum=actualNum;
        this.Num=Num;
        this.GoodsName=GoodsName;
        this.goodsID=goodsID;
        this.listID=listID;
        if(actualNum>Num){
            this.st=StoreListType.OVERFLOW;
            this.delta=actualNum-Num;
        }else if(actualNum<Num){
            this.st=StoreListType.LOSS;
            this.delta=Num-actualNum;
        }
    }
   public ReportListVO(){}
}


