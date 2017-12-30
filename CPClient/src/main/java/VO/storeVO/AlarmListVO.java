package VO.storeVO;

public class AlarmListVO {
//库存报警单值对象
    //王瑞华 161250143 2017年12月2日
     public int alarmNum;
   public  int currentNum;
   public  String listID;
   public  String goodsID;
    public String goodsName;
    public AlarmListVO(int alarmNum,int currentNum,String listID ,String goodsID,String goodsName){
        this.alarmNum=alarmNum;
        this.currentNum=currentNum;
        this.listID=listID;
        this.goodsID=goodsID;
        this.goodsName=goodsName;
    }
}
