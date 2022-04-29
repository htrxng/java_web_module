package service.impl;

import model.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepositoryImpl;
import service.IContractService;
import utils.RegularExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements IContractService {
    IContractRepository iContractRepository = new ContractRepositoryImpl();
    private static RegularExpression reGex = new RegularExpression();
    @Override
    public List<Contract> getList() {
        return iContractRepository.getList();
    }

    @Override
    public Map<String, String> save(Contract contract) {
        Map<String,String> map = new HashMap<>();
        if(!reGex.numberPositive(String.valueOf(contract.getContractDeposit())))
        {
            map.put("deposit","deposit must be a positive number!");
        }
        if(map.isEmpty()){
            iContractRepository.save(contract);
        }
        return map;
    }
}
