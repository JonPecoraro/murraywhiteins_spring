package site.quotes.forms;

public class AutoQuoteForm extends QuoteFormBase {
	private String currentPremium;
	private String garagingAddress;
	private boolean nonDrivers;
	
	// Insured Drivers
	private String driverName;
	private String driverBirthday;
	private String driverSocial;
	private String driverLicense;
	private String driverState;
	
	// Vehicle Information
	private String vehicleYear;
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleVinNumber;
	private String vehicleMileage;
	private String vehicleUsage;
	private String vehicleFeatures;

	public String getCurrentPremium() { return currentPremium; }
	public String getGaragingAddress() { return garagingAddress; }
	public boolean getNonDrivers() { return nonDrivers; }
	public String getDriverName() { return driverName; }
	public String getDriverBirthday() { return driverBirthday; }
	public String getDriverSocial() { return driverSocial; }
	public String getDriverLicense() { return driverLicense; }
	public String getDriverState() { return driverState; }
	public String getVehicleYear() { return vehicleYear; }
	public String getVehicleMake() { return vehicleMake; }
	public String getVehicleModel() { return vehicleModel; }
	public String getVehicleVinNumber() { return vehicleVinNumber; }
	public String getVehicleMileage() { return vehicleMileage; }
	public String getVehicleUsage() { return vehicleUsage; }
	public String getVehicleFeatures() { return vehicleFeatures; }
	
	public void setCurrentPremium(String newValue) { this.currentPremium = newValue; }
	public void setGaragingAddress(String newValue) { this.garagingAddress = newValue; }
	public void setNonDrivers(boolean newValue) { this.nonDrivers = newValue; }
	public void setDriverName(String newValue) { this.driverName = newValue; }
	public void setDriverBirthday(String newValue) { this.driverBirthday = newValue; }
	public void setDriverSocial(String newValue) { this.driverSocial = newValue; }
	public void setDriverLicense(String newValue) { this.driverLicense = newValue; }
	public void setDriverState(String newValue) { this.driverState = newValue; }
	public void setVehicleYear(String newValue) { this.vehicleYear = newValue; }
	public void setVehicleMake(String newValue) { this.vehicleMake = newValue; }
	public void setVehicleModel(String newValue) { this.vehicleModel = newValue; }
	public void setVehicleVinNumber(String newValue) { this.vehicleVinNumber = newValue; }
	public void setVehicleMileage(String newValue) { this.vehicleMileage = newValue; }
	public void setVehicleUsage(String newValue) { this.vehicleUsage = newValue; }
	public void setVehicleFeatures(String newValue) { this.vehicleFeatures = newValue; }
	
	public String toEmailString() {
		String delimiter = "////";
		StringBuilder emailBuilder = new StringBuilder();

		emailBuilder.append(super.toEmailString());
		
		emailBuilder.append("<p>");
		emailBuilder.append("<b>Current Premium:</b> " + currentPremium + "<br />");
		emailBuilder.append("<b>Garaging Address:</b> " + garagingAddress + "<br />");
		emailBuilder.append("<b>Non-Drivers:</b> " + nonDrivers);
		emailBuilder.append("</p>");
		
		String[] driverNames = driverName.split(delimiter);
		String[] driverBirthdays = driverBirthday.split(delimiter);
		String[] driverSocials = driverSocial.split(delimiter);
		String[] driverLicenses = driverLicense.split(delimiter);
		String[] driverStates = driverState.split(delimiter);
		emailBuilder.append("<h3>Insured Drivers</h3>");
		for (int i = 1; i < driverNames.length; i++) {
			emailBuilder.append("<p>");
			emailBuilder.append("<b>Insured Driver " + i + ":</b><br />");
			emailBuilder.append("<b>Name:</b> " + driverNames[i] + "<br />");
			emailBuilder.append("<b>Birthday:</b> " + driverBirthdays[i] + "<br />");
			emailBuilder.append("<b>Social:</b> " + driverSocials[i] + "<br />");
			emailBuilder.append("<b>License:</b> " + driverLicenses[i] + "<br />");
			emailBuilder.append("<b>State:</b> " + driverStates[i]);
			emailBuilder.append("</p>");	
		}
		
		String[] vehicleYears = vehicleYear.split(delimiter);
		String[] vehicleMakes = vehicleMake.split(delimiter);
		String[] vehicleModels = vehicleModel.split(delimiter);
		String[] vehicleVinNumbers = vehicleVinNumber.split(delimiter);
		String[] vehicleMileages = vehicleMileage.split(delimiter);
		String[] vehicleUsages = vehicleUsage.split(delimiter);
		String[] allVehicleFeatures = vehicleFeatures.split(delimiter);
		emailBuilder.append("<h3>Vehicle Information</h3>");
		for (int i = 0; i < vehicleYears.length; i++) {
			emailBuilder.append("<p>");
			emailBuilder.append("<b>Vehicle " + (i+1) + " Information:</b><br />");
			emailBuilder.append("<b>Year:</b> " + vehicleYears[i] + "<br />");
			emailBuilder.append("<b>Make:</b> " + vehicleMakes[i] + "<br />");
			emailBuilder.append("<b>Model:</b> " + vehicleModels[i] + "<br />");
			emailBuilder.append("<b>VinNumber:</b> " + vehicleVinNumbers[i] + "<br />");
			emailBuilder.append("<b>Mileage:</b> " + vehicleMileages[i] + "<br />");
			emailBuilder.append("<b>Usage:</b> " + vehicleUsages[i] + "<br />");
			emailBuilder.append("<b>Features:</b> " + allVehicleFeatures[i]);
			emailBuilder.append("</p>");
		}
	
		return emailBuilder.toString();
	}
	
	public String toString() {
		String str = "";
	
		str += "currentPremium: " + currentPremium + "\n";
		str += "garagingAddress: " + garagingAddress + "\n";
		str += "nonDrivers: " + nonDrivers + "\n";
		str += "driverName: " + driverName + "\n";
		str += "driverBirthday: " + driverBirthday + "\n";
		str += "driverSocial: " + driverSocial + "\n";
		str += "driverLicense: " + driverLicense + "\n";
		str += "driverState: " + driverState + "\n";
		str += "vehicleYear: " + vehicleYear + "\n";
		str += "vehicleMake: " + vehicleMake + "\n";
		str += "vehicleModel: " + vehicleModel + "\n";
		str += "vehicleVinNumber: " + vehicleVinNumber + "\n";
		str += "vehicleMileage: " + vehicleMileage + "\n";
		str += "vehicleUsage: " + vehicleUsage + "\n";
		str += "vehicleFeatures: " + vehicleFeatures + "\n";
	
		return str;
	}
}