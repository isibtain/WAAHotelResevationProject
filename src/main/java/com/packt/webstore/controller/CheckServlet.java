package com.packt.webstore.controller;

import com.google.gson.Gson;
import com.packt.webstore.dao.DAO;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.FormInput;
import com.packt.webstore.domain.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/available")
public class CheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DAO data;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        data = new DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jsonSting = request.getParameter("formInput");
        FormInput formInput = mapper.fromJson(request.getParameter("formInput"), FormInput.class);

        //getting form parameters
        LocalDate checkInDate = LocalDate.parse(formInput.getCheckInDate());
        LocalDate checkOutDate = LocalDate.parse(formInput.getCheckOutDate());
        String roomType = formInput.getType();
        String view = formInput.getView();
        List<Room> rooms = data.getRoomList();
        List<Booking> bookings= data.getBookingList();
        List<Room>  matches = new ArrayList<>();

        for(Room r: rooms){
            if(r.getType().equals(roomType) && r.getView().equals(view)){
                matches.add(r);
            }
        }

//        List<Room> booked = bookings.stream().filter(b -> (b.getCheckInDate().isBefore(checkInDate) &&
//                b.getCheckOutDate().isAfter(checkInDate)) || (b.getCheckInDate().isAfter(checkInDate) &&
//                b.getCheckInDate().isBefore(checkOutDate)) || (b.getCheckInDate().equals(checkInDate) ||
//                b.getCheckInDate().equals(checkOutDate) || b.getCheckOutDate().equals(checkInDate) ||
//                b.getCheckOutDate().equals(checkOutDate))).map(b -> b.getRoom()).collect(Collectors.toList());

//        List<Room>  available = new ArrayList<>();
//
//        for(Room r: matches){
//            if(!(booked.contains(r))){
//                available.add(r);
//            }
//        }

        String msg = "";

//        if(available.size()!=0){
            msg = "All set! The room you requested is available. Click NEXT to Proceed";
//        }else{
//            msg = "Sorry! The room you requested is not available for the chosen dates. " +
//                    "Please retry with different dates and/or room type";
//        }
//
//        PrintWriter out = response.getWriter();
//        out.print(mapper.toJson(msg));
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
    }
}
