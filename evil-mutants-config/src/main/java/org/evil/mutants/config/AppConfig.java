package org.evil.mutants.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("#{ @environment['base.url'] }")
    private String baseUrl;

    @Value("${evil.mutants.dna.valid.assets}")
 	private  String validAssets;

    @Value("#{ @environment['api.version.path'] }")
 	private  String apiVersionPath;

    
    public AppConfig() {
    	System.out.println("CACONA");
    }

    public static final String API_PATH = "/api/v1";

    public String getBaseUrl() {
        return baseUrl;
    }

	public String getValidAssets() {
		return validAssets;
	}

	public String getApiVersionPath() {
		return apiVersionPath;
	}

    
}
