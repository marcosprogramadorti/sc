package com.ad.util;
import com.ad.exception.ValidaCPFException;

public class ValidaCPF {
	
	public static boolean CPF(String cpfAutor) throws ValidaCPFException {
		
		int i, soma, result, peso, num;
		char veri1, veri2;
		
		if(cpfAutor.length() != 11) {
			return(false);
		}
		
		soma=0;
		peso = 10;
		for(i=0;i<9;i++) {
			
			num = (int)(cpfAutor.charAt(i) - 48);
			
			soma = soma +(num * peso);
			peso = peso - 1;
		}
		
		result = 11 - (soma % 11);
		if((result == 10) || (result == 11)) {
			veri1 = '0';
		}else {
			veri1 = (char)(result + 48);
		}
		
		
		soma=0;
		peso = 11;
		for(i=0;i<10;i++) {
			
			num = (int)(cpfAutor.charAt(i) - 48);
			
			soma = soma +(num * peso);
			peso = peso - 1;
		}
		
		result = 11 - (soma % 11);
		if((result == 10) || (result == 11)) {
			veri2 = '0';
		}else {
			veri2 = (char)(result + 48);
		}
		
		if((veri1== cpfAutor.charAt(9)) && (veri2 == cpfAutor.charAt(10))) {
			return(true);
		}else {
			throw new ValidaCPFException("Cpf inválido");
		}
		
	}
	
	
	

}
