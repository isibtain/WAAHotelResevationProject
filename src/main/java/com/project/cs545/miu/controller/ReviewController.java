package com.project.cs545.miu.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.cs545.miu.domain.Review;
import com.project.cs545.miu.repository.ReviewRepository;
import com.project.cs545.miu.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@ModelAttribute("formHidden")
	public String hidden() {
		return "hidden";
	}
	
	
	
	/*
	 * @ModelAttribute("reviews") public List<Review> listReviews(){ return
	 * reviewService.findAll(); }
	 */
	
	/*
	 * public static double round(double value, int places) { if (places < 0) throw
	 * new IllegalArgumentException();
	 * 
	 * BigDecimal bd = BigDecimal.valueOf(value); bd = bd.setScale(places,
	 * RoundingMode.HALF_UP); return bd.doubleValue(); }
	 */

	
	
	
	@RequestMapping(value="/review", method = RequestMethod.GET)
    public String showReviews(@ModelAttribute("review") Review review, Model model){			
		List<Review> reviews = reviewService.findAll();
		/* int size = reviews.size(); */
		/*
		 * double avg =0;
		 */
		/*
		 * if (size>0) {avg=(double) sumRating/size; round(avg, 2); }
		 */
		model.addAttribute("avg",reviewService.findAvg());
		model.addAttribute("reviews", reviews);
		model.addAttribute("size", reviewService.findTotalReviews());
        return "review";
    }
	
	
	@RequestMapping(value="/review", method = RequestMethod.POST)
    public String addReview(@Valid @ModelAttribute("review") Review review, BindingResult result, RedirectAttributes redirect, Model model){
        if(result.hasErrors()) {
        	model.addAttribute("formHidden", "");
        	return "review";
        }
        model.addAttribute("formHidden", "hidden");
		reviewRepository.save(review);
		/* sumRating+= Integer.parseInt(review.getRating()); */
        redirect.addFlashAttribute("review", review);
        return "redirect:/review";
    }
    

}