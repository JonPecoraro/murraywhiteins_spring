package site.quotes.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FloodQuoteForm extends QuoteFormBase {
	@NotNull
	@Size(min=2)
	private String propertyAddress;
	
	@NotNull
	@Size(min=4)
	private String yearBuilt;
	
	@NotNull
	@Size(min=2)
	private String squareFootage;
	
	private String structureType;
	private String homeType;
	
	public String getPropertyAddress() { return propertyAddress; }
	public String getYearBuilt() { return yearBuilt; }
	public String getSquareFootage() { return squareFootage; }
	public String getStructureType() { return structureType; }
	public String getHomeType() { return homeType; }

	public void setPropertyAddress(String newValue) { this.propertyAddress = newValue; }
	public void setYearBuilt(String newValue) { this.yearBuilt = newValue; }
	public void setSquareFootage(String newValue) { this.squareFootage = newValue; }
	public void setStructureType(String newValue) { this.structureType = newValue; }
	public void setHomeType(String newValue) { this.homeType = newValue; }

	@Override
	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Property Address:</b> " + propertyAddress + "<br />");
		emailBuilder.append("<b>Year Built:</b> " + yearBuilt + "<br />");
		emailBuilder.append("<b>Square Footage:</b> " + squareFootage + "<br />");
		emailBuilder.append("<b>Structure Type:</b> " + structureType + "<br />");
		emailBuilder.append("<b>Home Type:</b> " + homeType);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}

	@Override
	public String toSmsString() {
		StringBuilder smsBuilder = new StringBuilder();

		smsBuilder.append(super.toSmsString());
		smsBuilder.append("Property Address: " + propertyAddress + "\n");
		smsBuilder.append("Year Built: " + yearBuilt + "\n");
		smsBuilder.append("Square Footage: " + squareFootage + "\n");
		smsBuilder.append("Structure Type: " + structureType + "\n");
		smsBuilder.append("Home Type: " + homeType);

		return smsBuilder.toString();
	}

	@Override
	public String toString() {
		String str = super.toString();

		str += "propertyAddress: " + propertyAddress + "\n";
		str += "yearBuilt: " + yearBuilt + "\n";
		str += "squareFootage: " + squareFootage + "\n";
		str += "structureType: " + structureType + "\n";
		str += "homeType: " + homeType + "\n";

		return str;
	}
}
