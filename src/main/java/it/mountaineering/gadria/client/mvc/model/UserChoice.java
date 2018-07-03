package it.mountaineering.gadria.client.mvc.model;

public class UserChoice {

	UserEntryType userEntryType;
	String userDir;

	private static final String ADMIN_SETTINGS_DIR = "demoSetupPage";
	private static final String USER_DIR = "userMode";


	public UserEntryType getUserEntryType() {
		return userEntryType;
	}

	public void setUserEntryType(UserEntryType userEntryType) {
		this.userEntryType = userEntryType;
		setUserDirByUserType();
	}
	
	public void setUserDirByUserType() {
		if(userEntryType.equals(UserEntryType.ADMIN)){
			this.userDir =  ADMIN_SETTINGS_DIR;
		}		
		if(userEntryType.equals(UserEntryType.USER)){
			this.userDir =  USER_DIR;
		}
	}

	public String getUserDir() {
		return userDir;
	}

	public void setUserDir(String userDir) {
		this.userDir = userDir;
	}
}
