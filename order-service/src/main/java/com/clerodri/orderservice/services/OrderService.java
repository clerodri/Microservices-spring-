package com.clerodri.orderservice.services;

import com.clerodri.orderservice.dto.OrderLineItemsDto;
import com.clerodri.orderservice.dto.OrderRequest;
import com.clerodri.orderservice.model.Order;
import com.clerodri.orderservice.model.OrderLineItems;
import com.clerodri.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            List<OrderLineItems> orderLineItemsList= orderRequest.getOrderLineItemsDtoList()
                    .stream()
                    .map(this::mapToDto).toList();
            order.setOrderLineItemsList(orderLineItemsList);
            orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems  orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return  orderLineItems;
    }
}
