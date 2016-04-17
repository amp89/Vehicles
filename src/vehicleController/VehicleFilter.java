package vehicleController;

import java.util.Iterator;
import java.util.List;

import vehicleData.Vehicle;
import vehicleData.VehicleParameters;
/*
 * vehicle filter filters out unwanted vehicles from the range list passed in
 */
public class VehicleFilter {
	protected static List<Vehicle> filterVehicles(List<Vehicle> vehicleRange, VehicleParameters vp) {
		vehicleRange = filterYear(vehicleRange, vp);
		vehicleRange = filterMake(vehicleRange, vp);
		vehicleRange = filterModel(vehicleRange, vp);
		vehicleRange = filterMpg(vehicleRange, vp);
		vehicleRange = filterTransmission(vehicleRange, vp);
		vehicleRange = filterFuelType(vehicleRange, vp);
		vehicleRange = filterDriveWheels(vehicleRange, vp);
		vehicleRange = filterCylinders(vehicleRange, vp);
		vehicleRange = filterDisplacement(vehicleRange, vp);
		vehicleRange = filterGasTax(vehicleRange, vp);

		return vehicleRange;
	}

	/*
	 * There is a method for each parameter, the VehicleParameters object passed in contains the criteria
	 * and an iterator loops through the vehicleRange list, and removes the data that does not 
	 * fit the specified criteria
	 */
	private static List<Vehicle> filterYear(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> yearIterator = vehicleRange.iterator();
		while (yearIterator.hasNext()) {
			Vehicle v = yearIterator.next();
			if ((v.getYear() < vp.getYearStart()) || (v.getYear() > vp.getYearEnd())) {
				yearIterator.remove();
				// System.out.println("thing:" + v);
			}
		}
		return vehicleRange;
	}

	private static List<Vehicle> filterMake(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> makeIterator = vehicleRange.iterator();
		while (makeIterator.hasNext()) {
			Vehicle v = makeIterator.next();
			if (!v.getMake().toLowerCase().contains(vp.getMake().trim().toLowerCase())) {
				makeIterator.remove();
				// System.out.println("thing:" + v);
			}
		}
		return vehicleRange;
	}

	private static List<Vehicle> filterModel(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> modelIterator = vehicleRange.iterator();
		while (modelIterator.hasNext()) {
			Vehicle v = modelIterator.next();
			if (!v.getModel().toLowerCase().contains(vp.getModel().trim().toLowerCase())) {
				modelIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

		return vehicleRange;
	}

	private static List<Vehicle> filterMpg(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> mpgIterator = vehicleRange.iterator();
		while (mpgIterator.hasNext()) {
			Vehicle v = mpgIterator.next();
			switch (vp.getMpgBool()) {
			case "more":
				if (v.getMpgAverage() < vp.getMpg()) {
					mpgIterator.remove();
				}
				break;
			case "less":
				if (v.getMpgAverage() > vp.getMpg()) {
					mpgIterator.remove();
				}
				break;
			default:
				break;

			}
		}

		return vehicleRange;
	}

	private static List<Vehicle> filterTransmission(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> transmissionIterator = vehicleRange.iterator();
		while (transmissionIterator.hasNext()) {
			Vehicle v = transmissionIterator.next();
			if (!v.getTransmission().toLowerCase().contains(vp.getTransmission().trim().toLowerCase())) {
				transmissionIterator.remove();
				// System.out.println("thing:" + v);
			}
		}
		return vehicleRange;
	}

	private static List<Vehicle> filterFuelType(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> fuelTypeIterator = vehicleRange.iterator();
		while (fuelTypeIterator.hasNext()) {
			Vehicle v = fuelTypeIterator.next();
			if (!v.getFuelType().toLowerCase().contains(vp.getFuelType().trim().toLowerCase())) {
				fuelTypeIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

		return vehicleRange;
	}

	private static List<Vehicle> filterDriveWheels(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> driveWheelIterator = vehicleRange.iterator();
		while (driveWheelIterator.hasNext()) {
			Vehicle v = driveWheelIterator.next();
			if (!v.getDriveWheels().toLowerCase().contains(vp.getDriveWheels().trim().toLowerCase())) {
				driveWheelIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

		return vehicleRange;
	}

	private static List<Vehicle> filterCylinders(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> cylinderIterator = vehicleRange.iterator();
		while (cylinderIterator.hasNext()) {
			Vehicle v = cylinderIterator.next();
			switch (vp.getCylBool()) {
			case "more":
				if (v.getNumberOfCylinders() < vp.getNumberOfCylinders()) {
					cylinderIterator.remove();
				}
				break;
			case "less":
				if (v.getNumberOfCylinders() > vp.getNumberOfCylinders()) {
					cylinderIterator.remove();
				}
				break;
			default:
				break;

			}
		}
		return vehicleRange;
	}

	private static List<Vehicle> filterDisplacement(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> displacementIterator = vehicleRange.iterator();
		while (displacementIterator.hasNext()) {
			Vehicle v = displacementIterator.next();
			switch (vp.getDispBool()) {
			case "more":
				if (v.getDisplacement() < vp.getDisplacement()) {
					displacementIterator.remove();
				}
				break;
			case "less":
				if (v.getDisplacement() > vp.getDisplacement()) {
					displacementIterator.remove();
				}
				break;
			default:
				break;

			}
		}
		return vehicleRange;
	}

	private static List<Vehicle> filterGasTax(List<Vehicle> vehicleRange, VehicleParameters vp) {
		Iterator<Vehicle> gasTaxIterator = vehicleRange.iterator();
		while (gasTaxIterator.hasNext()) {
			Vehicle v = gasTaxIterator.next();
			// would not work without this cast
			if (!v.isGasTaxRequired() && vp.getGasTax().trim().toLowerCase().startsWith("t")) {
				gasTaxIterator.remove();
			}

			if (v.isGasTaxRequired() && vp.getGasTax().trim().toLowerCase().startsWith("f")) {
				gasTaxIterator.remove();
			}

		}

		System.out.println("LIST SIZE: " + vehicleRange.size());
		return vehicleRange;
	}
}
