package service_profile.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "REST API for Payment_service", version = "1.0",
                description = "REST API description...  => For Payment_service",
                contact = @Contact(name = "mr.nquangtinh@gmai.com")
        )
)
public class ConfigSwagger {
}
