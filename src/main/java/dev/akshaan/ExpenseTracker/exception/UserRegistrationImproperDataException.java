package dev.akshaan.ExpenseTracker.exception;

public class UserRegistrationImproperDataException extends RuntimeException{
    public UserRegistrationImproperDataException() {
    }

    public UserRegistrationImproperDataException(String message) {
        super(message);
    }

    public UserRegistrationImproperDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
