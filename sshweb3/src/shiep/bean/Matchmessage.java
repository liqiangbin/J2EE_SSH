package shiep.bean;

/**
 * Matchmessage entity. @author MyEclipse Persistence Tools
 */

public class Matchmessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String cid;
	private String cname;
	private String did;
	private Integer deptstatus;
	private String tid;
	private Integer tstatus;

	// Constructors

	/** default constructor */
	public Matchmessage() {
	}

	/** full constructor */
	public Matchmessage(String cid, String cname, String did,
			Integer deptstatus, String tid, Integer tstatus) {
		this.cid = cid;
		this.cname = cname;
		this.did = did;
		this.deptstatus = deptstatus;
		this.tid = tid;
		this.tstatus = tstatus;
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

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public Integer getDeptstatus() {
		return this.deptstatus;
	}

	public void setDeptstatus(Integer deptstatus) {
		this.deptstatus = deptstatus;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Integer getTstatus() {
		return this.tstatus;
	}

	public void setTstatus(Integer tstatus) {
		this.tstatus = tstatus;
	}

}