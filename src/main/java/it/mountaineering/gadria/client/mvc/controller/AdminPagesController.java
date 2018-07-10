package it.mountaineering.gadria.client.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPagesController {

	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public String loginUserGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		String result = "loginUser";
		
		return result;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUserPost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		String result = "loginUser";
		
		return result;
	}
	
	@RequestMapping(value = "/areaRiservata", method = RequestMethod.GET)
	public String areaRiservataGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		String result = "loginUser";
		
		return result;
	}

	@RequestMapping(value = "/areaRiservata", method = RequestMethod.POST)
	public String areaRiservataPost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		String result = "loginUser";
		
		return result;
	}
	
	private void sessionSetup(HttpSession session) {
		
		if (session.getAttribute("installationSetupDone") == null)
			session.setAttribute("installationSetupDone", false);
	}
}
