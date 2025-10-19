package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderService implements OrderServicePort {

    private final OrderMapper mapper;
    private final OrderRepository orderRepository;


    @Override
    public Order save(Order order) {
        return mapper.entityToOrder(orderRepository.save(mapper.orderToEntity(order)));
    }

    @Override
    public Order findById(UUID id) {
        return mapper.entityToOrder(orderRepository.findById(id).orElseThrow(()-> new NotFoundException("Order not found!")));
    }

    @Override
    public Page<Order> findByCostumer(UUID costumerId, Pageable pageable) {
        return orderRepository.findByCostumerId(costumerId, pageable).map(mapper::entityToOrder);
    }

    @Override
    public Page<Order> findByRestaurant(UUID restaurantId, Pageable pageable) {
        return orderRepository.findByCostumerId(restaurantId, pageable).map(mapper::entityToOrder);
    }

    @Override
    public void deleteOrderById(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return orderRepository.existsById(id);
    }


}
