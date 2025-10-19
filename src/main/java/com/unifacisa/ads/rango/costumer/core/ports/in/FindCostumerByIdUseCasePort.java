package com.unifacisa.ads.rango.costumer.core.ports.in;

import com.unifacisa.ads.rango.costumer.core.Costumer;

import java.util.UUID;

public interface FindCostumerByIdUseCasePort {

    Costumer execute(UUID id);

}
