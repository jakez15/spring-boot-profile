package sample.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.profiles.active=local"})
public class ProfilerControllerLocalProfileTest {

    @LocalServerPort
    int localPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void givenAppContextWhenTestActiveProfileThenLocal() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + localPort + "/test-active-profile", String.class)).isEqualToIgnoringCase("local");
    }

    @Test
    public void givenAppContextWhenImportantEndpointThenLocal() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + localPort + "/important-endpoint", String.class)).isEqualToIgnoringCase("http://foobarbaz-LOCAL");
    }
}
