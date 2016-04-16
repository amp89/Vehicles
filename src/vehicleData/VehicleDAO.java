package vehicleData;

import java.util.List;

public interface VehicleDAO {
//	public void init();
	
	public int getVehicleID();
	public int getYear(int id);
	public String getMake(int id);
	public String getModel(int id);
	public double getMpgHighway(int id);
	public double getMpgCity(int id);
	public double getMpgAverage(int id);
	public double getCarbonEmission(int id);
	public String getTransmission(int id);
	public String getFuelType(int id);
	public String getDriveWheels(int id);
	public int getNumberOfCylinders(int id);
	public double getDisplacement(int id);
	public boolean getGasTaxRequired(int id);
	
	public Vehicle getVehicleByID(int id);
	public List<Vehicle> getAllVehicles();
	
	
}
