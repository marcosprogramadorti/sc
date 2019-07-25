package com.ad.exception;

public class ValidaCPFException extends Exception{
	
	 private static final long serialVersionUID = 1149241039409861914L;

	    // constrói um objeto NumeroNegativoException com a mensagem passada por parâmetro
	    public ValidaCPFException(String msg){
	        super(msg);
	    }

	    // contrói um objeto NumeroNegativoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
	    public ValidaCPFException(String msg, Throwable cause){
	        super(msg, cause);
	    }


}
