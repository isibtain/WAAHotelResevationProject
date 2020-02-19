package com.project.cs545.miu.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.cs545.miu.domain.Booking;
import com.project.cs545.miu.domain.Review;
import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.domain.User;

public class DAO {

    List<Room> roomList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();
    List<User> customerList = new ArrayList<>();
    Map<Integer, Review> reviewsDb = new HashMap<>();

//    {
        //creating rooms
//        Room r1 = new Room("R1","single",50,"lake");
//        Room r2 = new Room("R2","single",50,"lake");
//        Room r3 = new Room("R3","single",50,"city");
//        Room r4 = new Room("R4","double",70,"city");
//        Room r5 = new Room("R5","double",70,"lake");
//        Room r6 = new Room("R6","double",70,"city");
//        Room r7 = new Room("R7","twin",90, "lake");
//        Room r8 = new Room("R8","twin",90,"city");
//        Room r9 = new Room("R9","triple",150,"lake");
//        Room r10 = new Room("R10","triple",150,"city");
//
//        //adding rooms to rooms list
//        roomList.add(r1);
//        roomList.add(r2);
//        roomList.add(r3);
//        roomList.add(r4);
//        roomList.add(r5);
//        roomList.add(r6);
//        roomList.add(r7);
//        roomList.add(r8);
//        roomList.add(r9);
//        roomList.add(r10);
//
//        //creating some bookings
//        bookingList.add(new Booking(LocalDate.of(2019,7,16), LocalDate.of(2019,7,20), r2));
//        bookingList.add(new Booking(LocalDate.of(2019,7,21), LocalDate.of(2019,7,24), r10));
//
//        //creating customers
//        Customer customer1 = new Customer("Yared", "Ghidey", "55 Main St.", "Fairfield", "Iowa", "United States", "55677", "yaredghidey@example.com", "776-786-9898","yared","1234");
//        Customer customer2 = new Customer("John", "Mayor", "44 Main St.", "Fairfield", "Iowa", "United States", "55677", "johnmayor@example.com", "677-786-9898","john","4321");
//
//        customerList.add(customer1);
//        customerList.add(customer2);
//
//        //creating and adding reviews
//        reviewsDb.put(1, new Review(1, "Nina Shuler", "Our room was clean and the decor was up to date. Since my husband and I were from out of state, we asked the employee at the front desk where the best place to go for food nearby is and they gave us a variety ……", 4));
//        reviewsDb.put(2, new Review(2, "Jennifer Mital", "Helpful and courteous staff, and the rooms appeared clean; however, all of us got bug bites and we found bugs on our luggage when we got home. The room smelled like people had smoked in it and the exterior doors at the end of the hallway ??", 2));
//    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<User> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<User> customerList) {
        this.customerList = customerList;
    }

    public void addReview(Review review){
        reviewsDb.put(review.getId(), review);
    }

    public void deleteReview(int reviewId){
        reviewsDb.remove(reviewId);
    }

    public void updateReview(Review review){
        reviewsDb.put(review.getId(), review);
    }

    public List<Review> getAllReviews(){
        return new ArrayList<>(reviewsDb.values());
    }

    public Review getReviewById(int reviewId){
        return reviewsDb.get(reviewId);
    }

    public int genId() {
        return reviewsDb.size()+1;
    }
}
