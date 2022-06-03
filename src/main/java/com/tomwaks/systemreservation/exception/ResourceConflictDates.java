package com.tomwaks.systemreservation.exception;

public class ResourceConflictDates extends RuntimeException{

    public ResourceConflictDates() {
        super(String.format("There is conflict dates"));
    }
}
