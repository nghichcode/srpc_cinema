package nc.app.repository;

import nc.app.dao.CinemaDao;
import nc.app.models.Cinema;
import nc.app.models.Cinema.AvailableStatus;
import nc.app.models.Cinema.CreateStatus;
import nc.app.models.Cinema.ReservedStatus;
import nc.app.models.Seat;

import java.util.ArrayList;

public class CinemaRepository {
  private CinemaDao cinemaDao = new CinemaDao();

  public CreateStatus create(Cinema cinema) {
    // Check min_distance is valid
    if (cinema.getMin_distance() <= 0
      || cinema.getMin_distance() > cinema.getHeight() + cinema.getWidth() - 2
    )
      return new CreateStatus(CreateStatus.TYPE.INVALID, -1);
    return cinemaDao.createCinema(cinema);
  }

  public AvailableStatus getAvailableSeats(int cinemaId, int quantity) {
    ArrayList<Seat> seats = cinemaDao.getReservedSeats(cinemaId);
    ArrayList<Seat> availableSeats = new ArrayList<>();
    return new AvailableStatus(AvailableStatus.TYPE.SUCCESS, availableSeats);
  }

  public Cinema getLastCinema() {
    return cinemaDao.getLastCinema();
  }

  public ReservedStatus reserve(int cinemaId, ArrayList<Seat> seats) {
    ArrayList<Seat> invalidSeats = new ArrayList<>();
    if (seats.size() <= 0)
      return new ReservedStatus(ReservedStatus.TYPE.EMPTY, invalidSeats);
    ArrayList<Seat> reservedSeats = cinemaDao.getReservedSeats(cinemaId);
    Cinema cinema = cinemaDao.getCinemaById(cinemaId);
    for (int i = 0; i < seats.size(); i++) {
      for (int j = 0; j < reservedSeats.size(); j++) {
        if (Seat.LmDistance(seats.get(i), reservedSeats.get(j)) < cinema.getMin_distance()) {
          invalidSeats.add(seats.get(i));
        }
      }
    }
    if (invalidSeats.size() > 0)
      return new ReservedStatus(ReservedStatus.TYPE.RESERVE_FAIL, invalidSeats);
    else {
      if (cinemaDao.insertSeats(cinemaId, seats) > 0)
        return new ReservedStatus(ReservedStatus.TYPE.SUCCESS, invalidSeats);
      else return new ReservedStatus(ReservedStatus.TYPE.INSERT_FAIL, invalidSeats);
    }
  }

}
