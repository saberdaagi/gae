package com.teck.up.gae.core;

public enum  UserRole {

    ADMIN("admin"),ETUDIANT("étudiant");


    private String role ;

    UserRole(String role) {
        this.role = role ;
    }
}
