package lowleveldesign.facebook.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yaml")
public class FacebookLLDApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookLLDApplication.class, args);
	}

}
