package com.micah.tickets.exceptions;

public class TicketTypeNotFoundException extends RuntimeException {
    public TicketTypeNotFoundException() {
    }

    public TicketTypeNotFoundException(String var1) {
        super(var1);
    }

    public TicketTypeNotFoundException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public TicketTypeNotFoundException(Throwable var1) {
        super(var1);
    }

    protected TicketTypeNotFoundException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
