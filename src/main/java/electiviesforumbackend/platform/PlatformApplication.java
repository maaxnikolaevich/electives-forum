package electiviesforumbackend.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "electiviesforumbackend.platform")
public class PlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlatformApplication.class, args);
	}
}
