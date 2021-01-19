package nc.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class CinemaDatabase {
  private static CinemaDatabase instance;
  private Connection connection;

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String prefix = "jdbc:mysql://";
  private static final String host = "localhost";
  private static final int port = 3306;
  private static final String databaseName = "cinema";
  private static final String user = "root";
  private static final String password = "root";

  public Connection getConnection() {
    return connection;
  }

  // Get connection url
  private static String getUrl() {
    return prefix + host + ":" + port + "/" + databaseName;
  }

  private CinemaDatabase() {
  }

  private CinemaDatabase(Connection connection) {
    this.connection = connection;
  }

  public static CinemaDatabase getInstance() {
    if (instance == null) {
      try {
        Class.forName(DRIVER);
        Connection cons = (Connection) DriverManager.getConnection(getUrl(), user, password);
        instance = new CinemaDatabase(cons);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return instance;
  }

}
