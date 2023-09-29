package intense.peace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@RestController
public class GoogleHttpClientApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GoogleHttpClientApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GoogleHttpClientApplication.class, args);

	}

	/**
	 * public static void makeHttpRequestToGoogle() { RestTemplate restTemplate =
	 * new RestTemplate(); String googleHomepage =
	 * restTemplate.getForObject("https://www.google.com", String.class);
	 * System.out.println("Google homepage content:\n" + googleHomepage); }
	 */

	@GetMapping("/redirect-to-anywhere")
	/**
	 * http://localhost:8761/redirect-to-anywhere?url=
	 */
	public static RedirectView redirectToGoogle(@RequestParam("url") String url) {
		// Redirect to Google.com

		String googleUrl = "https://www." + url + ".com";
		return new RedirectView(googleUrl);
	}
}
