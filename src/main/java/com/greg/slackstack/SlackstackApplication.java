package com.greg.slackstack;

import com.greg.slackstack.model.Item;
import com.greg.slackstack.model.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SlackstackApplication {

    private static final Logger log = LoggerFactory.getLogger(SlackstackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SlackstackApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {

            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            Wrapper wrapper = restTemplate.getForObject(
                    "http://api.stackexchange.com/2.2/questions/47914141?order=desc&sort=activity&site=stackoverflow", Wrapper.class);
            log.info(wrapper.toString());

            Item item = new Item();
            item = wrapper.getItem().get(0);
            log.info("unwrapped " + item.toString());
        };
    }
}
