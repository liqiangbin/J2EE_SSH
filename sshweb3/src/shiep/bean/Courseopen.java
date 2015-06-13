package shiep.bean;

/**
 * Courseopen entity. @author MyEclipse Persistence Tools
 */

public class Courseopen implements java.io.Serializable {

	// Fields

	private String id;
	private String unit;
	private String cid;
	private String cname;
	private Integer credit;
	private Integer teachingtime;
	private Integer testtime;
	private Integer year;

	// Constructors

	/** default constructor */
	public Courseopen() {
	}

	/** minimal constructor */
	public Courseopen(String id) {
		this.id = id;
	}

	/** full constructor */
	public Courseopen(String id, String unit, String cid, String cname,
			Integer credit, Integer teachingtime, Integer testtime, Integer year) {
		this.id = id;
		this.unit = unit;
		this.cid = cid;
		this.cname = cname;
		this.credit = credit;
		this.teachingtime = teachingtime;
		this.testtime = testtime;
		this.year = year;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getTeachingtime() {
		return this.teachingtime;
	}

	public void setTeachingtime(Integer teachingtime) {
		this.teachingtime = teachingtime;
	}

	public Integer getTesttime() {
		return this.testtime;
	}

	public void setTesttime(Integer testtime) {
		this.testtime = testtime;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}