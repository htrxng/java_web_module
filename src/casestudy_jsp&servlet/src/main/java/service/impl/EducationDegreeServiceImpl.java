package service.impl;

import model.EducationDegree;
import repository.impl.EducationDegreeRepositoryImpl;
import repository.IEducationDegreeRepository;
import service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepositoryImpl();

    @Override
    public List<EducationDegree> getList() {
        return iEducationDegreeRepository.getList();
    }
}
