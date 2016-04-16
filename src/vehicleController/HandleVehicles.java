package vehicleController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import vehicleData.Vehicle;
import vehicleData.VehicleDAO;
import vehicleData.VehicleParameters;

@Controller
@SessionAttributes({ "sessionAttribute", "vehicleListFull", "vehicleListRange", "vehicleToModify" }) // TODO
																										// dlt
																										// sess
																										// attr

public class HandleVehicles {

	@Autowired
	private VehicleDAO vehicleDAO;

	// init list on index.html get request
	@RequestMapping("initPage.do")
	public ModelAndView initilizeListAndIndex(@ModelAttribute("vehicleListFull") List<Vehicle> vl) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vehicleListFull", vl);
		mv.addObject("length", vl.size()); //TODO: is this really needed
		mv.setViewName("index.jsp");
		return mv;
	}

	@ModelAttribute("vehicleListRange")
	public List<Vehicle> initVehicleListRange() {
		System.out.println("Making vlr list");

		return new ArrayList<>();
	}

	@ModelAttribute("vehicleListFull")
	public List<Vehicle> initVehicleListFull() {
		System.out.println("Retrieving vehicles");
		List<Vehicle> v = vehicleDAO.getAllVehicles();
		System.out.println("IN INIT.  VEHICLE LIST SIZE::: " + v.size());
		return v;

	}

	@ModelAttribute("sessionAttribute")
	public String initFakeAttribute() { // TODO DEFINITELY DELETE THIS
		System.out.println("DEBUG MADE ATTRIBUTE");
		return "what the fuck";
	}

	// @RequestMapping("randomshit.do") // TODO DELETE THIS
	// public ModelAndView testDeleteThisMethod(@RequestParam("stupid") String
	// stupid,
	// @ModelAttribute("sessionAttribute") String sessionAttribute) {
	// System.out.println("DEBUG REQ MAPPING");
	// System.out.println(stupid);
	// System.out.println(sessionAttribute);
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("index.jsp");
	// mv.addObject("sessiontest", sessionAttribute);
	// mv.addObject("test", stupid);
	// return mv;
	// }
	
	@RequestMapping(path = "addVehicle.do")
	public ModelAndView addVehcile(Vehicle vehicle, @ModelAttribute("vehicleListFull") List<Vehicle> fullVehicleList){
		ModelAndView mv = new ModelAndView();
		System.out.println("ADDED: " + vehicle);
		fullVehicleList.add(vehicle);
		
		mv.setViewName("index.jsp");		
		
		return mv;
		
	}

	@RequestMapping(path = "modifyVehicle.do")
	public ModelAndView modifyVehicle(Vehicle vehicle, @ModelAttribute("vehicleListFull") List<Vehicle> fullVehicleList,
			@RequestParam("choice") String choice) {
		System.out.println("in modify Vehicle");
		ModelAndView mv = new ModelAndView();
		/*
		 * TODO: switch to methods
		 */


		System.out.println(vehicle);
		// mod works here
		// replace vehicle
		int idToChange = vehicle.getVehicleID();
		int i = 0;
		System.out.println("BEFORE LOOP THING");
		for (; i < fullVehicleList.size(); i++) {
			if (idToChange == fullVehicleList.get(i).getVehicleID()) {
				break;
			}
		}
		if(i > fullVehicleList.size()){
			System.out.println("Vehicle Not Found");
		}
		switch (choice) {
		case "modify":
			System.out.println("MODIFY STUFF HERE");
			System.out.println(idToChange);
			System.out.println("NOW SET VEHICLE");
			fullVehicleList.set(i, vehicle);
			break;
		case "delete":
			System.out.println("BREAK STUFF HERE");
			System.out.println(idToChange);
			System.out.println("NOW SET VEHICLE");
			fullVehicleList.remove(i);
			break;
		}

		// Vehicle v = new Vehicle();

//		mv.addObject("vehicle", vehicle);
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping(path = "findrange.do")
	public ModelAndView findVehicleRange(VehicleParameters vp,
			@ModelAttribute("vehicleListFull") List<Vehicle> vehicleListFull,
			@ModelAttribute("vehicleListRange") List<Vehicle> vlr)

	{
		System.out.println("find vehicle range method....");
		ModelAndView mv = new ModelAndView();
		// get vehicle range method
		System.out.println(vehicleListFull.size());
		vlr.clear();
		vlr = getVehicleRange(vp, vehicleListFull);
		// attach to mv
		mv.addObject("vehicleListRange", vlr);
		mv.addObject("vehicleParameters", vp);
		// set mv name
		mv.setViewName("findrange.jsp");
		System.out.println("done!!!@#$%^&*()");
		return mv;

	}

	private List<Vehicle> getVehicleRange(VehicleParameters vp, List<Vehicle> vehicleListFull) {
		System.out.println("DEBUG: Getting range");
		List<Vehicle> vehicleRange = new ArrayList<>();
		vehicleRange.addAll(vehicleListFull);
		// List<Vehicle> vehicleRange = new ArrayList<>();//vehicleListFull;
		// vehicleRange.add(vehicleListFull.get(0));
		// System.out.println(vehicleRange);
		System.out.println("LIST SIZE: " + vehicleRange.size());
		/*
		 * TODO check null numberics
		 */
		if (vp.getYearStart() == null) {
			vp.setYearStart(0);
		}
		if (vp.getYearEnd() == null) {
			vp.setYearEnd(0);
		}
		if (vp.getMpg() == null) {
			vp.setMpg(0.0);
		}
		if (vp.getNumberOfCylinders() == null) {
			vp.setNumberOfCylinders(0);
		}
		if (vp.getDisplacement() == null) {
			vp.setDisplacement(0.0);
		}

		/*
		 * TODO combine into one
		 */
		Iterator<Vehicle> yearIterator = vehicleRange.iterator();
		while (yearIterator.hasNext()) {
			Vehicle v = yearIterator.next();
			if ((v.getYear() < vp.getYearStart()) || (v.getYear() > vp.getYearEnd())) {
				yearIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

		Iterator<Vehicle> makeIterator = vehicleRange.iterator();
		while (makeIterator.hasNext()) {
			Vehicle v = makeIterator.next();
			if (!v.getMake().toLowerCase().contains(vp.getMake().trim().toLowerCase())) {
				makeIterator.remove();
				// System.out.println("thing:" + v);
			}
		}
		Iterator<Vehicle> modelIterator = vehicleRange.iterator();
		while (modelIterator.hasNext()) {
			Vehicle v = modelIterator.next();
			if (!v.getModel().toLowerCase().contains(vp.getModel().trim().toLowerCase())) {
				modelIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

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

		Iterator<Vehicle> transmissionIterator = vehicleRange.iterator();
		while (transmissionIterator.hasNext()) {
			Vehicle v = transmissionIterator.next();
			if (!v.getTransmission().toLowerCase().contains(vp.getTransmission().trim().toLowerCase())) {
				transmissionIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

		Iterator<Vehicle> fuelTypeIterator = vehicleRange.iterator();
		while (fuelTypeIterator.hasNext()) {
			Vehicle v = fuelTypeIterator.next();
			if (!v.getFuelType().toLowerCase().contains(vp.getFuelType().trim().toLowerCase())) {
				fuelTypeIterator.remove();
				// System.out.println("thing:" + v);
			}
		}

		Iterator<Vehicle> driveWheelIterator = vehicleRange.iterator();
		while (driveWheelIterator.hasNext()) {
			Vehicle v = driveWheelIterator.next();
			if (!v.getDriveWheels().toLowerCase().contains(vp.getDriveWheels().trim().toLowerCase())) {
				driveWheelIterator.remove();
				// System.out.println("thing:" + v);
			}
		}
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
		Iterator<Vehicle> gasTaxIterator = vehicleRange.iterator();
		while (gasTaxIterator.hasNext()) {
			Vehicle v = gasTaxIterator.next();
			if (!v.isGasTaxRequired() && vp.getGasTax().trim().toLowerCase().startsWith("t")) {
				gasTaxIterator.remove();
			}

			if (v.isGasTaxRequired() && vp.getGasTax().trim().toLowerCase().startsWith("f")) {
				gasTaxIterator.remove();
			}

		}

		System.out.println("LIST SIZE: " + vehicleRange.size());

		return vehicleRange;
	}// method end - get range

	@RequestMapping("menuchoice.do")
	public ModelAndView pageDirection(@ModelAttribute("vehicleListRange") List<Vehicle> vlr,
			@ModelAttribute("vehicleListFull") List<Vehicle> vlf, @RequestParam("id") Integer vehicleID,
			@RequestParam("selection") String s) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("vehicleListFull", vlf);
		mv.addObject("vehicleListRange", vlr);
		System.out.println("ID TO MODIFY: " + vehicleID);
		// handle id inputs (for add/replace/update)
		if (vehicleID != null) {
			for (Vehicle vehicle : vlf) {
				if (vehicle.getVehicleID() == vehicleID) {
					mv.addObject("vehicleToModify", vehicle);
				}

			}
		}
		switch (s) {
		case "all":
			mv.setViewName("viewall.jsp");
			break;
		case "range":
			mv.setViewName("findrange.jsp");
			mv.addObject("vehicleParameters", new VehicleParameters());
			break;
		case "add":
			mv.addObject("nextID", vlf.size());
			mv.addObject("vehicle",new Vehicle());
			mv.setViewName("add.jsp");
			break;
		case "remove":
			mv.setViewName("remove.jsp");
			break;
		case "modify":
			mv.setViewName("modify.jsp");
			System.out.println("TO MOD TO MOD TO MOD " + vehicleID);
			Vehicle vehicleToMod = null;
			for (Vehicle vehicle : vlf) {
				if (vehicle.getVehicleID() == vehicleID) {
					vehicleToMod = vehicle;
				}
			}
			System.out.println(vehicleToMod);
			mv.addObject("vehicle", vehicleToMod);
			break;
		default:
			break;
		}
		return mv;

	}
}
