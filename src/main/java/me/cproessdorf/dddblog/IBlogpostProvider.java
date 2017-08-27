package me.cproessdorf.dddblog;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IBlogpostProvider {

    @Bean
    IBlogpost giveMeABlogpost();
    @Bean
    List giveMeAllBlogposts();
}
