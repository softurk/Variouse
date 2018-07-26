package com.project.e_commerce.controllers.baskets;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.e_commerce.model.Basket;
import com.project.e_commerce.model.User;
import com.project.e_commerce.services.BasketService;
import com.project.e_commerce.services.UserService;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BasketService basketService;

    //Sepetteki Ürünleri Göster
    @RequestMapping(value = "/{userId}")
    public ModelAndView displayBasket(@Valid Basket basket, @PathVariable Integer userId) {
    	ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "basket");
		modelAndView.addObject("baskets", this.basketService.findOneByUserId(userId));
		modelAndView.setViewName("basket/basket");
		return modelAndView;     	
    }
    
    //Kişinin Ürün Listesini Getir
    @RequestMapping(value = "/myProducts/{userId}")
    public String findByUserId(@PathVariable Integer userId, Model model) {
        model.addAttribute("activePage", "products");
        model.addAttribute("baskets", this.basketService.findOneByUserId(userId));
        return "product/productMainPage";
    } 
    
    //Sepete Ürün Ekleme
    @RequestMapping(value = "/addBasket/{userId}")
    public ModelAndView addBasket(@Valid Basket basket, @PathVariable Integer userId) {
    	ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "basket");
		
		User user2 = userService.findOne(userId);
    	basket.setUser(user2);
		
		modelAndView.addObject("baskets", this.basketService.save(basket));
		modelAndView.setViewName("basket/basket");
		return modelAndView;     	
    }
}
