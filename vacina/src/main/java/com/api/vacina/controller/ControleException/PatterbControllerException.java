package com.api.vacina.controller.ControleException;

import com.api.vacina.entities.Exception.ObjectConflictException;
import com.api.vacina.entities.Exception.ObjectInternalErrorException;
import com.api.vacina.entities.Exception.ObjectNotFoundException;
import com.api.vacina.entities.Exception.StandardErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class PatterbControllerException {

    @ExceptionHandler(ObjectConflictException.class)
    public ResponseEntity<StandardErrorResponse> conflict(ObjectConflictException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity.status(status).body(new StandardErrorResponse(LocalDateTime.now(), status.value(),
                e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> notFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StandardErrorResponse(LocalDateTime.now(), status.value(),
                e.getMessage(), request.getRequestURI()));

    }


    @ExceptionHandler(ObjectInternalErrorException.class)
    public ResponseEntity<StandardErrorResponse> internalError(ObjectInternalErrorException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(new StandardErrorResponse(LocalDateTime.now(), status.value(),
                e.getMessage(), request.getRequestURI()));
    }





}
