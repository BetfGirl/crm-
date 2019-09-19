package model;

public class C_Revisit{

	private Integer id;
	private String clientid;
	
	private String clientname;
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	

	private Integer linkstatus;
	public static String[] link={"秒挂","未接通","有交流","深入交流"};
	public String getLink() {
		return link[linkstatus];
	}
	
	private Integer clientstatus;
	public static String[] client= {"排斥","推脱","后续","较好"};
	public String getClient() {
		return client[clientstatus];
	}
	
	private Integer purposestatus;
	public static String[] purpose= {"N","C","B","A","Y"};
	public String getPurpose() {
		return purpose[purposestatus];
	}
	
	private Integer assessstatus;
	public static String[] assesss= {"下次再联系","无果","有预约"};
	public String getAssesss() {
		return assesss[assessstatus];
	}
	
	private Integer execstatus;
	public static String[]  exec= {"正常","转出","完成"};
	public String getExec() {
		return exec[execstatus];
	}
	
	private String askinfo;
	private String followinfo;
	
	
	private String probleminfo;
	
	public static Integer status;
	public static String[]  sttatus= {"正常","隐藏"};
	public String getSttatus() {
		return sttatus[status];
	}
	
	private String comments;
	
	public C_Revisit() {
		super();
	}

	public C_Revisit(Integer id, String clientid, Integer linkstatus, Integer clientstatus, Integer purposestatus,
			Integer assessstatus, Integer execstatus, String askinfo, String followinfo, String probleminfo,
			Integer status, String comments) {
		super();
		this.id = id;
		this.clientid = clientid;
		this.linkstatus = linkstatus;
		this.clientstatus = clientstatus;
		this.purposestatus = purposestatus;
		this.assessstatus = assessstatus;
		this.execstatus = execstatus;
		this.askinfo = askinfo;
		this.followinfo = followinfo;
		this.probleminfo = probleminfo;
		this.status = status;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public Integer getLinkstatus() {
		return linkstatus;
	}

	public void setLinkstatus(Integer linkstatus) {
		this.linkstatus = linkstatus;
	}

	public Integer getClientstatus() {
		return clientstatus;
	}

	public void setClientstatus(Integer clientstatus) {
		this.clientstatus = clientstatus;
	}

	public Integer getPurposestatus() {
		return purposestatus;
	}

	public void setPurposestatus(Integer purposestatus) {
		this.purposestatus = purposestatus;
	}

	public Integer getAssessstatus() {
		return assessstatus;
	}

	public void setAssessstatus(Integer assessstatus) {
		this.assessstatus = assessstatus;
	}

	public Integer getExecstatus() {
		return execstatus;
	}

	public void setExecstatus(Integer execstatus) {
		this.execstatus = execstatus;
	}

	public String getAskinfo() {
		return askinfo;
	}

	public void setAskinfo(String askinfo) {
		this.askinfo = askinfo;
	}

	public String getFollowinfo() {
		return followinfo;
	}

	public void setFollowinfo(String followinfo) {
		this.followinfo = followinfo;
	}

	public String getProbleminfo() {
		return probleminfo;
	}

	public void setProbleminfo(String probleminfo) {
		this.probleminfo = probleminfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
