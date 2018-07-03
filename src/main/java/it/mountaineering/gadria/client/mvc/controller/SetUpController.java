package it.mountaineering.gadria.client.mvc.controller;

import it.mountaineering.gadria.client.context.AppContextListener;
import it.mountaineering.gadria.client.mvc.model.DemoSettings;
import it.mountaineering.gadria.client.mvc.model.UserChoice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class SetUpController {
	private static final java.util.logging.Logger log = Logger.getLogger(SetUpController.class.getName());


	@RequestMapping(value = "/demoHome", method = RequestMethod.GET)
	public String demoHomeGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "demoHome";
	}

	@RequestMapping(value = "/demoHome", method = RequestMethod.POST)
	public String demoHome(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "demoHome";
	}

	@RequestMapping(value = "/userChoice", method = RequestMethod.GET)
	public String userChoiceGet(@ModelAttribute("demoSettingsModel") UserChoice userChoiceModel, HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		session.setAttribute("userChoice", userChoiceModel);

		return userChoiceModel.getUserDir();
	}

	@RequestMapping(value = "/userChoice", method = RequestMethod.POST)
	public String userChoicePost(@ModelAttribute("demoSettingsModel") UserChoice userChoiceModel, HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		session.setAttribute("userChoice", userChoiceModel);

		return userChoiceModel.getUserDir();
	}


	@RequestMapping(value = "/demoSettings", method = RequestMethod.GET)
	public String demoSettingsGet(@ModelAttribute("demoSettingsModel") DemoSettings demoSettingsModel, HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		session.setAttribute("demoSettings", demoSettingsModel);

		return demoSettingsModel.getDemoSettingsDir();
	}

	@RequestMapping(value = "/demoSettings", method = RequestMethod.POST)
	public String demoSettingsPost(@ModelAttribute("demoSettingsModel") DemoSettings demoSettingsModel, HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		session.setAttribute("demoSettings", demoSettingsModel);

		return demoSettingsModel.getDemoSettingsDir();
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

	@RequestMapping(value = "/demoSetupPage", method = RequestMethod.GET)
	public String demoSetupPageGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "demoSetupPage";
	}

	@RequestMapping(value = "/demoSetupPage", method = RequestMethod.POST)
	public String demoSetupPagePost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "demoSetupPage";
	}

	@RequestMapping(value = "/developerSetupPage", method = RequestMethod.GET)
	public String developerSetupPageGet(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "developerSetupPage";
	}

	@RequestMapping(value = "/developerSetupPage", method = RequestMethod.POST)
	public String developerSetupPagePost(HttpSession session, ModelMap model) {
		sessionSetup(session);
		modelSetup(model);

		return "developerSetupPage";
	}


	private void modelSetup(ModelMap model) {
		if (model.get("demoSettingsModel") == null)
			model.put("demoSettingsModel", new DemoSettings());
	}

	private void sessionSetup(HttpSession session) {
		
		if (session.getAttribute("resetTripleStoreDone") == null)
			session.setAttribute("resetTripleStoreDone", false);
		if (session.getAttribute("stopPipelineDone") == null)
			session.setAttribute("stopPipelineDone", false);
		if (session.getAttribute("loadRdfTestDataDone") == null)
			session.setAttribute("loadRdfTestDataDone", false);
		if (session.getAttribute("resetMongoDbDone") == null)
			session.setAttribute("resetMongoDbDone", false);
		if (session.getAttribute("loadMongoDbTestData") == null)
			session.setAttribute("loadMongoDbTestData", false);
		if (session.getAttribute("loadRuleFileDone") == null)
			session.setAttribute("loadRuleFileDone", false);
		if (session.getAttribute("globalSetUpDone") == null)
			session.setAttribute("globalSetUpDone", false);
		if (session.getAttribute("globalLoadTestDataDone") == null)
			session.setAttribute("globalLoadTestDataDone", false);
		if (session.getAttribute("engineStarted") == null)
			session.setAttribute("engineStarted", false);
		if (session.getAttribute("loadAtlanteDataDone") == null)
			session.setAttribute("loadAtlanteDataDone", false);
	}
}
