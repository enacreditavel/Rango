package com.unifacisa.ads.rango.costumer.core.ports.in;

import java.util.UUID;

public interface CostumerExistsByIdUseCasePort {
    boolean execute(UUID costumerId);
}
