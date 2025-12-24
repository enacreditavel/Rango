package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.infrastructure.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costumer/orders")
public class CostumerOrderAPI{

    private final OrderController controller;

    @GetMapping("/all")
    public ResponseEntity<Page<OrderResponse>> findAllOrdersByCostumer(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam int page, int size){
        return ResponseEntity.ok(controller.findAllOrdersByCostumer(userDetails, PageRequest.of(page, size)));
    }
    
}
