package com.micah.tickets.exceptions;

public class EventTicketException extends RuntimeException {
    public EventTicketException() {
    }

    public EventTicketException(String var1) {
        super(var1);
    }

    public EventTicketException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public EventTicketException(Throwable var1) {
        super(var1);
    }

    protected EventTicketException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
