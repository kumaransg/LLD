package io.hari.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = {})
class DemoApplicationTests {

	@Test
	void contextLoads() {
		assertThat("hari om yadav")
				.isNotNull()
				.startsWith("hari")
				.contains("om")
				.endsWith("yadav");
	}

}
