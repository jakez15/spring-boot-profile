package sample.profile;

import org.junit.After;
import org.junit.Rule;
import org.springframework.boot.test.rule.OutputCapture;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleApplicationTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @After
    public void after() {
        System.clearProperty("spring.profiles.active");
    }

    @Test
    public void givenSpringProfilesActiveEmptyWhenStartThenLocal() throws Exception {
        SampleApplication.main(new String[]{"--spring.main.webEnvironment=false"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("No active profile set, falling back to default profiles: local");
    }

    @Test
    public void givenSpringProfilesActiveCloudWhenStartThenCloud() throws Exception {
        System.setProperty("spring.profiles.active", "cloud");
        SampleApplication.main(new String[]{"--spring.main.webEnvironment=false"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("The following profiles are active: cloud");
    }

    @Test
    public void givenSpringProfilesActiveCloudFromCommandLineWhenStartThenCloud() throws Exception {
        SampleApplication.main(new String[]{"--spring.main.webEnvironment=false", "--spring.profiles.active=cloud"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("The following profiles are active: cloud");
    }

    @Test
    public void givenSpringProfilesActiveLocalFromCommandLineWhenStartThenLocal() throws Exception {
        SampleApplication.main(new String[]{"--spring.main.webEnvironment=false", "--spring.profiles.active=local"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("The following profiles are active: local");
    }

    @Test
    public void givenSpringProfilesActiveLocalFromPropertiesWhenStartThenLocal() throws Exception {
        SampleApplication.main(new String[]{"--spring.main.webEnvironment=false",
                "--spring.config.location=classpath:/application-unittest.properties"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("The following profiles are active: local");
    }
}