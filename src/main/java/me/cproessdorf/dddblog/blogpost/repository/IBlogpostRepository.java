package me.cproessdorf.dddblog.blogpost.repository;

import me.cproessdorf.dddblog.blogpost.Blogpost;
import org.springframework.context.annotation.Bean;

public interface IBlogpostRepository {

    @Bean
    Blogpost loadBlogpost(Long id);
    @Bean
    void addBlogpost(Blogpost blogpost);
    @Bean
    void updateBlogpost(Blogpost blogpost);
    @Bean
    void deleteBlogpost(Long id);
}
