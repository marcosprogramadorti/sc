package br.com.ad.sc.api.resource;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;
import com.google.zxing.WriterException;

import br.com.ad.sc.api.model.PessoaFisica;
import br.com.ad.sc.api.qrcode.QRCodeGenerator;
import br.com.ad.sc.api.exceptions.CpfDuplicadoException;
import br.com.ad.sc.api.exceptions.CpfInvalidoException;
import br.com.ad.sc.api.repository.servico.PessoaFisicaServico;



@RestController
@RequestMapping("/qrCode")
public class QrCodeResource {
	

	
	private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
	
	
	@PostMapping()
	public String geradorQRCode(@RequestBody PessoaFisica qrcode ){
		
		String jsonText = qrcode.toString();

		
	
		   
		try {
			QRCodeGenerator.generateQRCodeImage(jsonText, 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
		
		return "OK";
	}
	
	

}
