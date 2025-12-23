package com.micah.tickets.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String var1) {
        super(var1);
    }

    public UserNotFoundException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public UserNotFoundException(Throwable var1) {
        super(var1);
    }

    protected UserNotFoundException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
