package persistence;

import org.apache.derby.jdbc.EmbeddedDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ljunior on 4/14/16.
 */
public class Database implements IDatabase {
    public static String DB_NAME = "sample";
    public static String USER_NAME = "app";
    public static String PASSWORD = "app";
    private static Connection connection;

    public Database() throws SQLException {
        EmbeddedDataSource ds = new EmbeddedDataSource();

        ds.setDatabaseName(DB_NAME);
        ds.setCreateDatabase("create");
        ds.setUser(USER_NAME);
        ds.setPassword(PASSWORD);

        connection = ds.getConnection();
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String s) throws SQLException {
        return connection.prepareStatement(s);
    }
}
