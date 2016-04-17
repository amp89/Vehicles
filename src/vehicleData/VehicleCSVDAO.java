package vehicleData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import vehicleController.VehicleFilter;

public class VehicleCSVDAO implements VehicleDAO {
	private List<Vehicle> vehicleListFull = new ArrayList<>();
	private final String csvFileName = "vehicle-specifications.csv";
//	private static int invalidDataCount;

	public VehicleCSVDAO() {

	}

	@Autowired
	private ApplicationContext appContext;

	@PostConstruct
	public void init() {
		//read in the data
		BufferedReader buf = null;
		try {
			InputStream is = appContext.getResource(csvFileName).getInputStream();
			buf = new BufferedReader(new InputStreamReader(is), 3000000);
			//start timing
			long start = System.currentTimeMillis();
			//the actually file reading is done in the readInFileMethod
			readInFile(buf);
			long stop = System.currentTimeMillis();
			//load time:
//			System.out.println("START TIME: " + start  + " STOP TIME: " + stop + " TIME ELAPSED: " + (stop - start));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//close the reader
			try {
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// initDAO()


	
	private void readInFile(BufferedReader buf) throws IOException {
		String line = "";
		while ((line = buf.readLine()) != null) {
			String[] tokens = line.split(",");
			//the data that i found for vehicles had some data that was out of place
			//due to time constrains, i handled this erroneous data by catching a
			//number format exception.  The data was throwing a number format exception because
			//in several places, the misplaced data was a string, and this DAO was trying to 
			//assign it to a int or double value.
			try {
				int vehicleID = Integer.parseInt(tokens[0].trim());
				int year = Integer.parseInt(tokens[1].trim());
				String make = tokens[2].trim();
				String model = tokens[3].trim();
				double mpgHighway = Double.parseDouble(tokens[4].trim());
				double mpgCity = Double.parseDouble(tokens[5].trim());
				// double mpgAverage; TODO: nothing from csv
				double carbonEmission = Double.parseDouble(tokens[12].trim());
				String transmission = normalizeTransmissionType(tokens[7].trim());
				String fuelType = normalizeFuelType(tokens[6].trim());
			
				String driveWheels = normalizeDriveWheels(tokens[8].trim());
				
				int numberOfCylinders = Integer.parseInt(tokens[9].trim());
				double displacement = Double.parseDouble(tokens[10].trim());
				boolean gasTaxRequired = checkGasTax(tokens[11].trim());
				vehicleListFull.add(new Vehicle(vehicleID, year, make, model, mpgHighway, mpgCity, carbonEmission,
						transmission, fuelType, driveWheels, numberOfCylinders, displacement, gasTaxRequired));
			} catch (NumberFormatException e) {
				//debugging stuff:
//				System.out.println("There was erroneous data in the csv file.");
//				invalidDataCount++;
//				System.out.println("The number of invalid data rows is: " + invalidDataCount);
//				System.out.println("VehicleCSVDAO caught the exception and will\ncontinue to read the file.");
//				e.printStackTrace();
				System.out.println("Bad line: " + e);
			}
		} // while line not null

	}// readin

	
	/*
	 * These next three methods are normalize methods.  some of the data was in different formats
	 * so this attempts to get it into one format.  For example, if two four when drive vehicles
	 * had their drive type as "four wheel drive" and "part time 4 wheel drive", the 
	 * normalizeDriveWheels() method would assign them both to "All or Four Wheel Drive" 
	 * 
	 */
	@Override
	public String normalizeFuelType(String fuelType){
		if(fuelType.toLowerCase().startsWith("die")){
			fuelType = "Diesel";
		}
		else if(fuelType.toLowerCase().startsWith("gas") || fuelType.toLowerCase().startsWith("reg") ){
			fuelType = "Gasoline";
		}
		else if(fuelType.toLowerCase().startsWith("prem") ){
			fuelType = "Premium";
		}
		else if(fuelType.toLowerCase().startsWith("mid") ){
			fuelType = "Midgrade";
		}
		else if(fuelType.toLowerCase().startsWith("ele") ){
			fuelType = "Electricity";
		}
		 return fuelType;
	}
	
	@Override
	public String normalizeTransmissionType(String transmission){
		if(transmission.toLowerCase().startsWith("man")){
			transmission = "Manual";
		}
		else if(transmission.toLowerCase().startsWith("auto")){
			transmission = "Automatic";
		}
		
		return transmission;
		
	}
	
	@Override
	public String normalizeDriveWheels(String driveWheels){
		if(driveWheels.toLowerCase().startsWith("rear")){
			driveWheels = "Rear Wheel Drive";
		}
		else if(driveWheels.toLowerCase().startsWith("front")){
			driveWheels = "Front Wheel Drive";
		}
		
		else if(driveWheels.toLowerCase().startsWith("4") || driveWheels.toLowerCase().startsWith("all") || driveWheels.toLowerCase().startsWith("part") ) {
			driveWheels = "All or Four Wheel Drive";
		}
		else if(driveWheels.toLowerCase().startsWith("2")){
			driveWheels = "2wd Unspecified";
		}
		
		
		return driveWheels;
	}
	
	/*
	 * changes a string to a boolean
	 */
	private boolean checkGasTax(String s) {
		switch (s.toLowerCase()) {
		case "t":
			return true;
		case "f":
			return false;
		default:
			return false;
		}

	}

	@Override
	public int getVehicleID() {
		
		return 0;
	}

	@Override
	public int getYear(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getYear();
			}
		}
		return 0;
	}

	@Override
	public String getMake(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getMake();
			}
		}
		return null;
	}

	@Override
	public String getModel(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getModel();
			}
		}
		return null;
	}

	@Override
	public double getMpgHighway(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getMpgHighway();
			}
		}
		return 0;
	}

	@Override
	public double getMpgCity(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getMpgCity();
			}
		}
		return 0;
	}

	@Override
	public double getMpgAverage(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getMpgAverage();
			}
		}
		return 0;
	}

	@Override
	public double getCarbonEmission(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getCarbonEmission();
			}
		}
		return 0;
	}

	@Override
	public String getTransmission(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getTransmission();
			}
		}
		return null;
	}

	@Override
	public String getFuelType(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getFuelType();
			}
		}
		return null;
	}

	@Override
	public String getDriveWheels(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getDriveWheels();
			}
		}
		return null;
	}

	@Override
	public int getNumberOfCylinders(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getVehicleID();
			}
		}
		return 0;
	}

	@Override
	public double getDisplacement(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.getDisplacement();
			}
		}
		return 0;
	}

	@Override
	public boolean getGasTaxRequired(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){
				return vehicle.isGasTaxRequired();
			}
		}
		return false;
	}

	@Override
	public List<Vehicle> getAllVehicles() {

		return vehicleListFull;
	}

	@Override
	public Vehicle getVehicleByID(int id) {
		for (Vehicle vehicle : vehicleListFull) {
			if (vehicle.getVehicleID() == id){ 
				return vehicle;
			
			}
		}
		return null;
	}

}
