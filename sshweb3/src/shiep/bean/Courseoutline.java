package shiep.bean;

/**
 * Courseoutline entity. @author MyEclipse Persistence Tools
 */

public class Courseoutline implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String cid;
	private String tid;
	private String tname;
	private String did;
	private String address;
	private String term;
	private Integer status;
	private String message;

	// Constructors

	/** default constructor */
	public Courseoutline() {
	}

	/** full constructor */
	public Courseoutline(String name, String cid, String tid, String tname,
			String did, String address, String term, Integer status,
			String message) {
		this.name = name;
		this.cid = cid;
		this.tid = tid;
		this.tname = tname;
		this.did = did;
		this.address = address;
		this.term = term;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
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