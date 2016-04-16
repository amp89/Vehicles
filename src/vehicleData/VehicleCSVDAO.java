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

public class VehicleCSVDAO implements VehicleDAO {
	private List<Vehicle> vehicleListFull = new ArrayList<>();
	private final String csvFileName = "vehicle-specifications.csv";
	private static int invalidDataCount;

	public VehicleCSVDAO() {

	}

	@Autowired
	private ApplicationContext appContext;

	@PostConstruct
	public void init() { // TODO: THIS HAS TO BE INIT???????
		BufferedReader buf = null;
		try {
			InputStream is = appContext.getResource(csvFileName).getInputStream();
			buf = new BufferedReader(new InputStreamReader(is), 3000000);
			//start timing
			long start = System.currentTimeMillis();
			readInFile(buf);
			long stop = System.currentTimeMillis();
			System.out.println("START TIME: " + start  + " STOP TIME: " + stop + " TIME ELAPSED: " + (stop - start));
//			end timing
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// initDAO()

	public void readInFile(BufferedReader buf) throws IOException {
		String line = "";
		while ((line = buf.readLine()) != null) {
			String[] tokens = line.split(",");
			try {
				int vehicleID = Integer.parseInt(tokens[0].trim());
				int year = Integer.parseInt(tokens[1].trim());
				String make = tokens[2].trim();
				String model = tokens[3].trim();
				double mpgHighway = Double.parseDouble(tokens[4].trim());
				double mpgCity = Double.parseDouble(tokens[5].trim());
				// double mpgAverage; TODO: nothing from csv
				double carbonEmission = Double.parseDouble(tokens[12].trim());
				String transmission = tokens[7].trim();
				String fuelType = tokens[6].trim();
				String driveWheels = tokens[8].trim();
				int numberOfCylinders = Integer.parseInt(tokens[9].trim());
				double displacement = Double.parseDouble(tokens[10].trim());
				boolean gasTaxRequired = checkGasTax(tokens[11].trim());
				vehicleListFull.add(new Vehicle(vehicleID, year, make, model, mpgHighway, mpgCity, carbonEmission,
						transmission, fuelType, driveWheels, numberOfCylinders, displacement, gasTaxRequired));
			} catch (NumberFormatException e) {
//				System.out.println("There was erroneous data in the csv file.");
//				invalidDataCount++;
//				System.out.println("The number of invalid data rows is: " + invalidDataCount);
//				System.out.println("VehicleCSVDAO caught the exception and will\ncontinue to read the file.");
//				e.printStackTrace();
				System.out.println(e);
			}
		} // while line not null
		//TODO: print lines removed
//		for (Vehicle vehicle : vehicleListFull) {
//			System.out.println(vehicle);
//		}
	}// readin

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMake(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getMpgHighway(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMpgCity(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMpgAverage(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCarbonEmission(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTransmission(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFuelType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDriveWheels(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfCylinders(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDisplacement(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getGasTaxRequired(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vehicleListFull;
	}

}
