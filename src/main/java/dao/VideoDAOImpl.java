package dao;

import database.ConnessioneDatabase;

import java.sql.*;
import java.util.ArrayList;

public class VideoDAOImpl implements VideoDAO {
    @Override
    public void addVideo(String id_video, String id_account, String titolo, String descrizione, String tipo, int durata_secondi) throws SQLException {
        String sql = "INSERT INTO video (id_video, id_account, titolo, descrizione, tipo, durata_secondi) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_video);
        statement.setString(2, id_account);
        statement.setString(3, titolo);
        statement.setString(4, descrizione);
        statement.setString(5, tipo);
        statement.setInt(6, durata_secondi);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void addLike(String id_video) throws SQLException {
        String sql = "UPDATE video SET numero_like = numero_like+1 WHERE id_video=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_video);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void addLike(String id_video, int value) throws SQLException {
        String sql = "UPDATE video SET numero_like = numero_like+? WHERE id_video=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, value);
        statement.setString(2, id_video);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void addVisual(String id_video) throws SQLException {
        String sql = "UPDATE video SET numero_visual = numero_visual+1 WHERE id_video=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id_video);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void addVisual(String id_video, int value) throws SQLException {
        String sql = "UPDATE video SET numero_visual = numero_visual+? WHERE id_video=?";

        Connection connection = ConnessioneDatabase.getInstance();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, value);
        statement.setString(2, id_video);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void getALLVideosDAO(ArrayList<String> id_videos, ArrayList<String> id_accounts, ArrayList<String> titoli, ArrayList<String> descrizioni, ArrayList<String> tipi, ArrayList<Integer> numeri_like,  ArrayList<Integer> numeri_visual, ArrayList<Integer> durataSecondi) throws SQLException {
        String sql = "SELECT * FROM video";
        Connection connection = ConnessioneDatabase.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            id_videos.add(resultSet.getString("id_video"));
            id_accounts.add(resultSet.getString("id_account"));
            titoli.add(resultSet.getString("titolo"));
            descrizioni.add(resultSet.getString("descrizione"));
            tipi.add(resultSet.getString("tipo"));
            numeri_like.add(resultSet.getInt("numero_like"));
            numeri_visual.add(resultSet.getInt("numero_visual"));
            durataSecondi.add(resultSet.getInt("durata_secondi"));
        }
    }


}
