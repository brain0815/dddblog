package me.cproessdorf.dddblog;

import org.springframework.context.annotation.Bean;

public interface IBlogpostRepository {

    @Bean
    boolean persist(Blogpost blogpost);
    @Bean
    boolean delete(Blogpost blogpost);
}
