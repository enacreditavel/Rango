package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.costumer.core.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/costumer")
@RequiredArgsConstructor
public class CostumerController {

    private final Logger logger = LoggerFactory.getLogger(CostumerController.class);
    private final CreateCostumerUseCasePort createCostumerUseCasePort;
    private final FindCostumerByIdUseCasePort findCostumerByIdUseCasePort;
    private final FindCostumerByCpfUseCasePort findCostumerByCpfUseCasePort;
    private final UpdateCostumerByIdUseCasePort updateCostumerByIdUseCasePort;
    private final DeleteCostumerByIdUseCasePort deleteCostumerByIdUseCasePort;
    private final CostumerMapper mapper;
    
    @PostMapping
    public ResponseEntity<CostumerResponse> create(@RequestBody CostumerRequest costumerRequest){
        return ResponseEntity.ok()
                .body(mapper.costumerToResponse(
                        createCostumerUseCasePort.execute(
                                mapper.requestToCostumer(costumerRequest))));
    }

    @GetMapping
    public ResponseEntity<CostumerResponse> findCostumerByCpf(@RequestParam String cpf){
        return ResponseEntity.ok().body(mapper.costumerToResponse(findCostumerByCpfUseCasePort.execute(cpf)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostumerResponse> findCostumerById(@PathVariable UUID id){
        return ResponseEntity.ok().body(mapper.costumerToResponse(findCostumerByIdUseCasePort.execute(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCostumerById(@PathVariable UUID id){
        deleteCostumerByIdUseCasePort.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostumerResponse> updateCostumerById(@PathVariable UUID id, @RequestBody CostumerRequest costumerRequest){
        return ResponseEntity.ok().body(mapper.costumerToResponse(updateCostumerByIdUseCasePort.execute(id, costumerRequest)));
    }
}
