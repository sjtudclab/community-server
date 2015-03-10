package cn.edu.sjtu.se.dclab.server.entity;

public class Block_user {
    private Integer id;
    private String name;
    private Integer age;
    private String education; 
    private String marriage;    
    private String job;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}		
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}	
	
	public String getEducation() {
		return education;
	}
	
	public void setEducation(String education) {
		this.education = education;
	}
		
	public String getMarriage() {
		return marriage;
	}
	
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
			
}
