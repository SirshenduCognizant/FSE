/**
 * 
 */
package com.fsd.assign.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 158797
 *
 */
@Entity
@Table(name="subject")
public class Subject{
	
	/**
	 * 
	 */
	
	@Id
	@Column(name = "subjectid", nullable = false)
	long subjectid;
	
	@Column(name = "subtitle", nullable = true)
	String subtitle;
	
	@Column(name = "durationInHours", nullable = true)
	int durationInHours;
	
	public Subject() {
		super();
	}
	
	public Subject(long subjectid, String subtitle, int durationInHours) {
		super();
		this.subjectid = subjectid;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}
	/**
	 * @return the subjectid
	 */
	public long getSubjectid() {
		return subjectid;
	}
	/**
	 * @param subjectid the subjectid to set
	 */
	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}
	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}
	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	/**
	 * @return the durationInHours
	 */
	public int getDurationInHours() {
		return durationInHours;
	}
	/**
	 * @param durationInHours the durationInHours to set
	 */
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
				+ "]";
	}
	
}
