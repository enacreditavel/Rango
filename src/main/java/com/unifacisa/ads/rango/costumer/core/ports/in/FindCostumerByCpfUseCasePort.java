package com.unifacisa.ads.rango.costumer.core.ports.in;

import com.unifacisa.ads.rango.costumer.core.Costumer;

public interface FindCostumerByCpfUseCasePort {

    Costumer execute(String cpf);
}
