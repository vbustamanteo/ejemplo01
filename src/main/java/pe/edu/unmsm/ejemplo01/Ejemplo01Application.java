package pe.edu.unmsm.ejemplo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Ejemplo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo01Application.class, args);
	}

}
