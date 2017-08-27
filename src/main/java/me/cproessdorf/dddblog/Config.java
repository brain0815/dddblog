package me.cproessdorf.dddblog;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("me.cproessdorf.dddblog")
public class Config {

    @Bean
    BlogpostProvider IBlogpostProvider () {
        return new BlogpostProvider();
    }

}
