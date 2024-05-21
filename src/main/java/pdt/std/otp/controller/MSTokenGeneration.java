package pdt.std.otp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class MSTokenGeneration {

	
	@Value("${keycloak.token.url}")
	private String tokenURL;
	@Value("${keycloak.clientId}")
	private String clientId;
	@Value("${keycloak.clientSecret}")
	private String clientSecret;
	@Value("${keycloak.grant.type}")
	private String grant_type;
	
	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public String getAccessToken() {
		log.debug("Entering getAccessToken() Of WebsalesUtil");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", grant_type);
		map.add("client_id", clientId);
		map.add("client_secret", clientSecret);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<MSAuthTokenResponse> response = new RestTemplate().exchange(tokenURL, HttpMethod.POST, entity,
				MSAuthTokenResponse.class);
		int code = response.getStatusCodeValue();
		if (code == 401 || code == 403) {
			log.debug("Could not authenticate using client credentials.");
			throw new RuntimeException("Could not retrieve access token for client: " + clientId);
		}
		String accessToken = response.getBody().getAccess_token();
		log.debug("Exiting getAccessToken() Of WebsalesUtil");
		return accessToken;
	}
	
	
}
