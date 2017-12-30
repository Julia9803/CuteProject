//package dataHelper;
//
//import PO.GoodsInSalePO;
//import PO.PresentForSumPO;
//import org.hibernate.Session;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**     
//* @author 李安迪
//* @date 2017年12月1日
//* @description
//*/
////
//public class Test {
//	 public static void main( String[] args )
//	    {
//	        System.out.println("Maven + Hibernate + MySQL");
//	        HibernateUtil hibernateUtil = new HibernateUtil();
//	        Session session = hibernateUtil.session;
//	        
////	        session.beginTransaction();
////	        OperationPO op = new OperationPO("0001", "time", "operator", "category", "operation");
//
//	        Date startTime = new Date(107, 0, 1);
//	        Date endTime = new Date(107, 0, 2);
//	        GoodsInSalePO lamp = new GoodsInSalePO("0001","lamp",1);
//	        GoodsInSalePO lamp1 = new GoodsInSalePO("0002","lamp1",1);
//	        List<GoodsInSalePO> list = new ArrayList<GoodsInSalePO>();
//	        list.add(lamp);
//	        list.add(lamp1);
//	         PresentForSumPO po = new PresentForSumPO(startTime, endTime, 0, list, 0);
//	        
//	        session.save(po);
//	        
////			 List employees = session.createQuery("FROM PresentForSumPO").list();
////			 for (Iterator iterator =
////			 employees.iterator(); iterator.hasNext();){
////			 PresentForSumPO e = (PresentForSumPO) iterator.next();
////			 System.out.println(e.getPresentList());
////			 }
//			 
//	        session.getTransaction().commit();
//	    }
//
//
//
//}
