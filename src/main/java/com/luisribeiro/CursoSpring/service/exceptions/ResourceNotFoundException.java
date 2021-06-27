package com.luisribeiro.CursoSpring.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not faoun. id" + id);
	}

}
