package shiep.bean;

/**
 * Departmenthead entity. @author MyEclipse Persistence Tools
 */

public class Departmenthead implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String password;
	private String did;
	private String dname;

	// Constructors

	/** default constructor */
	public Departmenthead() {
	}

	/** minimal constructor */
	public Departmenthead(String id) {
		this.id = id;
	}

	/** full constructor */
	public Departmenthead(String id, String name, String sex, String phone,
			String email, String password, String did, String dname) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.did = did;
		this.dname = dname;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}