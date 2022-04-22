package repository.impl;

import model.Division;
import repository.BaseRepository;
import repository.IDivisionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_DIVISION = "select division_id, division_name from division;";

    @Override
    public List<Division> getList() {
        PreparedStatement preparedStatement = null;
        List<Division> divisionList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            Division division;
            while (resultSet.next()) {
                division = new Division();
                division.setDivisionId(resultSet.getInt("division_id"));
                division.setDivisionName(resultSet.getString("division_name"));
                divisionList.add(division);
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
        return divisionList;
    }
}
