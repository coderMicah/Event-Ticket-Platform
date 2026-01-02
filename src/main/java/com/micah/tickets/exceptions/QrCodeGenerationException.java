package com.micah.tickets.exceptions;

public class QrCodeGenerationException extends RuntimeException {
    public QrCodeGenerationException() {
    }

    public QrCodeGenerationException(String var1) {
        super(var1);
    }

    public QrCodeGenerationException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public QrCodeGenerationException(Throwable var1) {
        super(var1);
    }

    protected QrCodeGenerationException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
