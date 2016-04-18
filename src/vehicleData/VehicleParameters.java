package vehicleData;

public class VehicleParameters {

	/*
	 * this class has vehicle serach parameters
	 * this allows the controller to recieve a VehicleParameters
	 * on a form submission.
	 */
	
	private Integer yearStart = 2016;
	private Integer yearEnd = 2016;
	private String make;
	private String model;
	private Double mpg;
	private String mpgBool = "";
	private String transmission;		
	private String fuelType;
	private String driveWheels;
	private Integer numberOfCylinders;
	private String cylBool = "";
	private Double displacement;
	private String dispBool = "";
	private String gasTax = "";
	
	
	public Integer getYearStart() {
		return yearStart;
	}
	public void setYearStart(Integer yearStart) {
		this.yearStart = yearStart;
	}
	public Integer getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(Integer yearEnd) {
		this.yearEnd = yearEnd;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getMpg() {
		return mpg;
	}
	public void setMpg(Double mpg) {
		this.mpg = mpg;
	}
	public String getMpgBool() {
		return mpgBool;
	}
	public void setMpgBool(String mpgBool) {
		this.mpgBool = mpgBool;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getDriveWheels() {
		return driveWheels;
	}
	public void setDriveWheels(String driveWheels) {
		this.driveWheels = driveWheels;
	}
	public Integer getNumberOfCylinders() {
		return numberOfCylinders;
	}
	public void setNumberOfCylinders(Integer numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}
	public String getCylBool() {
		return cylBool;
	}
	public void setCylBool(String cylBool) {
		this.cylBool = cylBool;
	}
	public Double getDisplacement() {
		return displacement;
	}
	public void setDisplacement(Double displacement) {
		this.displacement = displacement;
	}
	public String getDispBool() {
		return dispBool;
	}
	public void setDispBool(String dispBool) {
		this.dispBool = dispBool;
	}
	public String getGasTax() {
		return gasTax;
	}
	public void setGasTax(String gasTax) {
		this.gasTax = gasTax;
	}
	@Override
	public String toString() {
		return "VehicleParameters [yearStart=" + yearStart + ", yearEnd=" + yearEnd + ", make=" + make + ", model="
				+ model + ", mpg=" + mpg + ", mpgBool=" + mpgBool + ", transmission=" + transmission + ", fuelType="
				+ fuelType + ", driveWheels=" + driveWheels + ", numberOfCylinders=" + numberOfCylinders + ", cylBool="
				+ cylBool + ", displacement=" + displacement + ", dispBool=" + dispBool + ", gasTax=" + gasTax + "]";
	}
	
	
}
