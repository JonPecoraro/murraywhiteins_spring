package site.users;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private Date dateCreated;
	private Date dateUpdated;
	
	public int getId() { return id; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public Date getDateCreated() { return dateCreated; }
	public Date getDateUpdated() { return dateUpdated; }
	
	public void setId(int newValue) { this.id = newValue; }
	public void setName(String newValue) { this.name = newValue; }
	public void setEmail(String newValue) { this.email = newValue; }
	public void setPassword(String newValue) { this.password = newValue; }
	public void setDateCreated(Date newValue) { this.dateCreated = newValue; }
	public void setDateUpdated(Date newValue) { this.dateUpdated = newValue; }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dateCreated="
				+ dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
}
