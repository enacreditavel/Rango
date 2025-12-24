package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.*;
import com.unifacisa.ads.rango.infrastructure.exceptions.AlreadyExistsException;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.user.adapters.UserController;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.DeleteUserByIdUseCasePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class CostumerController {


    private final CostumerMapper mapper;

    private final UserController userController;
    private final DeleteUserByIdUseCasePort deleteUserByIdUseCasePort;

    private final CreateCostumerUseCasePort createCostumerUseCasePort;
    private final CostumerAssignUserUseCasePort costumerAssignUserUseCasePort;
    private final CostumerExistsByCpfUseCasePort existsByCpfUseCasePort;
    private final CostumerExistsByIdUseCasePort existsByIdUseCasePort;
    private final FindCostumerByIdUseCasePort findCostumerByIdUseCasePort;
    private final FindCostumerByCpfUseCasePort findCostumerByCpfUseCasePort;
    private final UpdateCostumerUseCasePort updateCostumerUseCasePort;
    private final DeleteCostumerByIdUseCasePort deleteCostumerByIdUseCasePort;
    private final FindAllCostumersUseCasePort findAllCostumersUseCasePort;


    @Transactional
    public CostumerResponse createCostumer(CostumerRequest costumerRequest){
        if (existsByCpfUseCasePort.execute(costumerRequest.cpf())) throw new AlreadyExistsException("CPF already used ");
        User user = userController.findUserByEmail(costumerRequest.email());
        if (user.getAssignedId() != null) throw new BadRequestException("This user already is assigned to another costumer or restaurant!");
        Costumer costumer = createCostumerUseCasePort.execute(costumerRequest.name(), costumerRequest.cpf(), user);
        user = userController.assignUser(user, costumer.getId());
        costumer = costumerAssignUserUseCasePort.execute(costumer, user);
        return mapper.costumerToResponse(costumer);
    }

    public CostumerResponse findCostumerByCpf(String cpf){
        return mapper.costumerToResponse(findCostumerByCpfUseCasePort.execute(cpf));
    }

    public CostumerResponse findCostumerById(UUID id){
        return mapper.costumerToResponse(findCostumerByIdUseCasePort.execute(id));
    }

    public void deleteCostumerById(UUID id){
        if (!existsByIdUseCasePort.execute(id)) throw new NotFoundException("Costumer with id "+id+" doesn't exist");
        deleteCostumerByIdUseCasePort.execute(id);
        deleteUserByIdUseCasePort.execute(id);
    }

    public CostumerResponse updateCostumerById(UUID id, CostumerRequest costumerRequest){
        Costumer costumer = findCostumerByIdUseCasePort.execute(id);
        return mapper.costumerToResponse(updateCostumerUseCasePort.execute(costumer, costumerRequest.name()));
    }

    public Page<CostumerResponse> findAllCostumers(Pageable pageable) {
        return findAllCostumersUseCasePort.execute(pageable).map(mapper::costumerToResponse);
    }
}
