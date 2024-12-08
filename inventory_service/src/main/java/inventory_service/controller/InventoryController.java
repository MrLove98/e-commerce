package inventory_service.controller;

import inventory_service.service.IInventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final IInventoryService iInventoryService;

    public InventoryController(IInventoryService iInventoryService) {
        this.iInventoryService = iInventoryService;
    }

    @GetMapping("/h")
    public String getHello(){
        return "Inventory hello";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam int quantity){
        return iInventoryService.isInStock(skuCode, quantity);
    }

    @GetMapping("/hello")
    public String helloRedis(){
        return iInventoryService.helloRedis();

    }

}
