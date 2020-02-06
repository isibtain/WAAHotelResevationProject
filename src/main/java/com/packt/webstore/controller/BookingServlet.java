package com.packt.webstore.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.packt.webstore.dao.DAO;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.User;
import com.packt.webstore.domain.Payment;
import com.packt.webstore.domain.Room;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookingServlet")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession bookSession = request.getSession();

        String temp = request.getParameter("expiration-date");
        // DO THE DATEEEE!
        request.getParameter("billing-address");
        request.getParameter("cvv");

        Payment payment = new Payment(request.getParameter("card-type"),
                request.getParameter("card-provider"), request.getParameter("card-name"),
                request.getParameter("card-number"), LocalDate.of(2019, 6, 5),
                request.getParameter("billing-address"), request.getParameter("cvv"));

        User customer = new User ();
//        		request.getParameter("first-name"),
//                request.getParameter("last-name"), request.getParameter("street"),
//                request.getParameter("city"), request.getParameter("state"),
//                request.getParameter("country"), request.getParameter("postal-code"),
//                request.getParameter("email"), request.getParameter("phone"),
//                payment);

//        customer.setPayment(payment);
//        payment.setCustomer(customer);

        Room room = (Room) bookSession.getAttribute("room");
        Date checkInDate = (Date) bookSession.getAttribute("checkInDate");
        Date checkOutDate = (Date) bookSession.getAttribute("checkOutDate");

        Booking booking = new Booking(customer, room, checkInDate, checkOutDate, true, false);
     //   booking.setBasePrice((double)(bookSession.getAttribute("totalWithTax")));
        bookSession.setAttribute("booking", booking);

        List<Booking> bookingList = new DAO().getBookingList();

        bookingList.add(booking);
        bookSession.setAttribute("bookingList", bookingList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
