package com.jayaree999.orderservice.service;


import com.jayaree999.orderservice.dto.OrderLineItemsDto;
import com.jayaree999.orderservice.dto.OrderRequest;
import com.jayaree999.orderservice.dto.InventoryResponse;
import com.jayaree999.orderservice.model.Order;
import com.jayaree999.orderservice.model.OrderLineItems;
import com.jayaree999.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {

    private final WebClient.Builder webClientBuilder;


    private final OrderRepository orderRepository;

    /*
    map order line items request
     */
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream().map(this::mapToDto).toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();

        InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get().uri("http://inventory-service/api/inventory", uriBuilder ->
                        uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve().bodyToMono(InventoryResponse[].class)
                        .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
        if (allProductsInStock){
            orderRepository.save(order);

        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

    }

//todo : call inv serv and place order if product is in stock config-webclient

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

}
