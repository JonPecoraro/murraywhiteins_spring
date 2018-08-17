package site.companies;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import site.util.S3Util;

@Entity
public class RepresentedCompany {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String url;
	private String image;
	private int sortOrder;
	private Date dateCreated;
	private Date dateUpdated;
	
	public int getId() { return id; }
	public String getName() { return name; }
	public String getPhone() { return phone; }
	public String getUrl() { return url; }
	public String getImage() { return image; }
	public int getSortOrder() { return sortOrder; }
	public Date getDateCreated() { return dateCreated; }
	public Date getDateUpdated() { return dateUpdated; }
	
	public void setId(int newValue) { this.id = newValue; }
	public void setName(String newValue) { this.name = newValue; }
	public void setPhone(String newValue) { this.phone = newValue; }
	public void setUrl(String newValue) { this.url = newValue; }
	public void setImage(String newValue) { this.image = newValue; }
	public void setSortOrder(int newValue) { this.sortOrder = newValue; }
	public void setDateCreated(Date newValue) { this.dateCreated = newValue; }
	public void setDateUpdated(Date newValue) { this.dateUpdated = newValue; }
	
	public String getNameInCamelCase() {
		if (name == null || name.length() == 0) {
			return "";
		}
		
		String[] splitName = name.split(" ");
		String camelCaseName = splitName[0].substring(0, 1).toLowerCase() + splitName[0].substring(1);
		for (int i = 1; i < splitName.length; i++) {
			String word = splitName[i];
			camelCaseName += word.substring(0, 1).toUpperCase() + word.substring(1);
		}
		
		return camelCaseName;
	}
	
	public String getImageUrl() {
		return S3Util.getS3ImageLink(image);
	}
}
