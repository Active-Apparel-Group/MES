package com.longson.pojo;

public class User {
    public User(String username, String usercode, String nickname) {
        this.username = username;
        this.usercode = usercode;
        this.nickname = nickname;
    }

    private String username;
    private  String usercode;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    private  String nickname;






    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", usercode='" + usercode + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

