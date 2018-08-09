package com.sda.rettiwt.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User implements BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "nick", unique = true)
    private String nick;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "pass", nullable = false)
    private String pass;

    @NonNull
    @Column(nullable = false)
    private Long creationTS;

    @OneToMany(mappedBy = "user")
    private Set<Message> messages;

}
