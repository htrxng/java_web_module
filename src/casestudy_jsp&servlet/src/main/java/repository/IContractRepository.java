package repository;

import model.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> getList();

    void save(Contract contract);
}
