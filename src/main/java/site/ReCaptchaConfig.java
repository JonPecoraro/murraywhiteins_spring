package site;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="google.recaptcha.key")
public class ReCaptchaConfig {
	private String site;
	private String secret;
	
	public String getSite() { return site; }
	public String getSecret() { return secret; }

	public void setSite(String newValue) { this.site = newValue; }
	public void setSecret(String newValue) { this.secret = newValue; }
}