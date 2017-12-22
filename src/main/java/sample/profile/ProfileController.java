package sample.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	@Value("${foo}")
	private String fooProfileTest;

	@Value("${important_service.endpoint_url}")
	private String importantUrl;
	
	@GetMapping("/test-active-profile")
	public String testActiveProfile() {
		return fooProfileTest;
	}

	@GetMapping("/important-endpoint")
	public String importantEndpoint() {
		return importantUrl;
	}

}
