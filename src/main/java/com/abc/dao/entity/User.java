package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  int id;
    private   String password;
    private  String username;
    private  int pri;

    public User( String password, String username, int pri) {

        this.password = password;
        this.username = username;
        this.pri = pri;
    }


    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
