package com.unifacisa.ads.rango.costumer.adapters;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/costumer")
@Tag(name = "Costumer")
//@SecurityRequirement(name = WebSecurityConfig.SECURITY)
@Slf4j
public class CostumerAPI {
    private final CostumerController controller;

    @PostMapping
    public ResponseEntity<CostumerResponse> create(@RequestBody CostumerRequest costumerRequest){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(controller.createCostumer(costumerRequest));
    }

//    public ResponseEntity<Page<CostumerResponse>> findAllCostumers(Pageable pageable){
//        return ResponseEntity.ok().body(controller.findAllCostumers(pageable));
//    }
    @GetMapping("/all")
    public ResponseEntity<PagedModel<EntityModel<CostumerResponse>>> findAllUsers(Pageable pageable, PagedResourcesAssembler<CostumerResponse> assembler){
        Page<CostumerResponse> usersPage = controller.findAllCostumers(pageable);
        log.info("Costumers gotten");
        return ResponseEntity.ok(assembler.toModel(usersPage));
    }

    @GetMapping
    public ResponseEntity<CostumerResponse> findCostumerByCpf(@RequestParam String cpf){
        return ResponseEntity.ok().body(controller.findCostumerByCpf(cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostumerResponse> findCostumerById(@PathVariable UUID id){
        return ResponseEntity.ok().body(controller.findCostumerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCostumerById(@PathVariable UUID id){
        controller.deleteCostumerById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostumerResponse> updateCostumer(@PathVariable UUID id, @RequestBody CostumerRequest costumerRequest){
        return ResponseEntity.ok().body(controller.updateCostumerById(id, costumerRequest));
    }

}
