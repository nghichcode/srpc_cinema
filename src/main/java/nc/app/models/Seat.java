package nc.app.models;

public class Seat {
  private int id;

  private int row_no;
  private int column_no;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRow_no() {
    return row_no;
  }

  public void setRow_no(int row_no) {
    this.row_no = row_no;
  }

  public int getColumn_no() {
    return column_no;
  }

  public void setColumn_no(int column_no) {
    this.column_no = column_no;
  }

  public Seat(int row_no, int column_no) {
    this.row_no = row_no;
    this.column_no = column_no;
  }

  public Seat(int id, int row_no, int column_no) {
    this.id = id;
    this.row_no = row_no;
    this.column_no = column_no;
  }

  public static int LmDistance(Seat src, Seat dst) {
    return Math.abs(src.getRow_no() - dst.getRow_no()) + Math.abs(src.getColumn_no() - dst.getColumn_no());
  }

  @Override
  public String toString() {
    return "Seat{" +
      "id=" + id +
      ", row_no=" + row_no +
      ", column_no=" + column_no +
      '}';
  }
}
