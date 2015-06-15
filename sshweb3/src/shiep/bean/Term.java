package shiep.bean;

import java.util.Date;

/**
 * Term entity. @author MyEclipse Persistence Tools
 */

public class Term implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date starttime;
	private Date endtime;
	private String desc;

	// Constructors

	/** default constructor */
	public Term() {
	}

	/** full constructor */
	public Term(Date starttime, Date endtime, String desc) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.desc = desc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}