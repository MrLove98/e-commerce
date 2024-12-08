package inventory_service.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@EnableCaching
@Configuration
public class RedisConfig {
    //Todo: Cấu hình kết nối Redis (thay đổi host và port nếu cần)
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory("localhost", 6379);
    }

    /***
     * Config default value for every-cache:
     *  TTL: time to life of one cache
     *  computePrefixWith: config prefix-name for cache_name
     *  serializer cho key
     *  serialize cho value
     * */
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10)) // TTL- time to life:  mặc định 10 phút
                .disableCachingNullValues()  // Ko lưu giá trị Null
                .computePrefixWith(cacheName -> "Pre_" + cacheName) //custom pre-argument name
                .serializeKeysWith(
                        org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair
                                .fromSerializer(new StringRedisSerializer())) // Serializer cho key
                .serializeValuesWith(
                        org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair
                                .fromSerializer(new GenericJackson2JsonRedisSerializer())); // Serializer cho value
    }


    /**RedisCacheManager behavior can be configured with RedisCacheManager.RedisCacheManagerBuilder, letting you set the default RedisCacheManager, transaction behavior, and predefined caches.**/
    // Cấu hình RedisCacheManager: can be configured to handle a first-write operation with default values for caches.
    /** Bean này sẽ được sử dụng để cung cấp các chức năng cache mặc định cho ứng dụng.
     *
     * RedisConnectionFactory là thành phần kết nối tới Redis server, do Spring Boot hoặc bạn cấu hình.
     * Nhìn vào LettuceConnectionFactory_Class implement  RedisConnectionFactory_Interface
     *
     * Thằng LettuceConnectionFactory_Class là bạn đang cấu hình cho connect to Redis-server
     * */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration())
                .transactionAware() // Đảm bảo hỗ trợ transaction
                .build();
    }
    /** Đảm bảo rằng các thao tác cache được tích hợp với transaction của Spring.
     *
     Nếu một transaction đang hoạt động:
               -- Các thay đổi trên cache chỉ có hiệu lực khi transaction commit thành công.
               -- Nếu transaction rollback, thay đổi trên cache cũng sẽ không được thực hiện.

     Khi nào nên sử dụng transactionAware()?
        --Khi bạn sử dụng Redis cache trong các phương thức quản lý transaction (@Transactional)
            hoặc trong hệ thống yêu cầu đảm bảo tính toàn vẹn dữ liệu giữa cache và database.

     * **/




    @Bean
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}

/**Khi nào không cần cấu hình RedisTemplate?
 Nếu bạn chỉ sử dụng Spring Cache (@Cacheable, @CacheEvict, @CachePut) với RedisCacheManager và
            không cần truy cập trực tiếp vào Redis, bạn không cần phải cấu hình RedisTemplate.
            RedisCacheManager sẽ tự động xử lý các yêu cầu với cấu hình mặc định hoặc theo RedisCacheConfiguration.
 *
 * Tóm lại
 * Nếu không cần thao tác trực tiếp với Redis, bạn có thể bỏ qua cấu hình RedisTemplate.
 * Nếu có yêu cầu cụ thể hoặc muốn tối ưu hóa cấu hình serializer, bạn nên cấu hình RedisTemplate và sử dụng khi cần.
 *
 *
 * ==>> Nó cúng giống như Config KafkaTemplate thôi ^^
 * **/
