package it.mountaineering.gadria.client.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.mountaineering.gadria.client.mvc.model.WebcamModel;
import it.mountaineering.gadria.client.util.NetClient;
import it.mountaineering.gadria.ring.memory.bean.WebcamProperty;


@Controller
public class SetUpController {
	private static final java.util.logging.Logger log = Logger.getLogger(SetUpController.class.getName());


	@RequestMapping(value = "/gadriaHome", method = RequestMethod.GET)
	public String gadriaHomeGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "gadriaHome";
	}

	@RequestMapping(value = "/gadriaHome", method = RequestMethod.POST)
	public String gadriaHomePost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "gadriaHome";
	}

	@RequestMapping(value = "/latest/{webcamId}/viewImage", method = RequestMethod.GET)
	public String latestPictureGet(HttpSession session, ModelMap model, @PathVariable("webcamId") String webcamId) {
		
		
		sessionSetup(session);
		modelSetup(model);

		return "gadriaHome";
	}

	@RequestMapping(value = "/latestPicture/{webcamId}", method = RequestMethod.POST)
	public String latestPicturePost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "gadriaHome";
	}


	@RequestMapping(value = "/demoSettingsPage", method = RequestMethod.GET)
	public String demoSettingsPageGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "demoSettingsPage";
	}

	@RequestMapping(value = "/demoSettingsPage", method = RequestMethod.POST)
	public String demoSettingsPagePost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "demoSettingsPage";
	}

	private WebcamModel getWebcamModel() {
		Map<String, WebcamProperty> webcamPropertiesMap = NetClient.getWebcamProperties();
		WebcamModel webcamModel = new WebcamModel();
		
		List<String> webcamIdList = new ArrayList<String>();
		webcamIdList.addAll(webcamPropertiesMap.keySet());
		webcamModel.setWebcamIdList(webcamIdList);
		
		return webcamModel;
	}

	private void modelSetup(ModelMap model) {
		if (model.get("webcamModel") == null) {
			WebcamModel webcamModel = getWebcamModel();
			model.put("webcamModel", webcamModel);
		}
	}

	private void sessionSetup(HttpSession session) {
		
		if (session.getAttribute("loadAtlanteDataDone") == null)
			session.setAttribute("loadAtlanteDataDone", false);
	}
}
