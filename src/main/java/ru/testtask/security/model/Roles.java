package ru.testtask.security.model;

public final class Roles {
    public static final String ROLE_USER = "user";
    public static final String ROLE_ADMIN = "admin";

    private Roles() {
        throw new AssertionError();
    }
}
