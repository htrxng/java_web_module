package repository.impl;

import model.Position;
import repository.BaseRepository;
import repository.IPositionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    private BaseRepository baseRepository = new BaseRepository();
 private static final String SELECT_ALL_POSITION = "select position_id, position_name from position;";

    @Override
    public List<Position> getList() {
        PreparedStatement preparedStatement = null;
        List<Position> positionList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position;
            while (resultSet.next()) {
                position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(resultSet.getString("position_name"));
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return positionList;
    }
}
