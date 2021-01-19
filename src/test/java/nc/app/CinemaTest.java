package nc.app;

import nc.app.dao.CinemaDao;
import nc.app.models.Cinema;
import nc.app.models.Seat;
import nc.app.models.Cinema.CreateStatus;
import nc.app.repository.CinemaRepository;
import org.junit.jupiter.api.Test;
//import org.juni.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class CinemaTest {
  public CinemaRepository cinemaRepository = new CinemaRepository();
  public Cinema cinema;

  public static void main(String[] args) {
    CinemaTest c = new CinemaTest();
    System.out.println(c.cinemaRepository.create(new Cinema(3, 5, 0)).equals(
      new CreateStatus(CreateStatus.TYPE.INVALID, -1)
    ));
  }

  @Test
  public void testCreateTooSmallDistance() {
    assertEquals(
      true,
      cinemaRepository.create(new Cinema(3, 5, 0)).equals(
        new CreateStatus(CreateStatus.TYPE.INVALID, -1)
      )
    );
  }

  @Test
  public void testCreateTooBigDistance() {
    assertEquals(
      true,
      cinemaRepository.create(new Cinema(3, 5, 8)).equals(
        new CreateStatus(CreateStatus.TYPE.INVALID, -1)
      )
    );
  }

  @Test
  public void testValidDistance() {
    cinema = new Cinema(3, 5, 4);
    CreateStatus createStatus = cinemaRepository.create(cinema);
    cinema.setId(createStatus.cinema_id);
    assertEquals(
      true,
      createStatus.equals(new CreateStatus(CreateStatus.TYPE.SUCCESS, createStatus.cinema_id))
    );
  }

  @Test
  public void getAvailableSeatsToSmall() {
    cinema = new Cinema(3, 5, 4);
    CreateStatus createStatus = cinemaRepository.create(cinema);
    cinema.setId(createStatus.cinema_id);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 0);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.GET_FAIL
    );
  }

  public void getAvailableSeatsToBig() {
    cinema = new Cinema(3, 5, 4);
    CreateStatus createStatus = cinemaRepository.create(cinema);
    cinema.setId(createStatus.cinema_id);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 99);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.NOT_AVAILABLE
    );
  }

  public void getAvailableSeatsValid() {
    ArrayList<Seat> seats = new ArrayList<>();
    seats.add(new Seat(1, 0));
    seats.add(new Seat(3, 0));
    cinema = new Cinema(3, 5, 2);
    CreateStatus createStatus = cinemaRepository.create(cinema);
    cinema.setId(createStatus.cinema_id);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 2);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.SUCCESS
    );
  }

  public void reserveValid() {
    ArrayList<Seat> seats = new ArrayList<>();
    seats.add(new Seat(0, 1));
    seats.add(new Seat(1, 1));
    cinema = new Cinema(3, 5, 4);
    Cinema.CreateStatus createStatus = cinemaRepository.create(cinema);
    Cinema.ReservedStatus status = cinemaRepository.reserve(cinema.getId(), seats);
    assertEquals(
      true,
      status.type == Cinema.ReservedStatus.TYPE.SUCCESS
    );
  }
https://github.com/nghichcode/srpc_cinema.git
}
