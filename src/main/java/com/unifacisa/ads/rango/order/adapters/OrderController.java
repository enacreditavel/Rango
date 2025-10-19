package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.order.core.ports.in.*;
import com.unifacisa.ads.rango.order.core.usecases.CreateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderMapper mapper;

    private final CreateOrderUseCase createOrderUseCase;
    private final FindOrderByIdUseCasePort findOrderByIdUseCasePort;
    private final DeleteOrderByIdUseCasePort deleteOrderByIdUseCasePort;
    private final SetOrderStatusBeingPreparedUseCasePort setOrderStatusBeingPreparedUseCasePort;
    private final SetOrderStatusReadyUseCasePort setOrderStatusReadyUseCasePort;
    private final SetOrderStatusFinishedUseCasePort setOrderStatusFinishedUseCasePort;
    private final SetOrderStatusCanceledUseCasePort setOrderStatusCanceledUseCasePort;

    //Todo Create Order Endpoint
//    @PostMapping("/{restaurantId}")
//    public ResponseEntity<OrderResponse> createOrder(){
//        return ResponseEntity
//                .status(HttpStatus.CREATED.value())
//                .body(mapper.orderToResponse(createOrderUseCase.execute()));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findOrderById(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.orderToResponse(
                        findOrderByIdUseCasePort.execute(id)));
    }

    //TODO Find Orders By Costumer Id Endpoint

    //TODO Find Orders By Restaurant Id Endpoint


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable UUID id){
        deleteOrderByIdUseCasePort.execute(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT.value())
                .body("Order Deleted Successfully!");
    }

    @PatchMapping("/{id}/being-prepared")
    public ResponseEntity<OrderResponse> setOrderStatusBeingPrepared(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.orderToResponse(setOrderStatusBeingPreparedUseCasePort.execute(id)));
    }

    @PatchMapping("/{id}/ready")
    public ResponseEntity<OrderResponse> setOrderStatusReady(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.orderToResponse(setOrderStatusReadyUseCasePort.execute(id)));
    }

    @PatchMapping("/{id}/finished")
    public ResponseEntity<OrderResponse> setOrderStatusFinished(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.orderToResponse(setOrderStatusFinishedUseCasePort.execute(id)));
    }

    @PatchMapping("/{id}/canceled")
    public ResponseEntity<OrderResponse> setOrderStatusCanceled(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.orderToResponse(setOrderStatusCanceledUseCasePort.execute(id)));
    }




}
