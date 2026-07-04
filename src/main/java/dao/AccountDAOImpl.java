package dao;

import java.sql.*;
import java.util.ArrayList;

import database.ConnessioneDatabase;

public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(String id_account, String nome, String email, String password) throws SQLException {
        String sql = "INSERT INTO account (ID_Account, nome, email, password) VALUES (?, ?, ?, ?)";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_account);
        statement.setString(2, nome);
        statement.setString(3, email);
        statement.setString(4, password);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void Account_add_iscritti(String follower_id, String following_id) throws SQLException {
        String sql = "INSERT INTO subscription (follower_id, following_id) VALUES (?, ?);";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, follower_id);
        statement.setString(2, following_id);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void Account_add_video(String id_account) throws SQLException {
        String sql = "UPDATE account SET numero_video = numero_video+1 WHERE id_account=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_account);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void Account_add_streaming(String id_account) throws SQLException {
        String sql = "UPDATE account SET numero_streaming = numero_streaming+1 WHERE id_account=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_account);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void getALLAccountsDAO(ArrayList<String> id_accounts, ArrayList<String> nomes,
                                  ArrayList<String> emails, ArrayList<String> passwords) throws SQLException {
        String sql = "SELECT * FROM account";
        Connection connection = ConnessioneDatabase.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            id_accounts.add(resultSet.getString("id_account"));
            nomes.add(resultSet.getString("nome"));
            emails.add(resultSet.getString("email"));
            passwords.add(resultSet.getString("password"));
        }
    }
}
