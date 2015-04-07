package cn.edu.sjtu.se.dclab.server.entity;

public class TenementServeForm {
	private String order_id;
	private int serve_id;
	private String serve_record;
	private int user_score;
	private String user_comment;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getServe_id() {
		return serve_id;
	}
	public void setServe_id(int serve_id) {
		this.serve_id = serve_id;
	}
	public String getServe_record() {
		return serve_record;
	}
	public void setServe_record(String serve_record) {
		this.serve_record = serve_record;
	}
	public int getUser_score() {
		return user_score;
	}
	public void setUser_score(int user_score) {
		this.user_score = user_score;
	}
	public String getComment() {
		return user_comment;
	}
	public void setComment(String user_comment) {
		this.user_comment = user_comment;
	}
}
