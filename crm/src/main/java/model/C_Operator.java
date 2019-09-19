package model;

public class C_Operator{
	
	private Integer id;
	private String tel;
	private String pass;
	private String name;
	private Integer groupid;
	
	private String workgroup;
	public String getWorkgroup() {
		return workgroup;
	}
	public void setWorkgroup(String workgroup) {
		this.workgroup = workgroup;
	}
	
	private Integer status;
	public static String[] statuss= {"正常","禁用"};
	public String getStatuss() {
		return statuss[status];
	}
	
	private Integer power;
	public static String[] powername= {"管理员","组长","组员"};
	public String getPowername() {
		return powername[power];
	}

	public C_Operator(String username, String string) {
		this.tel=username;
		this.pass=string;
	}

	public C_Operator(Integer id, String tel, String pass, String name, Integer groupid, Integer status, Integer power,
			String workgroup) {
		super();
		this.id = id;
		this.tel = tel;
		this.pass = pass;
		this.name = name;
		this.groupid = groupid;
		this.status = status;
		this.power = power;
		this.workgroup = workgroup;
	}
	
	public C_Operator() {
		super();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
