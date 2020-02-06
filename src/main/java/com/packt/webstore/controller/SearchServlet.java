package com.packt.webstore.controller;

import com.google.gson.Gson;
import com.packt.webstore.dao.DAO;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchServlet extends HttpServlet {

    private DAO data;

    @Override
    public void init() throws ServletException {
        data = new DAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getting form parameters
        LocalDate checkInDate = LocalDate.parse(request.getParameter("checkIn"));
        LocalDate checkOutDate = LocalDate.parse(request.getParameter("checkOut"));
        String roomType = request.getParameter("type");
        String gym = request.getParameter("gym");
        String view = request.getParameter("view");
        String parking = request.getParameter("parking");

        List<Room> allRooms = data.getRoomList();
        List<Booking> allBookings= data.getBookingList();
        List<Room>  allMatches = new ArrayList<>();
        List<Room>  available = new ArrayList<>();

//        for(Room r: allRooms){
//            if(r.getType().equals(roomType) && r.getView().equals(view)){
//                allMatches.add(r);
//            }
//        }

//        List<Room> booked = allBookings.stream().filter(b -> (b.getCheckInDate().isBefore(checkInDate) &&
//                b.getCheckOutDate().isAfter(checkInDate)) || (b.getCheckInDate().isAfter(checkInDate) &&
//                b.getCheckInDate().isBefore(checkOutDate)) || (b.getCheckInDate().equals(checkInDate) ||
//                b.getCheckInDate().equals(checkOutDate) || b.getCheckOutDate().equals(checkInDate) ||
//                b.getCheckOutDate().equals(checkOutDate))).map(b -> b.getRoom()).collect(Collectors.toList());
//
//        for(Room r: allMatches){
//            if(!(booked.contains(r))){
//                available.add(r);
//            }
//        }
//
//        //selecting room
//        Room selected = new Room();
//        if(available.size()>0){
//            selected = available.get(0);
//        }
//
//        //price adjustment
//        double add1 = 0, add2 = 0, totalAdd = 0, discount = 1;
//        if(!(gym == null)) add1 += 15;
//        if(!(parking == null)) add2 += 20;
//        if(request.getSession().getAttribute("userName") != null) discount = 0.8;
//
//        //messages
//        String message1 = "", message2 = "", hide="";
//        if(request.getSession().getAttribute("userName") != null){
//            if(available.size() == 0){
//                message1 = "Sorry";
//                message2 = "The room you requested is not available for the chosen dates. " +
//                        "Please <a href='searchInput.jsp'>RETRY<a> with " +
//                        "different dates or room type";
//                hide = "hidden";
//            }else{
//                message1 = "Here is Your Room";
//                message2 = "A 20% members Discount is included in your Pricing";
//            }
//        }else{
//            if(available.size() == 0){
//                message1 = "Sorry! The room you requested is not available for the chosen dates.";
//                message2 = "Please <a href='searchInput.jsp'>RETRY<a> with " +
//                        "different dates or room type";
//                hide = "hidden";
//            }else{
//                message1 = "Here is Your Room";
//            }
//        }
//
//        //adding room picture
//        String picURL = "";
//        if(selected.getType() == "single"){
//            picURL = "resources/images/single.jpg";
//        }else if(selected.getType() == "double"){
//            picURL = "resources/images/double.jpg";
//        }else if(selected.getType() == "triple"){
//            picURL = "resources/images/triple.jpg";
//        }else if(selected.getType() == "twin"){
//            picURL = "resources/images/twin.jpg";
//        }
//
//        //calculating stay duration
//        int duration = (int)(ChronoUnit.DAYS.between(checkInDate, checkOutDate));
//
//        //calculating Amounts
//        double baseRate = selected.getPrice()*discount;
//        double gymExtra = add1*discount;
//        double parkingExtra = add2*discount;
//        double totalDaily = baseRate + gymExtra + parkingExtra;
//        double totalStay = duration * totalDaily;
//        double tax = totalStay * 0.1;
//        double totalWithTax = totalStay + tax;
//
//        //creating booking session and adding attributes
//        HttpSession bookSession = request.getSession();
//
////        String checkIn = checkInDate.toString();
////        String checkOut = checkOutDate.toString();
//
//        bookSession.setAttribute("room", selected);
//        bookSession.setAttribute("stay", duration);
//        bookSession.setAttribute("baseRate", baseRate);
//        bookSession.setAttribute("gymExtra", gymExtra);
//        bookSession.setAttribute("parkingExtra", parkingExtra);
//        bookSession.setAttribute("totalDaily", totalDaily);
//        bookSession.setAttribute("totalStay", totalStay);
//        bookSession.setAttribute("tax", tax);
//        bookSession.setAttribute("totalWithTax", totalWithTax);
//        bookSession.setAttribute("msg1", message1);
//        bookSession.setAttribute("msg2", message2);
//        bookSession.setAttribute("hide", hide);
//        bookSession.setAttribute("picture", picURL);
//        bookSession.setAttribute("checkIn", checkInDate.toString());
//        bookSession.setAttribute("checkOut", checkOutDate.toString());
//
//
//        RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
//        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
