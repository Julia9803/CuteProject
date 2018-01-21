package VO.VIPVO;

import util.VIPGrade;
import util.VIPUtil;

public class VIPVO {
      public String id; //编号
      public String category; //分类
      VIPGrade grade; //级别
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

    public VIPVO(String id, String category, String grade, String name, String phoneNumber, String email, String address, String postCode, double collection, double collectionLimit, double payment, String clerk){
          this.id = id;
          this.category = category;
          this.grade = VIPGrade.getVIPGradeByString(grade);
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

    public VIPGrade getGrade() {
        return grade;
    }

    public void setGrade(VIPGrade grade) {
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
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + autoId;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((clerk == null) ? 0 : clerk.hashCode());
		long temp;
		temp = Double.doubleToLongBits(collection);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(collectionLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(payment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
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
		VIPVO other = (VIPVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (autoId != other.autoId)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (clerk == null) {
			if (other.clerk != null)
				return false;
		} else if (!clerk.equals(other.clerk))
			return false;
		if (Double.doubleToLongBits(collection) != Double.doubleToLongBits(other.collection))
			return false;
		if (Double.doubleToLongBits(collectionLimit) != Double.doubleToLongBits(other.collectionLimit))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (grade != other.grade)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(payment) != Double.doubleToLongBits(other.payment))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (state != other.state)
			return false;
		return true;
	}


    
}
