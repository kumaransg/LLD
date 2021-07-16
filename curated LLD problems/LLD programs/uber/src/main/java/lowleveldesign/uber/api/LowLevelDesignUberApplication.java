package lowleveldesign.uber.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LowLevelDesignUberApplication {

	public static void main(String[] args) {
		SpringApplication.run(LowLevelDesignUberApplication.class, args);
	}

}
