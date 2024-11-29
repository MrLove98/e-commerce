package service_profile.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "inventory-service", url = "http://air-keocobo.lan:8082/inventory")
@FeignClient(name = "${openfeign.clients.client-1.name}")
public interface InventoryClient {

    @GetMapping("/api/profile/h")
    String getXinChao();
}
