package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CostumerService implements CostumerServicePort {
    private final Logger logger = LoggerFactory.getLogger(CostumerService.class);
    private final CostumerRepository costumerRepository;
    private final CostumerMapper mapper;

    @Override
    public Costumer save(Costumer costumer) {
        try{
            return mapper.entityToCostumer(costumerRepository.save(mapper.costumerToEntity(costumer)));
        } catch (RuntimeException e){
			throw new RuntimeException("Error to save Costumer on DataBase: ", e);
        }
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return costumerRepository.existsByCpf(cpf);
    }

    @Override
    public Costumer findById(UUID id) {
        CostumerEntity costumerEntity = costumerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("None costumer found by Id: "+id));
        return mapper.entityToCostumer(costumerEntity);
    }

    @Override
    public boolean existsById(UUID id) {
        return costumerRepository.existsById(id);
    }

    @Override
    public Costumer findByCpf(String cpf) {
        CostumerEntity costumerEntity = costumerRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("None costumer found by CPF: " + cpf));
        return mapper.entityToCostumer(costumerEntity);
    }

    @Override
    public void deleteById(UUID id) {
        costumerRepository.deleteById(id);
    }

}
