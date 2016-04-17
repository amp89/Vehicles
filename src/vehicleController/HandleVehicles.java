package vehicleController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import vehicleData.Vehicle;
import vehicleData.VehicleDAO;
import vehicleData.VehicleParameters;

@Controller
@SessionAttributes({ "vehicleListFull", "vehicleListRange", "vehicleToModify" }) // attributes
																					// reused
																					// throughout
																					// the
																					// session
public class HandleVehicles {

	@Autowired
	private VehicleDAO vehicleDAO;

	// This will initiate the full vehicle list on the first page load.
	// It was also necessary to add a "<welcome-file>" to the web.xml file
	// in order to make this happen.
	@RequestMapping("initPage.do")
	public ModelAndView initilizeListAndIndex(@ModelAttribute("vehicleListFull") List<Vehicle> vl) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vehicleListFull", vl);
		// mv.addObject("length", vl.size()); // TODO: is this really needed
		// TODO remove this
		mv.setViewName("index.jsp");
		return mv;
	}

	// initialize the vehicle range list session attribute
	@ModelAttribute("vehicleListRange")
	public List<Vehicle> initVehicleListRange() {
		System.out.println("Making vlr list");
		return new ArrayList<>();
	}

	// initialize the full vehicle list attribute
	@ModelAttribute("vehicleListFull")
	public List<Vehicle> initVehicleListFull() {
		System.out.println("Retrieving vehicles");
		List<Vehicle> v = vehicleDAO.getAllVehicles();
		System.out.println("IN INIT.  VEHICLE LIST SIZE::: " + v.size());
		return v;

	}

	// on "add vehicle" (add button in index.jsp)
	@RequestMapping(path = "addVehicle.do")
	public ModelAndView addVehcile(Vehicle vehicle, @ModelAttribute("vehicleListFull") List<Vehicle> fullVehicleList) {
		ModelAndView mv = new ModelAndView();
		// add.jsp will take vehicle parameters, and pass them to this method
		// as a vehicle object. this method adds the vehicle to the full vehicle
		// list
		// where it will be stored for the session.
		System.out.println("ADDED: " + vehicle);
		fullVehicleList.add(vehicle);
		// return to index.jsp
		mv.setViewName("index.jsp");
		return mv;

	}

	// modify vehicles (called by individual modify/delete button after a
	// vehicle search has been performed
	// uses the vehicle list, gets a vehicle object, as well as a choice
	// string (modify or delete)
	@RequestMapping(path = "modifyVehicle.do")
	public ModelAndView modifyVehicle(Vehicle vehicle, @ModelAttribute("vehicleListFull") List<Vehicle> fullVehicleList,
			@RequestParam("choice") String choice) {

		ModelAndView mv = new ModelAndView();
		// get the id of the vehciel to change
		int idToChange = vehicle.getVehicleID();
		int i = 0;
		System.out.println("BEFORE LOOP THING");
		for (; i < fullVehicleList.size(); i++) {
			// when the index (in the fullVehicleList) matches the index of the
			// vehicle
			// that we want to change, break the loop (this sets i to the index
			// we would like to modify)
			if (idToChange == fullVehicleList.get(i).getVehicleID()) {
				break;
			}
		}
		
		// TODO: i can't remember why i did this.. remove? TODO
		//TODO TEST DELEING TIS
//		if (i > fullVehicleList.size()) {
//			System.out.println("Vehicle Not Found");
//		}
		
		// decide to modify or delete the vehicle
		switch (choice) {
		case "modify":
			// set the vehicle at i in the full list to the vehicle that we
			// modified
			fullVehicleList.set(i, vehicle);
			// "stay", or rather "refresh" the modify page by redirecting to it
			mv.setViewName("modify.jsp");
			break;
		case "delete":
			// remove the vehicle from the list
			fullVehicleList.remove(i);
			// go back to the home page
			mv.setViewName("index.jsp");
			break;
		}

		return mv;
	}

	// find a range of vehicles to display (first triggered by the search,
	// update, delete button)
	@RequestMapping(path = "findrange.do")
	public ModelAndView findVehicleRange(VehicleParameters vehicleParameters,
			@ModelAttribute("vehicleListFull") List<Vehicle> vehicleListFull,
			@ModelAttribute("vehicleListRange") List<Vehicle> vehicleListRange)

	{

		ModelAndView mv = new ModelAndView();
		// ensure that vehicle range list is clear
		vehicleListRange.clear();
		// us the getVehcileRange method to return a vheicle range
		vehicleListRange = getVehicleRange(vehicleParameters, vehicleListFull);
		// attach the list to the model view
		mv.addObject("vehicleListRange", vehicleListRange);
		// attach parameters to model view
		mv.addObject("vehicleParameters", vehicleParameters);
		// set the model view name
		mv.setViewName("findrange.jsp");
		return mv;

	}

	// returns a range of vehicles after filtering out unwanted data
	private List<Vehicle> getVehicleRange(VehicleParameters vp, List<Vehicle> vehicleListFull) {

		List<Vehicle> vehicleRange = new ArrayList<>();
		vehicleRange.addAll(vehicleListFull);

		// check all of the number values for null, and assign them to zero if
		// they are null
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

		// run VehicleFilter's filterVehicles method (returns filtered vechile
		// list)
		vehicleRange = VehicleFilter.filterVehicles(vehicleRange, vp);
		return vehicleRange;
	}

	// this switches the vehicles on next and previous buttons in the modify.jsp
	// page
	@RequestMapping(path = "changeVehicle.do", method = RequestMethod.GET)
	public ModelAndView changeVehicle(@ModelAttribute("vehicleListFull") List<Vehicle> vehicleListFull,
			@RequestParam("choice") String c, @RequestParam("currentId") int currentID,
			@RequestParam("nav") String navigate) {
		ModelAndView mv = new ModelAndView();
		// get the index of the vehicle to modify in the full list
		int index = vehicleListFull.indexOf(vehicleDAO.getVehicleByID(currentID));
		// if previous is pushed, decrement the index, if next is pushed,
		// increment the index.
		switch (navigate) {
		case "next":
			if (index == vehicleListFull.size() - 1) {
				// if it will fall out of the loop, make it zero
				index = 0;
			} else {
				index++;
			}
			break;

		case "prev":
			if (index == 0) {
				// if it will fall out of the loop, make it the last vehicle
				index = vehicleListFull.size() - 1;
			} else {
				index--;
			}
			break;

		default:
			break;
		}
		// add new id to mv
		mv.addObject("id", vehicleListFull.get(index).getVehicleID());
		//add new vehicle to mv
		mv.addObject("vehicle", vehicleListFull.get(index));
		//modify.jsp
		mv.setViewName("modify.jsp");
		return mv;
	}

	//triggered by the butotns in index.jsp
	@RequestMapping("menuchoice.do")
	public ModelAndView pageDirection(@ModelAttribute("vehicleListRange") List<Vehicle> vehicleListRange,
			@ModelAttribute("vehicleListFull") List<Vehicle> vehicleListFull, @RequestParam("id") Integer vehicleID,
			@RequestParam("selection") String s) {


		ModelAndView mv = new ModelAndView();
		//ad the full vehicle list, along with the range to display list
		mv.addObject("vehicleListFull", vehicleListFull);
		mv.addObject("vehicleListRange", vehicleListRange);


		// main program directions
		switch (s) {
		case "all":
			mv.setViewName("viewall.jsp");
			break;
		case "range":
			mv.setViewName("findrange.jsp");
			mv.addObject("vehicleParameters", new VehicleParameters());
			break;
		case "add":
			mv.addObject("nextID", vehicleListFull.size());
			mv.addObject("vehicle", new Vehicle());
			mv.setViewName("add.jsp");
			break;
		case "remove":
			mv.setViewName("modify.jsp");
			break;
		case "modify":
			mv.setViewName("modify.jsp");
			//this adds the current vehicle to the "vehicle" parameter
			//to be modified in modify.jsp
			Vehicle vehicleToMod = null;
			for (Vehicle vehicle : vehicleListFull) {
				if (vehicle.getVehicleID() == vehicleID) {
					vehicleToMod = vehicle;
				}
			}
			mv.addObject("vehicle", vehicleToMod);
			break;
		default:
			break;
		}
		return mv;

	}
}
