package order_service.service;

import order_service.clients.InventoryClient;
import order_service.dto.OrderRequest;
import order_service.dto.OrderResponse;
import order_service.model.Order;
import order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }


    @Override
    public void placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock) {

            Order order = new Order();
            order.setSkuCode(orderRequest.skuCode());
            order.setOrderNumber(orderRequest.orderNumber());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());

            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
        }

//        return new OrderResponse(order.getId(), order.getOrderNumber(), orderRequest.skuCode(), order.getPrice(), order.getQuantity());
    }
}
