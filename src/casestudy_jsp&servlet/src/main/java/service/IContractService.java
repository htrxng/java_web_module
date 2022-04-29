package service;

import model.Contract;

import java.util.List;
import java.util.Map;

public interface IContractService {
    List<Contract> getList();

    Map<String, String> save(Contract contract);
}
