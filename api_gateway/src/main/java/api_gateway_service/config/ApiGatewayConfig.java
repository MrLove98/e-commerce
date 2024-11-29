package api_gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("profile_service", r -> r.path("/api/profile/**")
                        .uri("lb://profile-service"))
                .route("product_service", r -> r.path("/api/product/**")
                        .uri("lb://product-service"))
                .route("order_service", r -> r.path("/api/order/**")
                        .uri("lb://order-service"))
                .route("inventory_service", r -> r.path("/api/inventory/**")
                        .uri("lb://inventory-service"))
                .build();
    }

}


//
//    spring:
//    cloud:
//    gateway:
//    routes:
//            - id: profile-service-route
//    uri: lb://profile-service
//    predicates:
//            - Path=/profile/**
//
// - id: inventory-service-route
// uri: lb://inventory-service
// predicates:
// - Path=/inventory/**
