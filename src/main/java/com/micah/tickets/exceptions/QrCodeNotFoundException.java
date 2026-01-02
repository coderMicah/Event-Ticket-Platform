package com.micah.tickets.exceptions;

public class QrCodeNotFoundException extends RuntimeException {
    public QrCodeNotFoundException() {
    }

    public QrCodeNotFoundException(String var1) {
        super(var1);
    }

    public QrCodeNotFoundException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public QrCodeNotFoundException(Throwable var1) {
        super(var1);
    }

    protected QrCodeNotFoundException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
