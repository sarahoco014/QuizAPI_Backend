package com.bnta.quiz_API.models;

public class PlayerDTO {

    private String name;

    public PlayerDTO(String name){
        this.name = name;
    }

    public PlayerDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
