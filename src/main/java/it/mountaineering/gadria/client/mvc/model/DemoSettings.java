package it.mountaineering.gadria.client.mvc.model;


public class DemoSettings {

	DemoLanguageType languageType;
	DemoType demo_type;
	UserType user_type;
	String demoSettingsDir;
	String languageDir;
	DemoLanguage demoLanguage;
	
	private static final String USER_VIEWER_DIR = "chart";
	private static final String DEMO_SETTINGS_DIR = "demoSetupPage";
	private static final String DEVELOPER_SETTINGS_DIR = "developerSetupPage";

	private static final String EN_LANGUAGE_DIR = "en";
	private static final String IT_LANGUAGE_DIR = "it";

	public DemoLanguageType getLanguage() {
		return languageType;
	}

	public void setLanguage(DemoLanguageType language) {
		this.languageType = language;
	}

	public DemoType getDemo_type() {
		return demo_type;
	}

	public void setDemo_type(DemoType demo_type) {
		this.demo_type = demo_type;
	}

	public UserType getUser_type() {
		return user_type;
	}

	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
		setDemoSettingsDirByUserType();
	}

	public String getDemoSettingsDir() {
		return this.demoSettingsDir;
	}

	public void setDemoSettingsDirByUserType() {
		if(user_type.equals(UserType.viewer)){
			this.demoSettingsDir =  USER_VIEWER_DIR;
		}		
		if(user_type.equals(UserType.demo)){
			this.demoSettingsDir =  DEMO_SETTINGS_DIR;
		}		
		if(user_type.equals(UserType.developer)){
			this.demoSettingsDir =  DEVELOPER_SETTINGS_DIR;
		}
	}

	public void setDemoSettingsDir(String demoSettingsDir) {
			this.demoSettingsDir =  demoSettingsDir;
	}

	public String getLanguageDir() {
		return this.languageDir;
	}

	public void setLanguageDir(String languageDir) {
		this.languageDir = languageDir;
	}

	public DemoLanguageType getLanguageType() {
		return languageType;
	}

	public void setLanguageType(DemoLanguageType languageType) {
		this.languageType = languageType;
	}

	public DemoLanguage getDemoLanguage() {
		return demoLanguage;
	}

	public void setDemoLanguage(DemoLanguage demoLanguage) {
		this.demoLanguage = demoLanguage;
	}

}
