package com.packt.webstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.webstore.repository.ReviewRepository;
import com.packt.webstore.service.ReviewService;
import com.google.gson.Gson;
import com.packt.webstore.dao.DAO;
import com.packt.webstore.domain.Review;
import com.packt.webstore.domain.Room;

@Controller
public class ReviewController {
	
	
	@Autowired
	private ReviewService reviewService;
	
	
	@Autowired
	ReviewRepository reviewRepository;
	
	
	
	public int sumRating=0;
	
	
	/*
	 * @ModelAttribute("reviews") public List<Review> listReviews(){ return
	 * reviewService.findAll(); }
	 */
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	
	
	
	@RequestMapping(value="/review", method = RequestMethod.GET)
    public String showReviews(@ModelAttribute("review") Review review, Model model){
		
		
        System.out.print("________Inside Review GET_________");

		List<Review> reviews = reviewService.findAll();
		int size = reviews.size();
		double avg =0;

		if (size>0)
			{avg=(double) sumRating/size;
		round(avg, 2);
			}
		model.addAttribute("avg",avg);
		model.addAttribute("reviews", reviews);
		model.addAttribute("size", size);
        return "review";
    }
	
	
	@RequestMapping(value="/review", method = RequestMethod.POST)
    public String addReview(@Valid @ModelAttribute("review") Review review, BindingResult result, RedirectAttributes redirect){
        System.out.print("________Inside Review POST _________");
        reviewRepository.save(review);
        sumRating+=  Integer.parseInt(review.getRating());
        redirect.addFlashAttribute("review", review);
        return "redirect:/review";
    }
    

}
