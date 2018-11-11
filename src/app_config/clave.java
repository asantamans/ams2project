package app_config;

public class clave {
	String claveName;
	String value;
	
	clave(String claveName,String value) {
		this.claveName = claveName;
		this.value = value;
	}

	public String getClaveName() {
		return claveName;
	}

	public void setClaveName(String claveName) {
		this.claveName = claveName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
