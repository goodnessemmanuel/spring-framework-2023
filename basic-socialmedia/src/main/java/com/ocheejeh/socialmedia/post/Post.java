package com.ocheejeh.socialmedia.post;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ocheejeh.socialmedia.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    /**
     * note: when GeneratedValue type equals Identity
     * hibernate will create only the table Post.
     * no additional meta table (e.g. post_seq in this case)
     * will be created in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    @JsonIgnore
    @ManyToOne
    private User user;
}
