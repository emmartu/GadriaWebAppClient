package it.mountaineering.gadria.client.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class MainPagesController {


	@RequestMapping(value = "/itViewsPage", method = RequestMethod.GET)
	public String itViewsPageGet(HttpSession session, ModelMap model) {
		sessionSetup(session);

		return "itViewsPage";
	}

	@RequestMapping(value = "/itViewsPage", method = RequestMethod.POST)
	public String itViewsPagePost(HttpSession session, ModelMap model) {
		sessionSetup(session);

		return "itViewsPage";
	}

	@RequestMapping(value = "/bpViewsPage", method = RequestMethod.GET)
	public String bpViewsPageGet(HttpSession session, ModelMap model) {
		return "bpViewsPage";
	}

	@RequestMapping(value = "/bpViewsPage", method = RequestMethod.POST)
	public String bpViewsPagePost(HttpSession session, ModelMap model) {
		sessionSetup(session);

		return "bpViewsPage";
	}

	private void sessionSetup(HttpSession session){
		if(session.getAttribute("setUpDone")==null) session.setAttribute("setUpDone", false);
		if(session.getAttribute("dataLoaded")==null) session.setAttribute("dataLoaded", false);
		if(session.getAttribute("ruleLoaded")==null) session.setAttribute("ruleLoaded", false);
		if(session.getAttribute("engineStarted")==null) session.setAttribute("engineStarted", false);
		if(session.getAttribute("tripleStoreCallBackMode")==null) session.setAttribute("tripleStoreCallBackMode", false);
		if(session.getAttribute("engineStarted")==null) session.setAttribute("engineStarted", false);
	}

}
