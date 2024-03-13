package org.bookerbuddies.bookease.meetingroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MeetingRoomNotFoundAdvice {
    @ExceptionHandler(value = {MeetingRoomNotFoundException.class})
    public ResponseEntity<String> meetingRoomNotFoundExceptionHandler(MeetingRoomNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}