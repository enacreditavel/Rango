package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.user.adapters.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface CostumerMapper {

    @Mapping(source = "userEntity", target = "user")
    Costumer entityToCostumer(CostumerEntity costumerEntity);

    @Mapping(source = "user", target = "userEntity")
    CostumerEntity costumerToEntity(Costumer costumer);


    @Mapping(source = "user.email", target = "email")
    CostumerResponse costumerToResponse(Costumer costumer);

    List<CostumerResponse> costumerListToResponse(List<Costumer> productList);

    List<Costumer> entityListToCostumer(List<CostumerEntity> costumerEntityList);
}
