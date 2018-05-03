package site.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Component
public class SmsUtil {
	private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);
	private static String snsTopicArn;
	
	public static void sendMessage(String message) {
		AmazonSNS snsClient = AmazonSNSClient.builder().build();
		PublishResult result = snsClient.publish(new PublishRequest()
			.withTopicArn(snsTopicArn)
			.withMessage(message));
		
		Object[] emailParams = {snsTopicArn, message, result};
		logger.info("SMS message sent. Topic ARN: {}, message: {}, result: {}", emailParams);
	}
	
	@Value("${sns.topic.arn}")
	public void setSnsTopicArn(String snsTopicArn)
	{
		SmsUtil.snsTopicArn = snsTopicArn;
	}
}
