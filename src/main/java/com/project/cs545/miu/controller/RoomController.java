package com.project.cs545.miu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.domain.RoomType;
import com.project.cs545.miu.domain.ViewType;
import com.project.cs545.miu.service.RoomService;
import com.project.cs545.miu.service.RoomTypeService;
import com.project.cs545.miu.service.ViewTypeService;
 

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
	public String saveRoomType(@Valid @ModelAttribute("roomType") RoomType type,
			BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {return "addRoomType";	}	
		else {
		RoomType newType = new RoomType();
		newType.setName(type.getName());
		newType.setPrice(type.getPrice());
		roomTypeService.save(newType);
		redirect.addFlashAttribute("addedType", newType);
		return "redirect:/addRoomType";}
	}	
	
	@RequestMapping(value = "/deleteRoomType/{roomTypeName}", method = RequestMethod.GET)
	public String removeRoomType(@ModelAttribute("type") RoomType type, @PathVariable("roomTypeName") String name,
			RedirectAttributes redirect) {
		Long id = roomTypeService.findRoomTypeByName(name).getId();
		if(roomTypeService.used(id)) {
			redirect.addFlashAttribute("deleteError", "Cannot Delete " + name +" because it is used by an existing Room");
			return "redirect:/addRoomType";
		}
		roomTypeService.deleteById(roomTypeService.findRoomTypeByName(name).getId());
		return "redirect:/addRoomType";
	}
	
	@RequestMapping(value = "/addViewType", method = RequestMethod.GET)
	public String addViewType(@ModelAttribute("viewType") RoomType type) {
	   return "addViewType";
	}
	
	@RequestMapping(value = "/addViewType", method = RequestMethod.POST)
	public String saveViewType(@Valid @ModelAttribute("viewType") ViewType view,
			BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "addViewType";		
		System.out.println("CHECKKKKKK: " + view.getName() + " and " + view.getPrice());
		ViewType newView = new ViewType();
		newView.setName(view.getName());
		newView.setPrice(view.getPrice());
		viewTypeService.save(newView);
		redirect.addFlashAttribute("addedView", newView);
		return "redirect:/addViewType";
	}
	
	@RequestMapping(value = "/deleteViewType/{viewTypeName}", method = RequestMethod.GET)
	public String removeViewType(@ModelAttribute("view") ViewType view, @PathVariable("viewTypeName") String name,
			RedirectAttributes redirect) {
		Long id = viewTypeService.findViewTypeByName(name).getId();
		if(viewTypeService.used(id)) {
			redirect.addFlashAttribute("deleteError", "Cannot Delete " + name +" because it is used by an existing Room");
			return "redirect:/addViewType";
		}
		viewTypeService.deleteById(viewTypeService.findViewTypeByName(name).getId());
		return "redirect:/addViewType";
	}
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room, Model model) {
	   return "addRoom";
	}
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public String saveRoom(@Valid@ModelAttribute("room") Room room,
			BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "addRoom";
		Room newRoom = new Room(roomTypeService.findRoomTypeByName(room.getType().getName()),viewTypeService.findViewTypeByName(room.getView().getName()));
		newRoom.setRoomID(roomService.generateRoomID());
		roomService.save(newRoom);
		redirect.addFlashAttribute("message", "Room Number "+newRoom.getRoomID()+" Added");
		return "redirect:/addRoom";
	}
	
	@RequestMapping(value = "/deleteRoom/{roomID}", method = RequestMethod.GET)
	public String removeRoom(@PathVariable("roomID") String roomID) {
		roomService.deleteById(roomService.findByRoomID(roomID).getId());
		return "redirect:/addRoom";
	}
 
}
