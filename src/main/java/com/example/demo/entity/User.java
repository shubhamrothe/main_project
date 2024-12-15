package com.example.demo.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_Id")
    public Long userId;
    @Column(name="user_name")
    public String userName;
    @Column(name="user_age")
    public String userAge;
    @Column(name="user_info")
    public String about;

}
