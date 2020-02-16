package org.evil.mutants.app.controller;



import org.evil.mutants.config.AppConfig;
import org.evil.mutants.impl.FindHorizontalMutants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AppConfig.API_PATH)
public class DNAValidatorController {
	
	 @Autowired
	 private FindHorizontalMutants horizontalDNAVerificationService;

	   

	
	@RequestMapping("/mutant")    
	public ResponseEntity<String>  helloworld (){
		String[] chain = {"1234","34333"};
		horizontalDNAVerificationService.isMutant(chain);
		return new ResponseEntity<String>("La concha de tu hermana",HttpStatus.OK);
	}
}
