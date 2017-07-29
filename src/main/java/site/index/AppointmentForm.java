package site.index;

public class AppointmentForm {
	private String name;
	private String phone;
	private String email;
	private Boolean emailUserAppointmentDetails;
	private String appointmentDate;
	private String appointmentTime;
	private String type;
	
	public String getName() { return name; }
	public String getPhone() { return phone; }
	public String getEmail() { return email; }
	public Boolean getEmailUserAppointmentDetails() { return emailUserAppointmentDetails; }
	public String getAppointmentDate() { return appointmentDate; }
	public String getAppointmentTime() { return appointmentTime; }
	public String getType() { return type; }

	public void setName(String newValue) { this.name = newValue; }
	public void setPhone(String newValue) { this.phone = newValue; }
	public void setEmail(String newValue) { this.email = newValue; }
	public void setEmailUserAppointmentDetails(Boolean newValue) { this.emailUserAppointmentDetails = newValue; }
	public void setAppointmentDate(String newValue) { this.appointmentDate = newValue; }
	public void setAppointmentTime(String newValue) { this.appointmentTime = newValue; }
	public void setType(String newValue) { this.type = newValue; }
	
	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Name:</b> " + name + "<br />");
		emailBuilder.append("<b>Phone:</b> " + phone + "<br />");
		emailBuilder.append("<b>Email:</b> " + email + "<br />");
		emailBuilder.append("<b>Appointment Date:</b> " + appointmentDate + " at " + appointmentTime + "<br />");
		emailBuilder.append("<b>Appointment Type:</b> " + type);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}
	
	public String toString() {
		String str = "";

		str += "name: " + name + "\n";
		str += "phone: " + phone + "\n";
		str += "email: " + email + "\n";
		str += "emailUserAppointmentDetails: " + emailUserAppointmentDetails + "\n";
		str += "appointmentDate: " + appointmentDate + "\n";
		str += "appointmentTime: " + appointmentTime + "\n";
		str += "type: " + type + "\n";

		return str;
	}
}
