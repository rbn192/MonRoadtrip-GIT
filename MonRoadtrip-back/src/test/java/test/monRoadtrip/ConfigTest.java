package test.monRoadtrip;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import monRoadtrip.config.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class ConfigTest {

		@Autowired
		EntityManagerFactory entityManagerFactory;

		@Test
		void test() {
			assertNotNull(entityManagerFactory);
		}
}
