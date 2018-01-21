package VO.userVO;

import java.util.Date;

/**
 * 系统内发消息时传递的值对象
 * @author zxy
 *
 */
public class MessageVO {
	private String title;
	private String content;
	private Date date;
	
	
	public MessageVO(String title, String content, Date date) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
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

}
