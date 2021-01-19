package nc.app.dao;

import nc.app.CinemaDatabase;
import nc.app.models.Cinema;
import nc.app.models.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CinemaDao {
  public Cinema.CreateStatus createCinema(Cinema cinema) {
    try {
      String sql = "INSERT INTO cinema (width, height, min_distance) VALUES (?, ?, ?)";
      Connection cons = CinemaDatabase.getInstance().getConnection();
      PreparedStatement stmt = cons.prepareStatement(sql, new String[]{"id"});
      stmt.setInt(1, cinema.getWidth());
      stmt.setInt(2, cinema.getHeight());
      stmt.setInt(3, cinema.getMin_distance());
      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      int cinemaId = rs.next() ? rs.getInt(1) : 0;
      if (cinemaId > 0) return new Cinema.CreateStatus(Cinema.CreateStatus.TYPE.SUCCESS, cinemaId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Cinema.CreateStatus(Cinema.CreateStatus.TYPE.CREATE_FAIL, -1);
  }


  public ArrayList<Seat> getReservedSeats(int cinemaId) {
    ArrayList<Seat> seats = new ArrayList<>();
    try {
      String sql = "SELECT id, row_no, column_no FROM seat WHERE cinema_id = ?";
      Connection cons = CinemaDatabase.getInstance().getConnection();
      PreparedStatement stmt = cons.prepareStatement(sql);
      stmt.setInt(1, cinemaId);
      ResultSet resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        seats.add(new Seat(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return seats;
  }

  public Cinema getCinemaById(int cinemaId) {
    Cinema cinema = null;
    try {
      String sql = "SELECT width, height, min_distance FROM cinema WHERE id = ?";
      Connection cons = CinemaDatabase.getInstance().getConnection();
      PreparedStatement stmt = cons.prepareStatement(sql);
      stmt.setInt(1, cinemaId);
      ResultSet resultSet = stmt.executeQuery();

      if (resultSet.next()) {
        cinema = new Cinema(cinemaId, resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cinema;
  }

  public Cinema getLastCinema() {
    Cinema cinema = null;
    try {
      String sql = "SELECT id, width, height, min_distance FROM cinema WHERE TRUE ORDER  BY id DESC LIMIT 1";
      Connection cons = CinemaDatabase.getInstance().getConnection();
      Statement stmt = cons.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);

      if (resultSet.next()) {
        cinema = new Cinema(
          resultSet.getInt(1), resultSet.getInt(2),
          resultSet.getInt(3), resultSet.getInt(4)
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cinema;
  }

  public int insertSeats(int cinemaId, ArrayList<Seat> seats) {
    int affected = 0;
    try {
      String sql = "INSERT INTO seat (row_no, column_no, cinema_id) VALUES (?, ?, ?)";
      Connection cons = CinemaDatabase.getInstance().getConnection();
      cons.setAutoCommit(false);
      PreparedStatement stmt = cons.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      for (int i = 0; i < seats.size(); i++) {
        stmt.setInt(1, seats.get(i).getRow_no());
        stmt.setInt(2, seats.get(i).getColumn_no());
        stmt.setInt(3, cinemaId);
        affected += stmt.executeUpdate();
      }
      cons.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return affected;
  }
}
