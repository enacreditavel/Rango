package com.unifacisa.ads.rango.costumer.core.ports.in;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.user.core.User;

public interface CreateCostumerUseCasePort {

    Costumer execute(String name, String cpf, User user);

}
