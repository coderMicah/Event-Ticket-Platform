package com.micah.tickets.exceptions;

public class TicketSoldOutException extends RuntimeException {
    public TicketSoldOutException() {
    }

    public TicketSoldOutException(String var1) {
        super(var1);
    }

    public TicketSoldOutException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public TicketSoldOutException(Throwable var1) {
        super(var1);
    }

    protected TicketSoldOutException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
