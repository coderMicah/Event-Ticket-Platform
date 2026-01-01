package com.micah.tickets.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException() {
    }

    public EventNotFoundException(String var1) {
        super(var1);
    }

    public EventNotFoundException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public EventNotFoundException(Throwable var1) {
        super(var1);
    }

    protected EventNotFoundException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
