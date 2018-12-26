package br.com.ad.sc.api.exceptions;

public class CpfInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3576884310056998855L;
	
	// constrói um objeto CpfDuplicadoExcepiton com a mensagem passada por parâmetro
		public CpfInvalidoException(String msg) {
			super(msg);
			
		}
		// contrói um objeto CpfDuplicadoExcepiton com mensagem e a causa dessa exceção, utilizado para encadear exceptions
	    public CpfInvalidoException(String msg, Throwable cause){
	        super(msg, cause);
	    }

}
