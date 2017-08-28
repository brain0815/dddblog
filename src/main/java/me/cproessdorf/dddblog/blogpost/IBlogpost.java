package me.cproessdorf.dddblog.blogpost;

import java.util.Date;
import java.util.List;

public interface IBlogpost {

    Long getId();

    String getTitle();

    String getAuthor();

    String getContent();

    String getCreationDate();

    List getTags();

    void setId(Long id);

    void setTitle(String title);

    void setAuthor(String author);

    void setContent(String content);

    void setCreationDate(String creationDate);

    void setTags(List tags);
}
