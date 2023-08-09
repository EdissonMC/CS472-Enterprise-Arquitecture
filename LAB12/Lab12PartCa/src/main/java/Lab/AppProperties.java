package Lab;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@ConfigurationProperties(prefix = "app.properties")
@Validated
public class AppProperties {

	private String applicationName;
	@NotBlank
	private String version;
	private String serverUrl;
	@NotBlank
	private String serverName;
	private User user = new User();
	private List<String> countries;

	public void showProperties() {
		System.out.println("applicationName="+applicationName);
		System.out.println("version="+version);
		System.out.println("serverUrl="+serverUrl);
		System.out.println("serverName="+serverName);

		System.out.println("user firstname="+user.getFirstname());
		System.out.println("user lastname="+user.getLastname());
		System.out.println("user username="+user.getUsername());
		System.out.println("user password="+user.getPassword());
		for(String s: countries) {
			System.out.println("Country:"+s);
		}

		
	}	

	public String getApplicationName() {
		return applicationName;
	}



	public void setApplicationName(String applictionName) {
		this.applicationName = applictionName;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public String getServerUrl() {
		return serverUrl;
	}



	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}



	public String getServerName() {
		return serverName;
	}



	public void setServerName(String serverName) {
		this.serverName = serverName;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<String> getCountries() {
		return countries;
	}



	public void setCountries(List<String> countries) {
		this.countries = countries;
	}




}
