package com.contactlist.paging.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super("Contact data not found");
    }
}
