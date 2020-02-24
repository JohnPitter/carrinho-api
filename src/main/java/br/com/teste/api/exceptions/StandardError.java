package br.com.teste.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    
	public StandardError(int value, String message, long currentTimeMillis) {
		// TODO Auto-generated constructor stub
	}
	
	public StandardError() {}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4474111979485446185L;
	private Integer status;
    private String msg;
    private long timeStamp;

}