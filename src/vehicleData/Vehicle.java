package vehicleData;

public class Vehicle {
	private int vehicleID;// 0

	private int year;// 1

	private String make;// 2

	private String model;// 3

	private double mpgHighway;// 4

	private double mpgCity;// 5

	private double mpgAverage;// no

	private double carbonEmission;// 12

	private String transmission;// 7

	private String fuelType;// 6

	private String driveWheels;// 8

	private int numberOfCylinders;// 9

	private double displacement;// 10
	private boolean gasTaxRequired;// 11

	public Vehicle() {
		this(99999, 0, null, null, 0, 0, 0, null, null, null, 0, 0, false);
	}

	public Vehicle(int vehicleID, int year, String make, String model, double mpgHighway, double mpgCity,
			double carbonEmission, String transmission, String fuelType, String driveWheels, int numberOfCylinders,
			double displacement, boolean gasTaxRequired) {
		super();
		this.vehicleID = vehicleID;
		this.year = year;
		this.make = make;
		this.model = model;
		this.mpgHighway = mpgHighway;
		this.mpgCity = mpgCity;
		this.setMpgAverage();
		this.carbonEmission = carbonEmission;
		this.transmission = transmission;
		this.fuelType = fuelType;
		this.driveWheels = driveWheels;
		this.numberOfCylinders = numberOfCylinders;
		this.displacement = displacement;
		this.gasTaxRequired = gasTaxRequired;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public double getMpgHighway() {
		return mpgHighway;
	}

	public void setMpgHighway(double mpgHighway) {
		this.mpgHighway = mpgHighway;
	}

	public double getMpgCity() {
		return mpgCity;
	}

	public void setMpgCity(double mpgCity) {
		this.mpgCity = mpgCity;
	}

	public double getMpgAverage() {
		// TODO: nothing from csv, do the fucking math you lazy bastard
		return (mpgHighway + mpgCity) / 2;
	}

	public void setMpgAverage() {
		this.mpgAverage = (mpgCity + mpgHighway) / 2.0;
	}

	public double getCarbonEmission() {
		return carbonEmission;
	}

	public void setCarbonEmission(double carbonEmission) {
		this.carbonEmission = carbonEmission;
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

	public int getNumberOfCylinders() {
		return numberOfCylinders;
	}

	public void setNumberOfCylinders(int numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}

	public double getDisplacement() {
		return displacement;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}

	public boolean isGasTaxRequired() {
		return gasTaxRequired;
	}

	public void setGasTaxRequired(boolean gasTaxRequired) {
		this.gasTaxRequired = gasTaxRequired;
	}

	public void setGasTaxRquired(String gasTaxRequired) {
		switch (gasTaxRequired.toLowerCase()) {
		case "true":
			this.gasTaxRequired = true;
			break;
		case "false":
			this.gasTaxRequired = false;
			break;
		default:
			break;

		}
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int uid) {
		this.vehicleID = uid;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", year=" + year + ", make=" + make + ", model=" + model
				+ ", mpgHighway=" + mpgHighway + ", mpgCity=" + mpgCity + ", mpgAverage=" + mpgAverage
				+ ", carbonEmission=" + carbonEmission + ", transmission=" + transmission + ", fuelType=" + fuelType
				+ ", driveWheels=" + driveWheels + ", numberOfCylinders=" + numberOfCylinders + ", displacement="
				+ displacement + ", gasTaxRequired=" + gasTaxRequired + "]";
	}

	// public void setMpgAverage(double mpgAverage) {
	// this.mpgAverage = mpgAverage;
	// }
	//

}
