package site.quotes.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RentersQuoteForm extends QuoteFormBase {
	@NotNull
	@Size(min=2)
	private String propertyAddress;
	
	@NotNull
	@Size(min=4)
	private String yearBuilt;
	
	private String structureType;
	private String homeType;
	
	@NotNull
	@Size(min=1)
	private String personalPropertyValue;
	
	public String getPropertyAddress() { return propertyAddress; }
	public String getYearBuilt() { return yearBuilt; }
	public String getStructureType() { return structureType; }
	public String getHomeType() { return homeType; }
	public String getPersonalPropertyValue() { return personalPropertyValue; }

	public void setPropertyAddress(String newValue) { this.propertyAddress = newValue; }
	public void setYearBuilt(String newValue) { this.yearBuilt = newValue; }
	public void setStructureType(String newValue) { this.structureType = newValue; }
	public void setHomeType(String newValue) { this.homeType = newValue; }
	public void setPersonalPropertyValue(String newValue) { this.personalPropertyValue = newValue; }

	@Override
	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Property Address:</b> " + propertyAddress + "<br />");
		emailBuilder.append("<b>Year Built:</b> " + yearBuilt + "<br />");
		emailBuilder.append("<b>Structure Type:</b> " + structureType + "<br />");
		emailBuilder.append("<b>Home Type:</b> " + homeType + "<br />");
		emailBuilder.append("<b>Personal Property Value:</b> " + personalPropertyValue);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}

	@Override
	public String toSmsString() {
		StringBuilder smsBuilder = new StringBuilder();

		smsBuilder.append(super.toSmsString());
		smsBuilder.append("Property Address: " + propertyAddress + "\n");
		smsBuilder.append("Year Built: " + yearBuilt + "\n");
		smsBuilder.append("Structure Type: " + structureType + "\n");
		smsBuilder.append("Home Type: " + homeType + "\n");
		smsBuilder.append("Personal Property Value: " + personalPropertyValue);

		return smsBuilder.toString();
	}

	@Override
	public String toString() {
		String str = super.toString();

		str += "propertyAddress: " + propertyAddress + "\n";
		str += "yearBuilt: " + yearBuilt + "\n";
		str += "structureType: " + structureType + "\n";
		str += "homeType: " + homeType + "\n";
		str += "personalPropertyValue: " + personalPropertyValue + "\n";

		return str;
	}
}