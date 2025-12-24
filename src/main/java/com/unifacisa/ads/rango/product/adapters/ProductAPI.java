package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.infrastructure.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurants/products")
public class ProductAPI {
    private final ProductController controller;




    @PostMapping()
    @PreAuthorize("hasRole('ROLE_RESTAURANT')")
    public ResponseEntity<ProductResponse> createProduct(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(controller.createProduct(userDetails.getId(), productRequest));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable UUID restaurantId,@PathVariable UUID productId){
        return ResponseEntity.status(HttpStatus.OK.value()).body(controller.findProductById(restaurantId, productId));
    }

    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> findProductsByRestaurantId(@PathVariable UUID restaurantId, @RequestParam int page, @RequestParam int size){
       return ResponseEntity.status(HttpStatus.OK.value()).body(controller.findProductsByRestaurantId(restaurantId, page, size));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable UUID restaurantId, @PathVariable UUID productId,  @RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.OK.value()).body(controller.updateProductById(restaurantId, productId, productRequest));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable UUID restaurantId, @PathVariable UUID productId){
        controller.deleteProductById(restaurantId, productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body("Product " + productId +
                " removed successfully!");
    }
}
