package com.github.curriculeon.arcade;

import java.util.Objects;

/**
 * Created by leon on 7/21/2020.
 * ArcadeAccount is registered for each user of the Arcade.
 * The ArcadeAccount is used to log into the system to select a Game to play.
 */
public class ArcadeAccount {

    private final String userName;
    private final String password;

    public ArcadeAccount(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String  getUserName() {
        return userName;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(Objects.requireNonNull(obj));
    }

    @Override
    public String toString() {
        return "ArcadeAccount{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}