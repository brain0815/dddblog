package me.cproessdorf.dddblog.blogpost.provider;

import me.cproessdorf.dddblog.blogpost.Blogpost;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IBlogpostProvider {

    @Bean
    Blogpost giveMeABlogpostById(Long id);
    @Bean
    List giveMeAllBlogposts();
    @Bean
    void saveMyBlogpost(Blogpost blogpost);
    @Bean
    void updateMyBlogpost(Blogpost blogpost);
    @Bean
    void deleteABlogpostById(Long id);
}
