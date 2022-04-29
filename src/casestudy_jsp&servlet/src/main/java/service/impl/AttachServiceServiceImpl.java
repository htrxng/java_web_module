package service.impl;

import model.AttachService;
import repository.IAttachServiceRepository;
import repository.impl.AttachServiceRepositoryImpl;
import service.IAttachServiceService;

import java.util.List;

public class AttachServiceServiceImpl implements IAttachServiceService {
    IAttachServiceRepository iAttachServiceRepository = new AttachServiceRepositoryImpl();

    @Override
    public List<AttachService> getList() {
        return iAttachServiceRepository.getList();
    }
}
