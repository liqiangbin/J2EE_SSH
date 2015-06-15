package shiep.bean;

/**
 * Depart entity. @author MyEclipse Persistence Tools
 */

public class Depart implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String mid;

	// Constructors

	/** default constructor */
	public Depart() {
	}

	/** minimal constructor */
	public Depart(String id) {
		this.id = id;
	}

	/** full constructor */
	public Depart(String id, String name, String mid) {
		this.id = id;
		this.name = name;
		this.mid = mid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}