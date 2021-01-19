package nc.app.models;

import java.util.ArrayList;
import java.util.Objects;

public class Cinema {
  public static class CreateStatus {
    public static enum TYPE {
      SUCCESS(2, "Success"),
      INVALID(3, "Invalid data"),
      CREATE_FAIL(4, "Create error");

      public int code;
      public String status;

      TYPE(int code, String status) {
        this.code = code;
        this.status = status;
      }
    }

    public TYPE type;
    public int cinema_id;

    public CreateStatus(TYPE type, int cinema_id) {
      this.type = type;
      this.cinema_id = cinema_id;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      CreateStatus that = (CreateStatus) o;
      return cinema_id == that.cinema_id &&
        type == that.type;
    }

    @Override
    public String toString() {
      return "CreateStatus{" +
        "type=" + type +
        ", cinema_id=" + cinema_id +
        '}';
    }
  }

  public static class ReservedStatus {
    public static enum TYPE {
      SUCCESS(2, "Success"),
      EMPTY(3, "Reserved seats is empty"),
      RESERVE_FAIL(4, "Reserve error (Some seat possition is not valid)"),
      INSERT_FAIL(5, "Can not reserve given seats");

      public int code;
      public String status;

      TYPE(int code, String status) {
        this.code = code;
        this.status = status;
      }
    }

    public TYPE type;
    public ArrayList<Seat> invalid_seats;

    public ReservedStatus(TYPE type, ArrayList<Seat> invalid_seats) {
      this.type = type;
      this.invalid_seats = invalid_seats;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ReservedStatus that = (ReservedStatus) o;
      if (invalid_seats.size() != that.invalid_seats.size()) return type == that.type && false;
      boolean equals_seats = true;
      for (int i = 0; i < invalid_seats.size(); i++) {
        if (!invalid_seats.get(i).equals(that.invalid_seats.get(i))) {
          equals_seats = false;
          break;
        }
      }
      return type == that.type && equals_seats;
    }

    @Override
    public String toString() {
      return "ReservedStatus{" +
        "type=" + type +
        ", invalid_seats=" + invalid_seats +
        '}';
    }
  }

  public static class AvailableStatus {
    public static enum TYPE {
      SUCCESS(2, "Success"),
      NOT_AVAILABLE(4, "Seat capacity is not enough"),
      GET_FAIL(5, "Get available seats error");

      public int code;
      public String status;

      TYPE(int code, String status) {
        this.code = code;
        this.status = status;
      }
    }

    public TYPE type;
    public ArrayList<Seat> availableSeats;

    public AvailableStatus(TYPE type, ArrayList<Seat> availableSeats) {
      this.type = type;
      this.availableSeats = availableSeats;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      AvailableStatus that = (AvailableStatus) o;
      return type == that.type &&
        Objects.equals(availableSeats, that.availableSeats);
    }

    @Override
    public String toString() {
      return "AvailableStatus{" +
        "type=" + type +
        ", availableSeats=" + availableSeats +
        '}';
    }
  }

  private int id;

  private int width;
  private int height;
  private int min_distance;
  private ArrayList<Seat> reservedSeats;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getMin_distance() {
    return min_distance;
  }

  public void setMin_distance(int min_distance) {
    this.min_distance = min_distance;
  }

  public ArrayList<Seat> getReservedSeats() {
    return reservedSeats;
  }

  public void setReservedSeats(ArrayList<Seat> reservedSeats) {
    this.reservedSeats = reservedSeats;
  }

  public Cinema(int width, int height, int min_distance) {
    this.width = width;
    this.height = height;
    this.min_distance = min_distance;
  }

  public Cinema(int id, int width, int height, int min_distance) {
    this.id = id;
    this.width = width;
    this.height = height;
    this.min_distance = min_distance;
  }
}
