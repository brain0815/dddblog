package me.cproessdorf.dddblog;

import me.cproessdorf.dddblog.blogpost.provider.BlogpostProvider;
import me.cproessdorf.dddblog.blogpost.repository.BlogpostRepository;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("me.cproessdorf.dddblog")
public class Config {

    @Bean
    BlogpostProvider BlogpostProvider () {
        return new BlogpostProvider();
    }
    @Bean
    BlogpostRepository BlogpostRepository () {
        return new BlogpostRepository();
    }
}
