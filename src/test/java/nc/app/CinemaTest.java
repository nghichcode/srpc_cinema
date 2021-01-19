package nc.app;

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
    System.out.println(c.cinemaRepository.createCinema(new Cinema(3, 5, 0)).equals(
      new CreateStatus(CreateStatus.TYPE.INVALID, -1)
    ));
  }

  @Test
  public void testCreateTooSmallDistance() {
    assertEquals(
      true,
      cinemaRepository.createCinema(new Cinema(3, 5, 0)).equals(
        new CreateStatus(CreateStatus.TYPE.INVALID, -1)
      )
    );
  }

  @Test
  public void testCreateTooBigDistance() {
    assertEquals(
      true,
      cinemaRepository.createCinema(new Cinema(3, 5, 8)).equals(
        new CreateStatus(CreateStatus.TYPE.INVALID, -1)
      )
    );
  }

  @Test
  public void testValidDistance() {
    cinema = new Cinema(3, 5, 4);
    CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    cinema.setId(createStatus.cinema_id);
    assertEquals(
      true,
      createStatus.equals(new CreateStatus(CreateStatus.TYPE.SUCCESS, createStatus.cinema_id))
    );
  }

  @Test
  public void getAvailableSeatsToSmall() {
    cinema = new Cinema(3, 5, 4);
    CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    cinema.setId(createStatus.cinema_id);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 0);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.NOT_AVAILABLE
    );
  }

  @Test
  public void getAvailableSeatsToBig() {
    cinema = new Cinema(3, 5, 4);
    CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    cinema.setId(createStatus.cinema_id);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 99);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.NOT_AVAILABLE
    );
  }

  @Test
  public void getAvailableSeatsWithInvalidCinema() {
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(0, 99);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.GET_FAIL
    );
  }

  @Test
  public void getAvailableSeatsInValid() {
    ArrayList<Seat> seats = new ArrayList<>();
    seats.add(new Seat(0, 1));
    seats.add(new Seat(0, 2));
    cinema = new Cinema(2, 2, 2);
    CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    cinema.setId(createStatus.cinema_id);
    cinemaRepository.insertSeats(cinema, seats);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 2);
    status = cinemaRepository.getAvailableSeats(cinema.getId(), 2);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.NOT_AVAILABLE
    );
  }

  @Test
  public void getAvailableSeatsValid() {
    ArrayList<Seat> seats = new ArrayList<>();
    seats.add(new Seat(1, 0));
    seats.add(new Seat(2, 0));
    cinema = new Cinema(4, 6, 2);
    CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    cinema.setId(createStatus.cinema_id);
    cinemaRepository.insertSeats(cinema, seats);
    Cinema.AvailableStatus status = cinemaRepository.getAvailableSeats(cinema.getId(), 2);
    assertEquals(
      true,
      status.type == Cinema.AvailableStatus.TYPE.SUCCESS
    );
  }

  @Test
  public void reserveEmpty() {
    ArrayList<Seat> seats = new ArrayList<>();
    cinema = new Cinema(2, 2, 2);
    Cinema.CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    Cinema.ReservedStatus status = cinemaRepository.reserve(cinema.getId(), seats);
    assertEquals(
      true,
      status.type == Cinema.ReservedStatus.TYPE.EMPTY
    );
  }

  @Test
  public void reserveInValid() {
    ArrayList<Seat> seats = new ArrayList<>();
    seats.add(new Seat(0, 1));
    seats.add(new Seat(1, 1));
    cinema = new Cinema(2, 2, 2);
    Cinema.CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    cinema.setId(createStatus.cinema_id);
    Cinema.ReservedStatus status = cinemaRepository.reserve(cinema.getId(), seats);
    seats = new ArrayList<>();
    seats.add(new Seat(0, 1));
    status = cinemaRepository.reserve(cinema.getId(), seats);
    assertEquals(
      true,
      status.type == Cinema.ReservedStatus.TYPE.RESERVE_FAIL
    );
  }

  @Test
  public void reserveValid() {
    ArrayList<Seat> seats = new ArrayList<>();
    seats.add(new Seat(0, 1));
    seats.add(new Seat(1, 1));
    cinema = new Cinema(3, 5, 2);
    Cinema.CreateStatus createStatus = cinemaRepository.createCinema(cinema);
    Cinema.ReservedStatus status = cinemaRepository.reserve(createStatus.cinema_id, seats);
    assertEquals(
      true,
      status.type == Cinema.ReservedStatus.TYPE.SUCCESS
    );
  }

}
