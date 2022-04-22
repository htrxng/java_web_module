package service;

import model.Division;
import repository.IDivisionRepository;

import java.util.List;

public interface IDivisionService {
    List<Division> getList();
}
