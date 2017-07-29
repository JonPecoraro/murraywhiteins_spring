package site.quotes.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LifeQuoteForm extends QuoteFormBase {
	@NotNull
	@Size(min=1)
	private String lifeInsuranceType;
	
	@NotNull
	@Size(min=1)
	private String requestedLimit;
	
	@NotNull
	@Size(min=1)
	private String annualIncome;
	
	@NotNull
	@Size(min=2)
	private String beneficiary;
	
	public String getLifeInsuranceType() { return lifeInsuranceType; }
	public String getRequestedLimit() { return requestedLimit; }
	public String getAnnualIncome() { return annualIncome; }
	public String getBeneficiary() { return beneficiary; }

	public void setLifeInsuranceType(String newValue) { this.lifeInsuranceType = newValue; }
	public void setRequestedLimit(String newValue) { this.requestedLimit = newValue; }
	public void setAnnualIncome(String newValue) { this.annualIncome = newValue; }
	public void setBeneficiary(String newValue) { this.beneficiary = newValue; }

	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Life Insurance Type:</b> " + lifeInsuranceType + "<br />");
		emailBuilder.append("<b>Requested Limit:</b> " + requestedLimit + "<br />");
		emailBuilder.append("<b>Annual Income:</b> " + annualIncome + "<br />");
		emailBuilder.append("<b>Beneficiary:</b> " + beneficiary);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}

	public String toString() {
		String str = super.toString();

		str += "lifeInsuranceType: " + lifeInsuranceType + "\n";
		str += "requestedLimit: " + requestedLimit + "\n";
		str += "annualIncome: " + annualIncome + "\n";
		str += "beneficiary: " + beneficiary + "\n";

		return str;
	}
}