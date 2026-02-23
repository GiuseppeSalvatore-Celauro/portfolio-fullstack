package it.backend.portfolio.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException (String message) {
		super(message);
	}
}
