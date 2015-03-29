package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by Huiyi on 2015/3/11.
 */
public class Role {
    private long id;
    private String name;
    private String description;
    private RoleType roleType;

    public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
