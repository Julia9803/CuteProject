package VO.VIPVO;

import util.VIPUtil;

public class VIPVO {
      public String id; //编号
      public String category; //分类
      String grade; //级别
      String name; //姓名
      String phoneNumber;//电话号码
      String email; //电子邮箱
      String address; //地址
      String postCode; //邮编
      double collection;//应收
      double collectionLimit;//应收额度
      double payment; //应付
      String clerk; // 默认业务员
      int autoId;//数据库主键
      VIPUtil state = VIPUtil.EXIST;//会员状态 即是否被删除
//    private String VIPID;
//    private String VIPName;
//    private String VIPCategory;

    public VIPVO(String id, String category, String grade, String name, String phoneNumber, String email, String address, String postCode, double collection, double collectionLimit, double payment, String clerk){
          this.id = id;
          this.category = category;
          this.grade = grade;
          this.name=name;
    	  this.phoneNumber=phoneNumber;
          this.email=email;
          this.address=address;
    	  this.postCode = postCode;
    	  this.collection = collection;
    	  this.collectionLimit = collectionLimit;
    	  this.payment = payment;
    	  this.clerk = clerk;
      }
      
      @Override
      public String toString() {
    	  String result = "ID:" + id + "Category:" + category + "Grade:" + grade + "Name:" + name + "PhoneNumber:" + phoneNumber + "email:" + email + "Address:" + address + "LocationID:" + postCode + "Collection:" + collection + "CollectionLimit:" + collectionLimit + "Payment:" + payment + "Executive:" + clerk;
    	  return result;
      }

    public void setState(VIPUtil state) {
        this.state = state;
    }

    public VIPUtil getState() {
        return state;
    }

    public int getAutoId() {
          return autoId;
      }

    public void setAutoId(int autoId) {
          this.autoId = autoId;
      }
      
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public double getCollection() {
        return collection;
    }

    public void setCollection(double collection) {
        this.collection = collection;
    }

    public double getCollectionLimit() {
        return collectionLimit;
    }

    public void setCollectionLimit(double collectionLimit) {
        this.collectionLimit = collectionLimit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }
}
