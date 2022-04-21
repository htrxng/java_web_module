package service.impl;

import model.EducationDegree;
import repository.impl.EducationDegreeRepository;
import repository.IEducationDegreeRepository;
import service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> getList() {
        return iEducationDegreeRepository.getList();
    }
}
