package repository.impl;

import model.Contract;
import repository.BaseRepository;
import repository.IContractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements IContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CONTRACT =
            "select contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id from contract;";

    @Override
    public List<Contract> getList() {
        PreparedStatement preparedStatement = null;
        List<Contract> contractList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contract contract;
            while (resultSet.next()) {
                contract = new Contract();
                contract.setContractId(resultSet.getInt("contract_id"));
                contract.setContractStartDate(resultSet.getString("contract_start_date"));
                contract.setContractEndDate(resultSet.getString("contract_end_date"));
                contract.setContractDeposit(resultSet.getDouble("contract_deposit"));
                contract.setContractTotalMoney(resultSet.getDouble("contract_total_money"));
                contract.setEmployeeId(resultSet.getInt("employee_id"));
                contract.setCustomerId(resultSet.getInt("customer_id"));
                contract.setServiceId(resultSet.getInt("service_id"));
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return contractList;
    }
    private static final String INSERT_CONTRACT = "insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) value (?,?,?,?,?,?,?);";
    @Override
    public void save(Contract contract) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(INSERT_CONTRACT);
            preparedStatement.setString(1,contract.getContractStartDate());
            preparedStatement.setString(2,contract.getContractEndDate());
            preparedStatement.setDouble(3,contract.getContractDeposit());
            preparedStatement.setDouble(4,contract.getContractTotalMoney());
            preparedStatement.setInt(5,contract.getEmployeeId());
            preparedStatement.setInt(6,contract.getCustomerId());
            preparedStatement.setInt(7,contract.getServiceId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
