package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ljunior on 4/14/16.
 */
public interface IDatabase {
    Statement createStatement() throws SQLException;

    PreparedStatement prepareStatement(String s) throws SQLException;
}
