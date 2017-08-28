package me.cproessdorf.dddblog;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IBlogpostProvider {

    @Bean
    Blogpost giveMeABlogpostById(Long id);
    @Bean
    List giveMeAllBlogposts();
    @Bean
    Boolean saveMyBlogpost(Blogpost blogpost);
    @Bean
    Boolean updateMyBlogpost(Blogpost blogpost);
    @Bean
    Boolean deleteABlogpostById(Long id);
}
