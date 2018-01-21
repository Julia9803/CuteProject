package dataHelper.serviceImpl;


import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_Green<T> {
    /*
    * 专家的架构写的太精妙了，以至于我不敢在她源代码上狗尾续貂
    * 总的来说我有以下几个问题：
    * 1，autoID不是必要的吧。我们的系统单据/商品的编号是唯一的ID，应该可以直接把它作为主键。
    * 2，是不是应该在PO中使用注释技术。或者说通过写注释是不是可以自动的生成XML文件内容。
    * 3，建立表格这步操作在什么地方？我看PDF里用的是sql语句...这些语句被封装在哪，还是cfg在执行时自动生成新表？
    * ---------------
    * 所以我将在早上睡醒以后试着写一个绿色版的Util,供我自己使用。
    * 我将实现以下五个功能：
    * 1，以单据ID/商品ID为主键的插入
    * 2，以单据ID/商品ID为主键的删除
    * 3，以单据ID/商品ID为主键的替换(update)
    * 4, 以单据ID/商品ID为主键的精准查询
    * 5，返回一组PO（分为返回所有和条件查询）
    * ps 我会尝试一下使用注释技术。
    *
    * ---------------
    * 膜一发专家，架构写的很有美感。
    * 王瑞华，2017，圣诞节凌晨
     */
    private Class<T> type;
    private SessionFactory sessionFactory;
    private Session session = null;

    public HibernateUtil_Green(Class<T> type) {
        this.type = type;
      
        sessionFactory  = new Configuration().configure().addPackage("PO").addAnnotatedClass(type).buildSessionFactory();
       // sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    public boolean delete(String id){
        //按照ID删除数据表项(需要把ID设为主键，下同)
        boolean res=true;
        session=sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.delete(session.get(type,id));
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
                System.out.println("删除失败");
            }
            res=false;
        }finally {
            session.close();
        }
         return res;
    }

    public boolean update(T po){
        //按照ID替换数据表项，因为ID作为主键不会变，所以替换应该是成功的
        boolean res=true;
        session=sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(po);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
                System.out.println("更新失败");

            }
            res=false;

        }finally {
            session.close();
        }
        return res;
    }

    public T get(String id){
        //按照id返回单个PO
        session=sessionFactory.openSession();
        Transaction tx=null;
        T po=null;
        try {
            tx=session.beginTransaction();
            po=session.get(type,id);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
                System.out.println("获取失败");

            }

        }finally {
            session.close();
        }
        return po;
    }

    public boolean insert(T po){
        //新增一个PO
        boolean res=true;
        session=sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            
            session.save(po);
            
            tx.commit();
            
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("新增失败，发生回滚");
                tx.rollback();

                //e.printStackTrace();

            }
            res=false;
        }
        catch(PersistenceException e){		//数据库中已有此主键
            if(tx!=null){
                tx.rollback();
            }
            System.out.println("主键已经存在");
            res=false;

        }
        finally {
            session.close();
        }
        return res;
    }

    public List<T> getList(){
        //返回一组对象
        session=sessionFactory.openSession();
        Transaction tx=null;
        List<T> list=null;
        try {
            tx=session.beginTransaction();
            String s0="FROM "+type.getName();
            list=session.createQuery(s0).list();
          /*  for(int i=0;i<list.size();i++){
                System.out.print(list.get(i));
            }*/
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
                System.out.println("新增失败");

            }

        }finally {
            session.close();
        }
        return list;

    }
}
