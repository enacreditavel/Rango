package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.user.adapters.UserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CostumerMapper {
    private final ModelMapper mapper;
    private final UserMapper userMapper;

    public Costumer entityToCostumer(CostumerEntity costumerEntity){
        Costumer costumer = mapper.map(costumerEntity, Costumer.class);
        costumer.setUser(userMapper.entityToUser(costumerEntity.getUserEntity()));
        return costumer;
    }
    public CostumerEntity costumerToEntity(Costumer costumer){
        CostumerEntity costumerEntity = mapper.map(costumer, CostumerEntity.class);
        costumerEntity.setUserEntity(userMapper.userToEntity(costumer.getUser()));
        return costumerEntity;
    }

    public Costumer requestToCostumer(CostumerRequest costumerRequest){
        Costumer costumer = mapper.map(costumerRequest, Costumer.class);
        costumer.setUser(userMapper.requestToUser(costumerRequest.getUserRequest()));
        return costumer;
    }

    public CostumerResponse costumerToResponse(Costumer costumer){
        CostumerResponse costumerResponse = mapper.map(costumer, CostumerResponse.class);
        costumerResponse.setEmail(costumer.getUser().getEmail());
        return costumerResponse;
    }

    public List<CostumerResponse> costumerListToResponse(List<Costumer> productList) {
        return productList.stream().map(this::costumerToResponse).toList();
    }

    public List<Costumer> entityListToCostumer(List<CostumerEntity> costumerEntityList) {
        return costumerEntityList.stream().map(this::entityToCostumer).toList();
    }

}
