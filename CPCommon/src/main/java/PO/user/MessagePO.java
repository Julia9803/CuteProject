package PO.user;

import java.io.Serializable;
import java.util.Date;

import util.UserType;

public class MessagePO implements Serializable{
	

	private static final long serialVersionUID = 6269106382064354686L;
	private int autoId;	//数据库中自动生成的id
	private String title;
	private String content;
	private Date date;
	private UserType type;
	
	public MessagePO(){}
	public MessagePO(String title, String content, Date date, UserType type) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.setType(type);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

}
