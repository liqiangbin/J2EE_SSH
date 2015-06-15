package shiep.bean;

/**
 * Sortprogress entity. @author MyEclipse Persistence Tools
 */

public class Sortprogress implements java.io.Serializable {

	// Fields

	private Short id;
	private String did;
	private String cid;
	private String cname;
	private String tid;
	private String tname;
	private Integer status;
	private String type;
	private String term;

	// Constructors

	/** default constructor */
	public Sortprogress() {
	}

	/** full constructor */
	public Sortprogress(String did, String cid, String cname, String tid,
			String tname, Integer status, String type, String term) {
		this.did = did;
		this.cid = cid;
		this.cname = cname;
		this.tid = tid;
		this.tname = tname;
		this.status = status;
		this.type = type;
		this.term = term;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

}