package me.cproessdorf.dddblog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = {Testconfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BlogpostTest {

    @Autowired
    IBlogpostProvider p;

    @Before
    public void setup(){}

    @Test
    public void shouldAtLeastStart(){
        assertNotNull("should not be null", p);

    }

}