package com.project.e_commerce.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.e_commerce.model.User;
import com.project.e_commerce.services.UserService;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;	
	
	@RequestMapping(value = "/adminMainPage", method = RequestMethod.GET)
	public ModelAndView adminIndex() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/adminMainPage");
		return modelAndView;
	}	
	
}
