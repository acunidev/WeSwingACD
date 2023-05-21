package com.example.weswing.objects;

public class User {
    private String name;
    private int idProfilePic;

    public User(String name, int idProfilePic) {
        this.name = name;
        this.idProfilePic = idProfilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdProfilePic() {
        return idProfilePic;
    }

    public void setIdProfilePic(int idProfilePic) {
        this.idProfilePic = idProfilePic;
    }
}