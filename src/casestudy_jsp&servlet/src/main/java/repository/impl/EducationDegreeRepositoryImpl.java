package repository.impl;

import model.EducationDegree;
import repository.BaseRepository;
import repository.IEducationDegreeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    BaseRepository baseRepository =  new BaseRepository();
    private static final String SELECT_ALL_EDUCATION_DEGREE = "select education_degree_id, education_degree_name from education_degree;";

    @Override
    public List<EducationDegree> getList() {
        PreparedStatement preparedStatement = null;
        List<EducationDegree> educationDegreeList = new ArrayList<>();

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            EducationDegree educationDegree;
            while (resultSet.next()){
                educationDegree = new EducationDegree();
                educationDegree.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                educationDegree.setEducationDegreeName(resultSet.getString("education_degree_name"));
                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return educationDegreeList;
    }
}
