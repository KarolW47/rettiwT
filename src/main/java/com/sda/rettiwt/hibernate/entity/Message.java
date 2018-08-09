package com.sda.rettiwt.hibernate.entity;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "message")
public class Message implements BaseEntity{

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "content", nullable = false)
    private String content;

    @NonNull
    @Column(name = "timestamp", nullable = false)
    private Long timestamp;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
