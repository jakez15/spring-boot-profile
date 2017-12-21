/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
