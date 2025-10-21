package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.user.adapters.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostumerRequest {
    private String name;

    private String cpf;

    private UserRequest userRequest;
}
