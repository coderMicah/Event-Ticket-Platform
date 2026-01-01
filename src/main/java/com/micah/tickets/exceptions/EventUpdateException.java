package com.micah.tickets.exceptions;

public class EventUpdateException extends RuntimeException {
    public EventUpdateException() {
    }

    public EventUpdateException(String var1) {
        super(var1);
    }

    public EventUpdateException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public EventUpdateException(Throwable var1) {
        super(var1);
    }

    protected EventUpdateException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
