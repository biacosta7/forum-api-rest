package me.beatrizcosta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class ForumApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApiRestApplication.class, args);
	}

}
// teste