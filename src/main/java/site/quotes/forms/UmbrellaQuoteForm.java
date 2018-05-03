package site.quotes.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UmbrellaQuoteForm extends QuoteFormBase {
	@NotNull
	@Size(min=7)
	private String umbrellaLimit;
	
	@NotNull
	private String currentPolicies;
	
	private String propertyAndWatercraft;
	private String liabilityLimits;
	
	public String getUmbrellaLimit() { return umbrellaLimit; }
	public String getCurrentPolicies() { return currentPolicies; }
	public String getPropertyAndWatercraft() { return propertyAndWatercraft; }
	public String getLiabilityLimits() { return liabilityLimits; }

	public void setUmbrellaLimit(String newValue) { this.umbrellaLimit = newValue; }
	public void setCurrentPolicies(String newValue) { this.currentPolicies = newValue; }
	public void setPropertyAndWatercraft(String newValue) { this.propertyAndWatercraft = newValue; }
	public void setLiabilityLimits(String newValue) { this.liabilityLimits = newValue; }

	@Override
	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Umbrella Limit:</b> " + umbrellaLimit + "<br />");
		emailBuilder.append("<b>Current Policies:</b> " + currentPolicies + "<br />");
		emailBuilder.append("<b>Property And Watercraft:</b> " + propertyAndWatercraft + "<br />");
		emailBuilder.append("<b>Liability Limits:</b> " + liabilityLimits);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}

	@Override
	public String toSmsString() {
		StringBuilder smsBuilder = new StringBuilder();

		smsBuilder.append(super.toSmsString());
		smsBuilder.append("Umbrella Limit: " + umbrellaLimit + "\n");
		smsBuilder.append("Current Policies: " + currentPolicies + "\n");
		smsBuilder.append("Property And Watercraft: " + propertyAndWatercraft + "\n");
		smsBuilder.append("Liability Limits: " + liabilityLimits);

		return smsBuilder.toString();
	}

	@Override
	public String toString() {
		String str = super.toString();

		str += "umbrellaLimit: " + umbrellaLimit + "\n";
		str += "currentPolicies: " + currentPolicies + "\n";
		str += "propertyAndWatercraft: " + propertyAndWatercraft + "\n";
		str += "liabilityLimits: " + liabilityLimits + "\n";

		return str;
	}
}