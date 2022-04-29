package service;

import model.AttachService;
import repository.IAttachServiceRepository;

import java.util.List;

public interface IAttachServiceService {
    List<AttachService> getList();
}
