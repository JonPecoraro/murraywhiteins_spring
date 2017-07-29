package site.companies;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RepresentedCompany {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String phone;
	private String url;
	private String image;
	private Date dateCreated;
	private Date dateUpdated;
	
	public int getId() { return id; }
	public String getName() { return name; }
	public String getPhone() { return phone; }
	public String getUrl() { return url; }
	public String getImage() { return image; }
	public Date getDateCreated() { return dateCreated; }
	public Date getDateUpdated() { return dateUpdated; }
	
	public void setId(int newValue) { this.id = newValue; }
	public void setName(String newValue) { this.name = newValue; }
	public void setPhone(String newValue) { this.phone = newValue; }
	public void setUrl(String newValue) { this.url = newValue; }
	public void setImage(String newValue) { this.image = newValue; }
	public void setDateCreated(Date newValue) { this.dateCreated = newValue; }
	public void setDateUpdated(Date newValue) { this.dateUpdated = newValue; }
}
