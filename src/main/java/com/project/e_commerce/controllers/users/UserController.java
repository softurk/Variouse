package com.project.e_commerce.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.e_commerce.model.User;
import com.project.e_commerce.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;	
	
	//Ana Sayfayı Getir
	@RequestMapping(value = "/userMainPage")
	public String indexMain(Model model){
		model.addAttribute("activePage", "profile");
		return "/user/userMainPage";
	}	
	
	//Biralı Sayfayı Getir
	@RequestMapping(value = "/userMainPage", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userFirstname", user.getName());
		modelAndView.addObject("userLastname", user.getLastName());
		modelAndView.addObject("userMail", user.getEmail());
		modelAndView.addObject("activePage", "profile");
		modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
		modelAndView.setViewName("user/userMainPage");
		return modelAndView;
	}	
	
}
