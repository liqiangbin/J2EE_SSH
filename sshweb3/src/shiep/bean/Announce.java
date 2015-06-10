package shiep.bean;

import java.sql.Timestamp;

/**
 * Announce entity. @author MyEclipse Persistence Tools
 */

public class Announce implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp time;
	private String title;
	private String content;
	private String did;
	private Integer status;

	// Constructors

	/** default constructor */
	public Announce() {
	}

	/** minimal constructor */
	public Announce(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Announce(Integer id, Timestamp time, String title, String content,
			String did, Integer status) {
		this.id = id;
		this.time = time;
		this.title = title;
		this.content = content;
		this.did = did;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}