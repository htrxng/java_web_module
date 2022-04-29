package repository.impl;

import model.ContractDetail;
import repository.BaseRepository;
import repository.IContractDetailRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements IContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select contract_detail_id,contract_id,attach_service_id,quantity from contract_detail;";

    @Override
    public List<ContractDetail> getList() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ContractDetail contractDetail;
            while (resultSet.next()){
                contractDetail = new ContractDetail();
                contractDetail.setContractDetailId(resultSet.getInt("contract_detail_id"));
                contractDetail.setContractId(resultSet.getInt("contract_id"));
                contractDetail.setAttachServiceId(resultSet.getInt("attach_service_id"));
                contractDetail.setQuantity(resultSet.getInt("quantity"));
                contractDetailList.add(contractDetail);
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
        return contractDetailList;
    }
}
