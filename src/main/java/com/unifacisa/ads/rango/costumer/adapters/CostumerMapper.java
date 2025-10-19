package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CostumerMapper {
    private final ModelMapper mapper;

    public Costumer entityToCostumer(CostumerEntity costumerEntity){
        return  mapper.map(costumerEntity, Costumer.class);
    }
    public CostumerEntity costumerToEntity(Costumer costumer){
        return mapper.map(costumer, CostumerEntity.class);
    }

    public Costumer requestToCostumer(CostumerRequest costumerRequest){
        return  mapper.map(costumerRequest, Costumer.class);
    }

    public CostumerResponse costumerToResponse(Costumer costumer){
        return mapper.map(costumer, CostumerResponse.class);
    }

    public List<CostumerResponse> costumerListToResponse(List<Costumer> productList) {
        return productList.stream().map(this::costumerToResponse).toList();
    }

    public List<Costumer> entityListToCostumer(List<CostumerEntity> costumerEntityList) {
        return costumerEntityList.stream().map(this::entityToCostumer).toList();
    }

}
