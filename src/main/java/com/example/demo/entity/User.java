package com.example.demo.entity;

import jakarta.persistence.*;
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

//    public User() {
//    }
//
//    public User(Long userId, String userName, String userAge, String about) {
//        this.userId = userId;
//        this.userName = userName;
//        this.userAge = userAge;
//        this.about = about;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserAge() {
//        return userAge;
//    }
//
//    public void setUserAge(String userAge) {
//        this.userAge = userAge;
//    }
//
//    public String getAbout() {
//        return about;
//    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", userName='" + userName + '\'' +
//                ", userAge='" + userAge + '\'' +
//                ", about='" + about + '\'' +
//                '}';
//    }
}
