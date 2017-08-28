package me.cproessdorf.dddblog;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("me.cproessdorf.dddblog")
public class Config {

    @Bean
    BlogpostProvider BlogpostProvider () {
        return new BlogpostProvider();
    }

}
