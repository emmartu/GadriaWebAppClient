package it.mountaineering.gadria.client.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.mountaineering.gadria.client.mvc.model.LoginModel;

@Controller
public class AdminPagesController {

	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public String loginUserGet(@ModelAttribute("loginModel") LoginModel loginModel, HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);
		String result = "loginUser";
		
		if(!checkLogin(loginModel)) {
			session.setAttribute("loginFailed", true);
		}else {
			session.setAttribute("loginModel", loginModel);
			result = "gadriaHome";
		}
		
		return result;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUserPost(@ModelAttribute("loginModel") LoginModel loginModel, HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);
		String result = "loginUser";
		
		if(!checkLogin(loginModel)) {
			session.setAttribute("loginFailed", true);
		}else {
			session.setAttribute("loginModel", loginModel);
			result = "gadriaHome";
		}


		return result;
	}

	@RequestMapping(value = "/areaRiservata", method = RequestMethod.GET)
	public String areaRiservataGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);
		String result = "loginUser";
		
		return result;
	}

	@RequestMapping(value = "/areaRiservata", method = RequestMethod.POST)
	public String areaRiservataPost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);
		String result = "loginUser";
		
		return result;
	}
	
	private boolean checkLogin(LoginModel loginModel) {
		if(loginModel.getUsername()==""||loginModel.getUsername()==null) {
			return false;
		}

		if(loginModel.getPassword()==""||loginModel.getPassword()==null) {
			return false;
		}

		if(verifyLogin(loginModel)) {

			return true;
		}
		
		return false;
	}

	private boolean verifyLogin(LoginModel loginModel) {
		// TODO Auto-generated method stub
		return true;
	}

	private void sessionSetup(HttpSession session) {
		
		if (session.getAttribute("installationSetupDone") == null)
			session.setAttribute("installationSetupDone", false);
		if (session.getAttribute("loginFailed") == null)
			session.setAttribute("loginFailed", false);
	}
	
	private void modelSetup(ModelMap model) {
		if (model.get("loginModel") == null) {
			LoginModel loginModel = new LoginModel();
			model.put("loginModel", loginModel);
		}
	}

}
