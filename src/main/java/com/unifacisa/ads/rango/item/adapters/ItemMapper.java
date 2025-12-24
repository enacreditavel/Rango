package com.unifacisa.ads.rango.item.adapters;

import com.unifacisa.ads.rango.item.core.Item;
import com.unifacisa.ads.rango.product.adapters.ProductMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface ItemMapper {

    @Mapping(source = "productEntity", target = "product")
    Item entityToItem(ItemEntity itemEntity);

    @Mapping(source = "product", target = "productEntity")
    ItemEntity itemToEntity(Item item);

    @Mapping(source = "product", target = "productResponse")
    ItemResponse itemToResponse(Item item);

    List<Item> entityListToItem(List<ItemEntity> itemEntityList);

    List<ItemEntity> itemListToEntity(List<Item> itemList);

    List<ItemResponse> itemListToResponse(List<Item> itemList);
}
