package it.mountaineering.gadria.client.mvc.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.mountaineering.gadria.client.mvc.model.WebcamModel;
import it.mountaineering.gadria.client.util.NetClient;
import it.mountaineering.gadria.client.util.PropertiesManager;


@Controller
public class SetUpController {
	private static final java.util.logging.Logger log = Logger.getLogger(SetUpController.class.getName());


	@RequestMapping(value = "/gadriaHome", method = RequestMethod.GET)
	public String gadriaHomeGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		String result = "";
		
		if(!checkInstallation()) {
			result = "installationUnavailable";
		}else {
			modelSetup(model);
			result = "installationUnavailable";
		}
		
		return result;
	}

	@RequestMapping(value = "/gadriaHome", method = RequestMethod.POST)
	public String gadriaHomePost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		String result = "";
		
		if(!checkInstallation()) {
			result = "installationUnavailable";
		}else {
			modelSetup(model);
			result = "gadriaHome";
		}
		
		return result;
	}

	@RequestMapping(value = "/checkInstallation", method = RequestMethod.GET)
	public String checkInstallationGet(HttpSession session, ModelMap model) {
		sessionSetup(session);

		String result = "";
		
		if(!checkInstallation()) {
			result = "installationUnavailable";
		}else {
			modelSetup(model);
			result = "gadriaHome";
		}
		
		return result;
	}

	@RequestMapping(value = "/checkInstallation", method = RequestMethod.POST)
	public String checkInstallationPost(HttpSession session, ModelMap model) {
		sessionSetup(session);

		String result = "";
		
		if(!checkInstallation()) {
			result = "installationUnavailable";
		}else {
			modelSetup(model);
			result = "gadriaHome";
		}
		
		return result;
	}


	@RequestMapping(value = "/latest/{webcamId}/viewImage", method = RequestMethod.GET)
	public String latestPictureGet(HttpSession session, ModelMap model, @PathVariable("webcamId") String webcamId) {				
		sessionSetup(session);

		ModelAndView mAndView = null;
		if(!checkInstallation()) {
			mAndView = new ModelAndView("installationUnavailable", null, null);
		}else {
			modelSetup(model);
			mAndView = new ModelAndView("gadriaHome", null, null);
		}
		
		
		return "//latest//"+webcamId+"//viewImage";
	}



	private WebcamModel getWebcamModel() {
		List<String> webcamIdList = NetClient.getWebcamIdLIst();
		WebcamModel webcamModel = new WebcamModel();
		
		webcamModel.setWebcamIdList(webcamIdList);
		
		return webcamModel;
	}

	private void modelSetup(ModelMap model) {
		if (model.get("webcamModel") == null) {
			WebcamModel webcamModel = getWebcamModel();
			model.put("webcamModel", webcamModel);
		}
	}

	private boolean checkInstallation() {
		String clientImagePath = PropertiesManager.getClientImagePath();
		String serverInstallationHost = PropertiesManager.getServerInstallationHost();

		if((clientImagePath==null || clientImagePath =="") && (serverInstallationHost==null || serverInstallationHost=="")) {
			return false;
		}
		
		return true;
	}

	private void sessionSetup(HttpSession session) {
		
		if (session.getAttribute("installationSetupDone") == null)
			session.setAttribute("installationSetupDone", false);
	}
}
