package net.example.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "SpringbootRestful Webservice REST APIs",
				description = "SpringbootRestful Webservice REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Nikita",
						email = "email@gmail.com",
						url = "https://www.mysite.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.mysite.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SpringbootRestful Webservice Doc",
				url = "https://www.mysite.com/docs"
		)
)
public class SpringbootRestfulWebservicesApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}
}
