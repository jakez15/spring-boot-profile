package sample.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

/**
 * Sample Profile application
 */
@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SampleApplication.class);
        addLocalProfile(springApplication);
        springApplication.run(args);
    }

    public static void addLocalProfile(SpringApplication app) {
        Properties properties = new Properties();
        properties.setProperty("spring.profiles.default", "local");
        app.setDefaultProperties(properties);
    }

}
