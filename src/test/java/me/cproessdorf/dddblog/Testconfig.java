package me.cproessdorf.dddblog;

import static org.mockito.Mockito.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Testconfig {

    @Bean
    BlogpostProvider blogpostTestProvider(IBlogpost y){
        BlogpostProvider x = mock(IBlogpostProvider.class);
        when(x.giveMeABlogpostById((long) 1)).thenReturn(y);
        return x;
    }

}


