package com.example.demo;

import com.example.demo.common.DbProperties;
import com.example.demo.models.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public void insert(Transaction transaction) throws SQLException {
        Connection connection = getConnection();

        String query = "INSERT INTO transaction (customer_id,tr_datetime,mcc_code,tr_type,amount,term_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);

            statement.setLong(1, transaction.getCustomerId());
            statement.setString(2, transaction.getDatetime());
            statement.setInt(3, transaction.getMccCode());
            statement.setInt(4, transaction.getType());
            statement.setLong(5, transaction.getAmount());
            statement.setLong(6, transaction.getTermId());

            statement.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            connection.rollback();
        } finally {
            connection.setAutoCommit(false);
        }
    }

    public List<Transaction> findAll() throws SQLException {
        List<Transaction> res = new ArrayList<>();
        Connection connection = getConnection();

        String query = "SELECT * FROM transaction";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    Transaction transaction = new Transaction();

                    transaction.setId(result.getLong("id"));
                    transaction.setCustomerId(result.getLong("customer_id"));
                    transaction.setDatetime(result.getString("tr_datetime"));
                    transaction.setMccCode(result.getInt("mcc_code"));
                    transaction.setType(result.getInt("tr_type"));
                    transaction.setAmount(result.getLong("amount"));
                    transaction.setTermId(result.getLong("term_id"));

                    res.add(transaction);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

        return res;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DbProperties.getUrl(),
                DbProperties.getUser(),
                DbProperties.getPassword()
        );
    }
}
