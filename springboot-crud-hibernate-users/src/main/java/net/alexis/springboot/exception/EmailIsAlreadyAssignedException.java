package net.alexis.springboot.exception;

public class EmailIsAlreadyAssignedException extends RuntimeException{

	public EmailIsAlreadyAssignedException(String message){
        super(message);
    }

}
