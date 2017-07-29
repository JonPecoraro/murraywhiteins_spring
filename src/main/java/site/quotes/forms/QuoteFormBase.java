package site.quotes.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class QuoteFormBase {
	@NotNull
	@Size(min=5, max=75)
	private String name;
	
	@NotNull
	@Size(min=2)
	private String mailingAddress;
	
	@NotNull
	private String birthday;
	
	@NotNull
	@Size(min=7, max=14)
	@Pattern(regexp="(\\(\\d{3}\\)[ ]{0,1}\\d{3}-\\d{4})|(^\\d{3}-\\d{3}-\\d{4})|\\d{10}|\\d{7}")
	private String phone;
	
	private String county;
	
	@Pattern(regexp=".+@.+\\..+")
	private String email;
	
	private String contactPreference;
	
	public String getName() { return name; }
	public String getMailingAddress() { return mailingAddress; }
	public String getBirthday() { return birthday; }
	public String getPhone() { return phone; }
	public String getCounty() { return county; }
	public String getEmail() { return email; }
	public String getContactPreference() { return contactPreference; }

	public void setName(String newValue) { this.name = newValue; }
	public void setMailingAddress(String newValue) { this.mailingAddress = newValue; }
	public void setBirthday(String newValue) { this.birthday = newValue; }
	public void setPhone(String newValue) { this.phone = newValue; }
	public void setCounty(String newValue) { this.county = newValue; }
	public void setEmail(String newValue) { this.email = newValue; }
	public void setContactPreference(String newValue) { this.contactPreference = newValue; }
	
	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Name:</b> " + name + "<br />");
		emailBuilder.append("<b>Mailing Address:</b> " + mailingAddress + "<br />");
		emailBuilder.append("<b>Birthday:</b> " + birthday + "<br />");
		emailBuilder.append("<b>Phone:</b> " + phone + "<br />");
		emailBuilder.append("<b>County:</b> " + county + "<br />");
		emailBuilder.append("<b>Email:</b> " + email + "<br />");
		emailBuilder.append("<b>Contact Preference:</b> " + contactPreference);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}

	public String toString() {
		String str = "";

		str += "name: " + name + "\n";
		str += "mailingAddress: " + mailingAddress + "\n";
		str += "birthday: " + birthday + "\n";
		str += "phone: " + phone + "\n";
		str += "county: " + county + "\n";
		str += "email: " + email + "\n";
		str += "contactPreference: " + contactPreference + "\n";

		return str;
	}
}
