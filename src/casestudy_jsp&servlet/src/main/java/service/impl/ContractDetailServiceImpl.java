package service.impl;

import model.ContractDetail;
import repository.IContractDetailRepository;
import repository.impl.ContractDetailRepositoryImpl;
import service.IContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {
    IContractDetailRepository iContractDetailRepository = new ContractDetailRepositoryImpl();

    @Override
    public List<ContractDetail> getList() {
        return iContractDetailRepository.getList();
    }
}
