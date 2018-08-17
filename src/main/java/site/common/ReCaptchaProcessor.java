package site.common;

import java.net.URI;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import site.ReCaptchaConfig;

@Component
public class ReCaptchaProcessor
{
	@Autowired
	private ReCaptchaConfig reCaptchaConfig;
	
	private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");
	
	public void processResponse(String response)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		if (!responseSanityCheck(response))
		{
			throw new RuntimeException("reCaptcha response contains invalid characters");
		}
		
		String verifyUriFormat = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
		URI verifyUri = URI.create(String.format(verifyUriFormat, reCaptchaConfig.getSecret(), response));
		ReCaptchaResponseBean reCaptchaResponse = restTemplate.getForObject(verifyUri,  ReCaptchaResponseBean.class);
		
		if(!reCaptchaResponse.isSuccess()) {
            throw new RuntimeException("reCaptcha was not successfully validated");
        }
	}
	
	private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }
}
