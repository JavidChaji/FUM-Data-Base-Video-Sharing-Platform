
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javid
 */
public class Youtube {

    private final String url = "jdbc:postgresql://localhost:5432/youtube";
    private final String admin = "postgres";
    private final String user = "ordinary_user";
    private final String channelAdmin = "channel_admin";
    private final String playlistAdmin = "playlist_admin";
    private final String adminPassword = "163452";
    private final String userPassword = "jw8s0F4";

    public Connection connect(String url, String user, String userPassword) throws SQLException {

        return DriverManager.getConnection(url, user, userPassword);
    }

    private void displayMovie(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("vname") + "\t"
                    + rs.getString("username") + "\t"
                    + rs.getString("uploaddate") + "\t"
                    + rs.getString("description") + "\t"
                    + rs.getString("duration") + "\t"
                    + rs.getString("thumbnailphoto"));
        }
    }

    private void displayUser(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("username") + "\t"
                    + rs.getString("userpassword"));
        }
    }

    public void findMovieByName(String movieName) {
        String SQL = "SELECT * "
                + "FROM uservideo "
                + "WHERE vname = ?";

        try (Connection conn = connect(url, user, userPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, movieName);
            ResultSet rs = pstmt.executeQuery();
            displayMovie(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void findUserName(String username, String userpassword) {
        String SQL = "SELECT username, userpassword "
                + "FROM y_user "
                + "WHERE username = ? AND userpassword = ?";

        try (Connection conn = connect(url, admin, adminPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, username);
            pstmt.setString(2, userpassword);
            ResultSet rs = pstmt.executeQuery();
//            if( rs.wasNull()) {
                displayUser(rs);
//            }else {
//                System.out.printf("this user not exist.");
//                System.exit(0);
//            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void insertUserToDB(String userName, String userPassword, String registeryDate, int profilePicture, String email) {
        String SQL = "INSERT INTO y_user(userName, userPassword, registeryDate, prfilePicture, email)" +
                "VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?)";

        try (Connection conn = connect(url, admin, adminPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, userPassword);
            pstmt.setInt(3, profilePicture);
            pstmt.setString(4, email);
            ResultSet rs = pstmt.executeQuery();

            System.out.println(rs.getRow());
            System.out.println("Data Inserted");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertVideoToDB(String vName, String userName, String uploadDate, String description, int duration, int thumbnailPhoto) {
        String SQL = "INSERT INTO y_video(vName, userName, uploadDate, description, duration, thumbnailPhoto)" +
                "VALUES (?, 'javid', CURRENT_TIMESTAMP, ?, ?, ?)";

        try (Connection conn = connect(url, admin, adminPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, vName);
//            pstmt.setString(2, userName);
            pstmt.setString(2, description);
            pstmt.setInt(3, duration);
            pstmt.setInt(4, thumbnailPhoto);

            ResultSet rs = pstmt.executeQuery();

            System.out.println(rs.getRow());
            System.out.println("Data Inserted");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String randomAlphabeticString(int size) {
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        int targetStringLength = size;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


    public int randomNumericInt(int limit){
        Random rand = new Random();
        // Obtain a number between [0 - num].
        int n = rand.nextInt(limit + 1);
        return n;
    }
}

