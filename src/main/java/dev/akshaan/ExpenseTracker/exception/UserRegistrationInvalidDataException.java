package dev.akshaan.ExpenseTracker.exception;

public class UserRegistrationInvalidDataException extends RuntimeException{
    public UserRegistrationInvalidDataException(String message) {
        super(message);
    }

    public UserRegistrationInvalidDataException() {
    }

    public UserRegistrationInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
