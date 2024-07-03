package com.example.camping.project.exception;

public class DuplicateUserException extends Exception  {
    public DuplicateUserException(String message){
        super(message);
    }
}