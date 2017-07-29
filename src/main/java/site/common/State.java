package site.common;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String abbreviation;
	private String name;
	private Date dateCreated;
	private Date dateUpdated;
	
	public int getId() { return id; }
	public String getAbbreviation() { return abbreviation; }
	public String getName() { return name; }
	public Date getDateCreated() { return dateCreated; }
	public Date getDateUpdated() { return dateUpdated; }
	
	public void setId(int newValue) { this.id = newValue; }
	public void setAbbreviation(String newValue) { this.abbreviation = newValue; }
	public void setName(String newValue) { this.name = newValue; }
	public void setDateCreated(Date newValue) { this.dateCreated = newValue; }
	public void setDateUpdated(Date newValue) { this.dateUpdated = newValue; }
}
