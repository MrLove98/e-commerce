package service_profile.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "REST API for Service_Payment", version = "1.0",
                description = "REST API description...  => For Service_Payment",
                contact = @Contact(name = "mr.nquangtinh@gmail.com")
        )
)

public class ConfigSwagger {
}
