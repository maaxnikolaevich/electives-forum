package electiviesforumbackend.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "electiviesforumbackend.platform")
public class PlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlatformApplication.class, args);
	}
}
