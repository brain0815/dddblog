package me.cproessdorf.dddblog;

import java.util.Date;
import java.util.List;

public interface IBlogpost {

    Long getId();

    String getTitle();

    String getAuthor();

    String getContent();

    Date getCreationDate();

    List getTags();

    void setId(Long id);

    void setTitle(String title);

    void setAuthor(String author);

    void setContent(String content);

    void setCreationDate(Date creationDate);

    void setTags(List tags);
}
