package com.micah.tickets.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.micah.tickets.domain.dtos.ErrorDto;
import com.micah.tickets.exceptions.EventNotFoundException;
import com.micah.tickets.exceptions.EventUpdateException;
import com.micah.tickets.exceptions.QrCodeGenerationException;
import com.micah.tickets.exceptions.QrCodeNotFoundException;
import com.micah.tickets.exceptions.TicketSoldOutException;
import com.micah.tickets.exceptions.TicketTypeNotFoundException;
import com.micah.tickets.exceptions.UserNotFoundException;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(TicketSoldOutException.class)
    public ResponseEntity<ErrorDto> handleTicketSoldOutException(
            TicketSoldOutException ex) {
        log.error("Caught TicketSoldOutException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Ticket are sold out for this ticket type");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(QrCodeNotFoundException.class)
    public ResponseEntity<ErrorDto> handleQrCodeNotFoundException(
            QrCodeNotFoundException ex) {
        log.error("Caught QrCodeNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Qr Code not found");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(QrCodeGenerationException.class)
    public ResponseEntity<ErrorDto> handleQrCodeGenerationException(
            QrCodeGenerationException ex) {
        log.error("Caught QrCodeGenerationException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Unable to generate Qr Code");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EventUpdateException.class)
    public ResponseEntity<ErrorDto> handleEventUpdateException(
            EventUpdateException ex) {
        log.error("Caught EventUpdateException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Unable to update event");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketTypeNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTicketTypeNotFoundException(
            TicketTypeNotFoundException ex) {
        log.error("Caught TicketTypeNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Ticket type not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEventNotFoundException(
            EventNotFoundException ex) {
        log.error("Caught EventNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Event not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(
            UserNotFoundException ex) {
        log.error("Caught UserNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("User not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        log.error("Caught MethodArgumentNotValidException", ex);

        ErrorDto errorDto = new ErrorDto();

        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String errorMessage = fieldErrors.stream()
                .findFirst()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .orElse("Validation Error Occured");

        errorDto.setMessage(errorMessage);

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolation(
            ConstraintViolationException ex) {
        log.error("Caught ConstraintViolationException", ex);

        ErrorDto errorDto = new ErrorDto();
        String errorMessage = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .orElse("Constraint violation occured");

        errorDto.setMessage(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        log.error("Caught exception", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("An unknown error occurred");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
