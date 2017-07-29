package site.quotes.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OtherQuoteForm extends QuoteFormBase {
	@NotNull
	@Size(min=2)
	private String insuranceTypeRequested;
	
	@NotNull
	@Size(min=2)
	private String reasonForRequest;
	
	public String getInsuranceTypeRequested() { return insuranceTypeRequested; }
	public String getReasonForRequest() { return reasonForRequest; }

	public void setInsuranceTypeRequested(String newValue) { this.insuranceTypeRequested = newValue; }
	public void setReasonForRequest(String newValue) { this.reasonForRequest = newValue; }

	public String toEmailString() {
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Insurance Type Requested:</b> " + insuranceTypeRequested + "<br />");
		emailBuilder.append("<b>Reason For Request:</b> " + reasonForRequest);
		emailBuilder.append("</p>");

		return emailBuilder.toString();
	}

	public String toString() {
		String str = super.toString();

		str += "insuranceTypeRequested: " + insuranceTypeRequested + "\n";
		str += "reasonForRequest: " + reasonForRequest + "\n";

		return str;
	}
}
