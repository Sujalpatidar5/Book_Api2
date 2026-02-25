package com.cfs.BookApi2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice   // class me jo bhi controller exception throw krega , meh handle kruga
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)        //mtlb kahi bhi BookNotFoundException throw hogi, toh niche wala method chelga
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(     //error object bnaya
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()      //isme sari validation errors store hoti h
                           .getFieldErrors().get(0)   //saari errors me se first error le rhe h
                           .getDefaultMessage();      //ye wahi msg h jo hamne entity me har fields k upr likhe thee

        ErrorResponse error = new ErrorResponse(     //error object bnaya
                400,
                message,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
