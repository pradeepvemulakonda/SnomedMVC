package com.pradeep.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
public class LoginLogoutController {

	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(LoginLogoutController.class);

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("loginpage");

		return model;

	}

	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a
	 * regular user tries to access an admin only page.
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.POST)
	public String getDeniedPage() {
		logger.debug("Received request to show denied page");

		// This will resolve to /WEB-INF/jsp/deniedpage.jsp
		return "deniedpage";
	}
}