package dao;

import database.ConnessioneDatabase;

import java.sql.*;
import java.util.ArrayList;

public class RecensioneDAOImpl implements RecensioneDAO {
    @Override
    public void aggiungiRecensione(String id_recensione, String id_video, String id_account, String descrizione) throws SQLException{
        String sql = "INSERT INTO recensione (id_recensione, id_video, id_account, descrizione, numero_like) VALUES (?, ?, ?, ?, ?)";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_recensione);
        statement.setString(2, id_video);
        statement.setString(3, id_account);
        statement.setString(4, descrizione);
        statement.setInt(5, 0);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void aumenta_like(String id_recensione) throws SQLException{
        String sql = "UPDATE recensione SET numero_like = numero_like+1 WHERE id_recensione=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_recensione);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void getAllRecensione(ArrayList<String> id_recensioni, ArrayList<String> id_videos, ArrayList<String> id_accounts,
                                 ArrayList<String> descrizioni, ArrayList<Integer> numeri_Like) throws SQLException{
        String sql = "SELECT * FROM recensione";
        Connection connection = ConnessioneDatabase.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            id_recensioni.add(resultSet.getString("id_recensione"));
            id_videos.add(resultSet.getString("id_video"));
            id_accounts.add(resultSet.getString("id_account"));
            descrizioni.add(resultSet.getString("descrizione"));
            numeri_Like.add(resultSet.getInt("numero_like"));
        }
    }
}
