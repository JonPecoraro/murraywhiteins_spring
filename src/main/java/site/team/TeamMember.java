package site.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeamMember {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String suffix;
	private String email;
	private String extension;
	private String position;
	private String qualifications;
	private String description;
	private String image;
	private String employmentDate;
	private int sortOrder;
	private String dateCreated;
	private String dateUpdated;
	
	public int getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getSuffix() { return suffix; }
	public String getEmail() { return email; }
	public String getExtension() { return extension; }
	public String getPosition() { return position; }
	public String getQualifications() { return qualifications; }
	public String getDescription() { return description; }
	public String getImage() { return image; }
	public String getEmploymentDate() { return employmentDate; }
	public int getSortOrder() { return sortOrder; }
	public String getDateCreated() { return dateCreated; }
	public String getDateUpdated() { return dateUpdated; }
	
	public void setId(int newValue) { this.id = newValue; }
	public void setFirstName(String newValue) { this.firstName = newValue; }
	public void setLastName(String newValue) { this.lastName = newValue; }
	public void setSuffix(String newValue) { this.suffix = newValue; }
	public void setEmail(String newValue) { this.email = newValue; }
	public void setExtension(String newValue) { this.extension = newValue; }
	public void setPosition(String newValue) { this.position = newValue; }
	public void setQualifications(String newValue) { this.qualifications = newValue; }
	public void setDescription(String newValue) { this.description = newValue; }
	public void setImage(String newValue) { this.image = newValue; }
	public void setEmploymentDate(String newValue) { this.employmentDate = newValue; }
	public void setSortOrder(int newValue) { this.sortOrder = newValue; }
	public void setDateCreated(String newValue) { this.dateCreated = newValue; }
	public void setDateUpdated(String newValue) { this.dateUpdated = newValue; }
	
	public String getFullName() {
		String fullName = firstName + " " + lastName;
		if (suffix != null) {
			fullName += ", " + suffix;
		}
		if (qualifications != null) {
			fullName += ", " + qualifications;
		}
		return fullName;
	}
	
	public String getLargeImageUrl() {
		return image.replace(".jpg", "_large.jpg");
	}
	
	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", suffix=" + suffix
				+ ", email=" + email + ", extension=" + extension + ", position=" + position + ", qualifications="
				+ qualifications + ", description=" + description + ", image=" + image + ", employmentDate="
				+ employmentDate + ", sortOrder=" + sortOrder + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + "]";
	}
}