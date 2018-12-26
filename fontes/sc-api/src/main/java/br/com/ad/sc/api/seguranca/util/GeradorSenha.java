package br.com.ad.sc.api.seguranca.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

		public static void main (String[] args ) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(encoder.encode("123456"));
			System.out.println(encoder.encode("admin"));
			System.out.println(encoder.encode("123"));
			System.out.println(encoder.encode("@ngul@r0"));
			
		}
}
