package MITP.team.backend;

import MITP.team.backend.Config.security.JwtConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//TODO stworzenie podstawowych endpointow do rejestracji + loginu
@SpringBootApplication
@EnableConfigurationProperties(value = JwtConfigProperties.class)
public class MitpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitpBackendApplication.class, args);
	}
//TODO przed rozwijaniem reszty plz konsultacja entity (bazy) z reszta + najlepiej wrzucenie w kanban
}
