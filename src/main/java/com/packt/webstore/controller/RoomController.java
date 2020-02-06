package com.packt.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.RoomType;
import com.packt.webstore.domain.ViewType;
import com.packt.webstore.service.RoomService;
import com.packt.webstore.service.RoomTypeService;
import com.packt.webstore.service.ViewTypeService;
 

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@Autowired
	private ViewTypeService viewTypeService;
	
	@ModelAttribute("roomTypes")
	public List<RoomType> listRoomTypes(){
		return roomTypeService.findAll();
	}
	
	@ModelAttribute("viewTypes")
	public List<ViewType> listViewTypes(){
		return viewTypeService.findAll();
	}
	
	@ModelAttribute("rooms")
	public List<Room> listRooms(){
		return roomService.findAll();
	}
	
	@RequestMapping(value = "/addRoomType", method = RequestMethod.GET)
	public String addRoomType(@ModelAttribute("roomType") RoomType type) {
	   return "addRoomType";
	}
	
	@RequestMapping(value = "/addRoomType", method = RequestMethod.POST)
	public String saveRoomType(@ModelAttribute("roomType") RoomType type, RedirectAttributes redirect) {
		
		System.out.println("CHECKKKKKK: " + type.getName() + " and " + type.getPrice());
		RoomType newType = new RoomType();
		newType.setName(type.getName());
		newType.setPrice(type.getPrice());
		roomTypeService.save(newType);
		redirect.addFlashAttribute("addedType", newType);
		return "redirect:/addRoomType";
	}
	
	@RequestMapping(value = "/typeAdded")
	public String roomTypeAdded() {
		return "roomTypeConfirmation";
	}
	
	@RequestMapping(value = "/addViewType", method = RequestMethod.GET)
	public String addViewType(@ModelAttribute("viewType") RoomType type) {
	   return "addViewType";
	}
	
	@RequestMapping(value = "/addViewType", method = RequestMethod.POST)
	public String saveViewType(@ModelAttribute("viewType") ViewType view, RedirectAttributes redirect) {
		
		System.out.println("CHECKKKKKK: " + view.getName() + " and " + view.getPrice());
		ViewType newView = new ViewType();
		newView.setName(view.getName());
		newView.setPrice(view.getPrice());
		viewTypeService.save(newView);
		redirect.addFlashAttribute("addedView", newView);
		return "redirect:/viewAdded";
	}
	
	@RequestMapping(value = "/viewAdded")
	public String viewAdded() {
		return "viewTypeConfirmation";
	}
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room, Model model) {
	   return "addRoom";
	}
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public String saveRoom(@ModelAttribute("room") Room room, RedirectAttributes redirect) {
		Room newRoom = new Room(roomTypeService.findRoomTypeByName(room.getType().getName()),viewTypeService.findViewTypeByName(room.getView().getName()));
		newRoom.setRoomID(roomService.generateRoomID());
		roomService.save(newRoom);
		redirect.addFlashAttribute("message", "Room Number "+newRoom.getRoomID()+" Added");
		return "redirect:/addRoom";
	}
	
	@RequestMapping(value = "/roomAdded", method = RequestMethod.GET)
	public String comfirmation() {
		return "addRoom";
//		return "roomConfirmation";
	}
 
}
