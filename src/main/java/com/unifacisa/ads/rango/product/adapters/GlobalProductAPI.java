package com.unifacisa.ads.rango.product.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class GlobalProductAPI {
    private final ProductController controller;

    @GetMapping("/all")
    public ResponseEntity<PagedModel<EntityModel<ProductResponse>>> findAllProducts(Pageable pageable, PagedResourcesAssembler<ProductResponse> assembler){
        return ResponseEntity.status(HttpStatus.OK.value()).body(assembler.toModel(controller.findAllProducts(pageable)));
    }
}
