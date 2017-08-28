package site.common;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Testimonial {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String author;
	private String testimonial;
	private Date dateCreated;
	private Date dateUpdated;
	
	public int getId() { return id; }
	public String getAuthor() { return author; }
	public String getTestimonial() { return testimonial; }
	public Date getDateCreated() { return dateCreated; }
	public Date getDateUpdated() { return dateUpdated; }
	
	public void setId(int newValue) { this.id = newValue; }
	public void setAuthor(String newValue) { this.author = newValue; }
	public void setTestimonial(String newValue) { this.testimonial = newValue; }
	public void setDateCreated(Date newValue) { this.dateCreated = newValue; }
	public void setDateUpdated(Date newValue) { this.dateUpdated = newValue; }
}