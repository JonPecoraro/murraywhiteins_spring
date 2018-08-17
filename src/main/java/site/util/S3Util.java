package site.util;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class S3Util
{
	private static final Logger logger = LoggerFactory.getLogger(S3Util.class);
	private static final String bucketName = "murraywhiteins";
	private static String activeProfile;
	
	public static String getS3ImageLink(String relativeUrl) {
		String objectKey = activeProfile + relativeUrl;
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
		
		Date expiration = new Date();
		long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60;
        expiration.setTime(expTimeMillis);
        
		GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
			.withMethod(HttpMethod.GET)
			.withExpiration(expiration);
		
		URL url = s3Client.generatePresignedUrl(urlRequest);
		
		return url.toString();
	}
	
	public static void uploadFile(MultipartFile file, String relativeUrl) throws IOException {
		String objectKey = activeProfile + relativeUrl;
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
		long contentLength = Long.valueOf(file.getBytes().length);
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(contentLength);
		
		s3Client.putObject(bucketName, objectKey, file.getInputStream(), metadata);
		logger.info("Successfully uploaded file {} to S3 bucket {}",  objectKey, bucketName);
	}
	
	public static void deleteFile(String relativeUrl) {
		String objectKey = activeProfile + relativeUrl;
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
		s3Client.deleteObject(bucketName, objectKey);
	}
	
	@Value("${spring.profiles.active}")
	public void setActiveProfile(String profile)
	{
		S3Util.activeProfile = profile;
	}
}
