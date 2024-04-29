import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommonStatements {
    public static ResultSet SelectAll(Connection con, String query) throws Exception {

        // create JDBC statement object
        Statement st = con.createStatement();

        // send and execute SQL query in Database software
        ResultSet rs = st.executeQuery(query);

        return rs;
    }

    public static int Delete(Connection con, String query, String name) throws Exception {

        // Step 2: Create the sql statement using connection object
        PreparedStatement preparedStatement = con.prepareStatement(query);

        // set values
        preparedStatement.setString(1, name);

        // Step 3: Execute the query or update query
        return preparedStatement.executeUpdate();
    }
}
