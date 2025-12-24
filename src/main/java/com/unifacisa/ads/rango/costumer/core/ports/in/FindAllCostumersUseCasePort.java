package com.unifacisa.ads.rango.costumer.core.ports.in;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllCostumersUseCasePort {
    Page<Costumer> execute(Pageable pageable);
}
