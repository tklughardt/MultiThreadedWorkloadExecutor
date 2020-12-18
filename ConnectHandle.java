import java.sql.*;

public class ConnectHandle {

    String url;
    String username;
    String password;
    Connection conn;

    public ConnectHandle(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean connect() throws  SQLException {

        try {
            Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found");
        }

        String connectStr = "jdbc:snowflake://" + this.url ;
        this.conn = DriverManager.getConnection(connectStr, this.username, this.password);

        PreparedStatement sql = this.conn.prepareStatement("CREATE TABLE IF NOT EXISTS JSON_LAB_STAGE( RECORD_METADATA VARIANT, RECORD_CONTENT VARIANT )");
        sql.execute();

        return true;
    }

    public ResultSet executeSQL (String statement) throws SQLException {

        PreparedStatement sql = conn.prepareStatement(statement);
        return sql.executeQuery();
    }

    public Connection getConnection() {
        return this.conn;
    }

}
