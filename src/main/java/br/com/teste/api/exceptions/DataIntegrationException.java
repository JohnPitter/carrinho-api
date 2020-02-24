package br.com.teste.api.exceptions;

public class DataIntegrationException extends RuntimeException {

	private static final long serialVersionUID = -5581292449970974483L;
	
	public DataIntegrationException(String ex) {
        super(ex);
    }
	
}