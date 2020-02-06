package com.packt.webstore.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Booking;

@Repository
public interface BookingRepository extends  CrudRepository<Booking, Long> 
{
	@Query("select b from Booking b where b.bookingID= :id")
	public Booking findByBookingId(@Param("id") String bookingID);
}

