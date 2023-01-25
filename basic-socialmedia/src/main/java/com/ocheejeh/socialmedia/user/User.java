package com.ocheejeh.socialmedia.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ocheejeh.socialmedia.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "tb_users")
@NoArgsConstructor
public class User {
    @Id
    // create only tb_users table, no meta table (e.g tb_users_seq) should add.
    // using GenerationType of AUTO would lead to meta table creation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;

    @JsonIgnore
    @OneToMany
    private List<Post> posts;

    public User(Integer id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
