package site.quotes.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HomeownersQuoteForm extends QuoteFormBase {
	@NotNull
	@Size(min=2)
	private String propertyAddress;
	
	@NotNull
	@Min(1700)
	private String yearBuilt;
	
	@NotNull
	@Min(200)
	private String squareFootage;
	
	private String updates;
	private String structureType;
	private String homeType;
	private String fireplace;
	private String foundation;
	private String heatingAndCoolingType;
	private String jewelry;
	private String jewelryWorth;
	private String alarmSystem;
	private String pets;
	private String homeLoan;
	private String homeLoanAmount;
	private String quoteAuto;
	
	public String getPropertyAddress() { return propertyAddress; }
	public String getYearBuilt() { return yearBuilt; }
	public String getSquareFootage() { return squareFootage; }
	public String getUpdates() { return updates; }
	public String getStructureType() { return structureType; }
	public String getHomeType() { return homeType; }
	public String getFireplace() { return fireplace; }
	public String getFoundation() { return foundation; }
	public String getHeatingAndCoolingType() { return heatingAndCoolingType; }
	public String getJewelry() { return jewelry; }
	public String getJewelryWorth() { return jewelryWorth; }
	public String getAlarmSystem() { return alarmSystem; }
	public String getPets() { return pets; }
	public String getHomeLoan() { return homeLoan; }
	public String getHomeLoanAmount() { return homeLoanAmount; }
	public String getQuoteAuto() { return quoteAuto; }

	public void setPropertyAddress(String newValue) { this.propertyAddress = newValue; }
	public void setYearBuilt(String newValue) { this.yearBuilt = newValue; }
	public void setSquareFootage(String newValue) { this.squareFootage = newValue; }
	public void setUpdates(String newValue) { this.updates = newValue; }
	public void setStructureType(String newValue) { this.structureType = newValue; }
	public void setHomeType(String newValue) { this.homeType = newValue; }
	public void setFireplace(String newValue) { this.fireplace = newValue; }
	public void setFoundation(String newValue) { this.foundation = newValue; }
	public void setHeatingAndCoolingType(String newValue) { this.heatingAndCoolingType = newValue; }
	public void setJewelry(String newValue) { this.jewelry = newValue; }
	public void setJewelryWorth(String newValue) { this.jewelryWorth = newValue; }
	public void setAlarmSystem(String newValue) { this.alarmSystem = newValue; }
	public void setPets(String newValue) { this.pets = newValue; }
	public void setHomeLoan(String newValue) { this.homeLoan = newValue; }
	public void setHomeLoanAmount(String newValue) { this.homeLoanAmount = newValue; }
	public void setQuoteAuto(String newValue) { this.quoteAuto = newValue; }
	
	@Override
	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Property Address:</b> " + propertyAddress + "<br />");
		emailBuilder.append("<b>Year Built:</b> " + yearBuilt + "<br />");
		emailBuilder.append("<b>Square Footage:</b> " + squareFootage + "<br />");
		emailBuilder.append("<b>Updates:</b> " + updates + "<br />");
		emailBuilder.append("<b>Structure Type:</b> " + structureType + "<br />");
		emailBuilder.append("<b>Home Type:</b> " + homeType + "<br />");
		emailBuilder.append("<b>Fireplace:</b> " + fireplace + "<br />");
		emailBuilder.append("<b>Foundation:</b> " + foundation + "<br />");
		emailBuilder.append("<b>Heating And Cooling Type:</b> " + heatingAndCoolingType + "<br />");
		emailBuilder.append("<b>Jewelry:</b> " + jewelry + "<br />");
		emailBuilder.append("<b>Jewelry Worth:</b> " + jewelryWorth + "<br />");
		emailBuilder.append("<b>Alarm System:</b> " + alarmSystem + "<br />");
		emailBuilder.append("<b>Pets:</b> " + pets + "<br />");
		emailBuilder.append("<b>Home Loan:</b> " + homeLoan + "<br />");
		emailBuilder.append("<b>Home Loan Amount:</b> " + homeLoanAmount + "<br />");
		emailBuilder.append("<b>Also Quote Auto:</b> " + quoteAuto);
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
		smsBuilder.append("Updates: " + updates + "\n");
		smsBuilder.append("Structure Type: " + structureType + "\n");
		smsBuilder.append("Home Type: " + homeType + "\n");
		smsBuilder.append("Fireplace: " + fireplace + "\n");
		smsBuilder.append("Foundation: " + foundation + "\n");
		smsBuilder.append("Heating And Cooling Type: " + heatingAndCoolingType + "\n");
		smsBuilder.append("Jewelry: " + jewelry + "\n");
		smsBuilder.append("Jewelry Worth: " + jewelryWorth + "\n");
		smsBuilder.append("Alarm System: " + alarmSystem + "\n");
		smsBuilder.append("Pets: " + pets + "\n");
		smsBuilder.append("Home Loan: " + homeLoan + "\n");
		smsBuilder.append("Home Loan Amount: " + homeLoanAmount + "\n");
		smsBuilder.append("Also Quote Auto: " + quoteAuto);

		return smsBuilder.toString();
	}

	@Override
	public String toString() {
		String str = super.toString();

		str += "propertyAddress: " + propertyAddress + "\n";
		str += "yearBuilt: " + yearBuilt + "\n";
		str += "squareFootage: " + squareFootage + "\n";
		str += "updates: " + updates + "\n";
		str += "structureType: " + structureType + "\n";
		str += "homeType: " + homeType + "\n";
		str += "fireplace: " + fireplace + "\n";
		str += "foundation: " + foundation + "\n";
		str += "heatingAndCoolingType: " + heatingAndCoolingType + "\n";
		str += "jewelry: " + jewelry + "\n";
		str += "jewelryWorth: " + jewelryWorth + "\n";
		str += "alarmSystem: " + alarmSystem + "\n";
		str += "pets: " + pets + "\n";
		str += "homeLoan: " + homeLoan + "\n";
		str += "homeLoanAmount: " + homeLoanAmount + "\n";
		str += "quoteAuto: " + quoteAuto + "\n";

		return str;
	}
}