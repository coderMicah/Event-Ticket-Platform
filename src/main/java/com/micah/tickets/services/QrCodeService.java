package com.micah.tickets.services;

import com.micah.tickets.domain.entities.QrCode;
import com.micah.tickets.domain.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
}
