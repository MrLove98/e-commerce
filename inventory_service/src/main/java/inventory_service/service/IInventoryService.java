package inventory_service.service;

public interface IInventoryService {
    boolean isInStock(String skuCode, Integer quantity);
    String helloRedis();
}
