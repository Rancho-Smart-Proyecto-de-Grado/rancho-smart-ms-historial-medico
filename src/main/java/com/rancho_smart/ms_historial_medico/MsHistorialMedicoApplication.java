package com.rancho_smart.ms_historial_medico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsHistorialMedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsHistorialMedicoApplication.class, args);
	}

}
