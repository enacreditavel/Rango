package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.infrastructure.security.UserDetailsImpl;
import com.unifacisa.ads.rango.item.adapters.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant/{restaurantId}/orders")
public class OrderAPI {

    private final OrderController controller;

    @PostMapping
    public ResponseEntity<OrderResponse> addItemToOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable UUID restaurantId, @RequestBody ItemRequest itemRequest){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(controller.addItemToOrder(userDetails, restaurantId, itemRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findOrderById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK.value()).body(controller.findOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable UUID id){
        controller.deleteOrderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body("Order Deleted Successfully!");
    }

    @PatchMapping("/{id}/to-payment")
    public ResponseEntity<OrderResponse> sendOrderToPayment(@PathVariable UUID id){
        return ResponseEntity.ok(controller.sendOrderToPayment(id));
    }
    @PatchMapping("/{id}/being-prepared")
    public ResponseEntity<OrderResponse> setOrderStatusBeingPrepared(@PathVariable UUID id){
        return ResponseEntity.ok(controller.setOrderStatusBeingPrepared(id));
    }

    @PatchMapping("/{id}/ready")
    public ResponseEntity<OrderResponse> setOrderStatusReady(@PathVariable UUID id){
        return ResponseEntity.ok(controller.setOrderStatusReady(id));
    }

    @PatchMapping("/{id}/finished")
    public ResponseEntity<OrderResponse> setOrderStatusFinished(@PathVariable UUID id){
        return ResponseEntity.ok(controller.setOrderStatusFinished(id));
    }

    @PatchMapping("/{id}/canceled")
    public ResponseEntity<OrderResponse> setOrderStatusCanceled(@PathVariable UUID id){
        return ResponseEntity.ok(controller.setOrderStatusCanceled(id));
    }


}

