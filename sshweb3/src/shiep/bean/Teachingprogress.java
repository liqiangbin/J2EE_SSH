package shiep.bean;

/**
 * Teachingprogress entity. @author MyEclipse Persistence Tools
 */

public class Teachingprogress implements java.io.Serializable {

	// Fields

	private Integer id;
	private String cid;
	private String did;
	private String tid;
	private String tname;
	private String term;
	private String name;
	private String address;
	private Integer status;
	private String message;

	// Constructors

	/** default constructor */
	public Teachingprogress() {
	}

	/** full constructor */
	public Teachingprogress(String cid, String did, String tid, String tname,
			String term, String name, String address, Integer status,
			String message) {
		this.cid = cid;
		this.did = did;
		this.tid = tid;
		this.tname = tname;
		this.term = term;
		this.name = name;
		this.address = address;
		this.status = status;
		this.message = message;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
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

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}