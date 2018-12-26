package br.com.ad.sc.api.exceptions;

public class CpfDuplicadoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5423675353028702457L;

	// constrói um objeto CpfDuplicadoExcepiton com a mensagem passada por parâmetro
	public CpfDuplicadoException(String msg) {
		super(msg);
		
	}
	// contrói um objeto CpfDuplicadoExcepiton com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public CpfDuplicadoException(String msg, Throwable cause){
        super(msg, cause);
    }
	

}
