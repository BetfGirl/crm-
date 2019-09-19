package model;
public class C_Client {

	private Integer id;
	private String name;
	
	private Integer sex;
	public static String[] sexs={"未知","女","男"};
	public String getSexs() {
		return sexs[sex];
	}
	
	private String tel;
	private String qq;
	private String email;
	private String infos;
	
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
		return client[purposestatus];
	}
	
	private Integer assessstatus;
	public static String[] assesss= {"下次再联系","无果","有预约"};
	public String getAssesss() {
		return client[assessstatus];
	}
	
	private Integer execstatus;
	public static String[]  exec= {"正常","转出","完成"};
	public String getExec() {
		return client[execstatus];
	}
	
	private Integer status;
	public static String[]  stttus= {"状态","公共","资料不全","无效"};
	public String getStttus() {
		return client[status];
	}
	
	private Integer clienttypeid;
	
	private String clienttype;
	public String getClienttype() {
		return clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

	private String operatorids;
	private Integer createoperatorid;
	
	private String operatorname;
	
	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	private String createdate;
	private Integer srcid;
	public static String[] srcids= {"内招","网投"};
	public String getSrcids() {
		return srcids[srcid];
	}
	
	private Integer count;
	private String comments;
	public Integer getId() {
		return id;
	}
	
	public C_Client() {
		super();
	}

	public C_Client(Integer id, String name, Integer sex, String tel, String qq, String email, String infos,
			Integer linkstatus, Integer clientstatus, Integer purposestatus, Integer assessstatus, Integer execstatus,
			Integer status, Integer clienttypeid, String operatorids, Integer createoperatorid, String createdate,
			Integer srcid, Integer count, String comments) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.qq = qq;
		this.email = email;
		this.infos = infos;
		this.linkstatus = linkstatus;
		this.clientstatus = clientstatus;
		this.purposestatus = purposestatus;
		this.assessstatus = assessstatus;
		this.execstatus = execstatus;
		this.status = status;
		this.clienttypeid = clienttypeid;
		this.operatorids = operatorids;
		this.createoperatorid = createoperatorid;
		this.createdate = createdate;
		this.srcid = srcid;
		this.count = count;
		this.comments = comments;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getClienttypeid() {
		return clienttypeid;
	}

	public void setClienttypeid(Integer clienttypeid) {
		this.clienttypeid = clienttypeid;
	}

	public String getOperatorids() {
		return operatorids;
	}

	public void setOperatorids(String operatorids) {
		this.operatorids = operatorids;
	}

	public Integer getCreateoperatorid() {
		return createoperatorid;
	}

	public void setCreateoperatorid(Integer createoperatorid) {
		this.createoperatorid = createoperatorid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Integer getSrcid() {
		return srcid;
	}

	public void setSrcid(Integer srcid) {
		this.srcid = srcid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}

