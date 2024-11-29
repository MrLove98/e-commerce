package order_service.service;

import order_service.dto.OrderRequest;
import order_service.dto.OrderResponse;

public interface IOrderService {

    public void placeOrder(OrderRequest orderRequest);
}
