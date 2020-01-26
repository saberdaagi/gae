package com.teckup.core.constants;

public enum Role {

    ADMIN,
    USER,
    USER_MANAGER;

    @Override
    public String toString() {
        return name();
    }

}
