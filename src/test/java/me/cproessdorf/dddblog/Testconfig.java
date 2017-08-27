package me.cproessdorf.dddblog;

import static org.mockito.Mockito.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Testconfig {

    @Bean
    IBlogpost provideMe(){
        IBlogpost x = mock(IBlogpost.class);
        when(x.getContent()).thenReturn("Hello World as content");
        return x;
    }

    @Bean
    IBlogpostProvider blogpostTestProvider(IBlogpost y){
        IBlogpostProvider x = mock(IBlogpostProvider.class);
        when(x.giveMeABlogpost()).thenReturn(y);
        return x;
    }

}


