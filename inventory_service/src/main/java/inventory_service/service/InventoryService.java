package inventory_service.service;

import inventory_service.repository.InventoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {
    private final InventoryRepository inventoryRepository;

    private final RedisTemplate<String, Object> redisTemplate;

    public InventoryService(InventoryRepository inventoryRepository, RedisTemplate<String, Object> redisTemplate) {
        this.inventoryRepository = inventoryRepository;
        this.redisTemplate = redisTemplate;
    }

    //
//    @Cacheable
//    @CacheEvict
//    @CachePut
//    @CacheConfig
    @Override
    public boolean isInStock(String skuCode, Integer quantity) {
        //Todo: find an inventory for a given skuCode where quantity >= 0

//        redisTemplate.

        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);

    }

    @Override
    public String helloRedis() {

        for (int i = 0; i <= 100; i++) {
//            String value = "value_ ${}" + i;
            String value = String.format("value_ ${%d}", i);
            redisTemplate.opsForValue().set("Test_Key_" + i , value);
        }
        return "hello redis";
    }


}
