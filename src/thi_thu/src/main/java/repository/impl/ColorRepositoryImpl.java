package repository.impl;

import model.Color;
import repository.BaseRepository;
import repository.IColorRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepositoryImpl implements IColorRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_COLOR = "select color_id,color_name from color;";
    @Override
    public List<Color> getList() {
        List<Color> colorList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_COLOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            Color color;
            while (resultSet.next()) {
                color = new Color();
                color.setColorId(resultSet.getInt("color_id"));
                color.setColorName(resultSet.getString("color_name"));
                colorList.add(color);
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
        return colorList;
    }

    @Override
    public void save(Color color) {

    }
}
