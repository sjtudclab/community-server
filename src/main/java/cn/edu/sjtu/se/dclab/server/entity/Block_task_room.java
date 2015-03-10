package cn.edu.sjtu.se.dclab.server.entity;

public class Block_task_room {
    private Integer id;
    private String ans;
    private Integer is_finish;
    private Integer task;
    private String room;    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getAns() {
		return ans;
	}
	
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	public Integer getFinish() {
		return is_finish;
	}

	public void setFinish(Integer is_finish) {
		this.is_finish = is_finish;
	}		
	
	public Integer getTask() {
		return task;
	}

	public void setTask(Integer task) {
		this.task = task;
	}		
	
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}			
	
}

