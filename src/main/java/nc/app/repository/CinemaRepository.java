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
    Cinema cinema = cinemaDao.getCinemaById(cinemaId);
    ArrayList<Seat> reservedSeats = cinemaDao.getReservedSeats(cinemaId);
    ArrayList<Seat> availableSeats = new ArrayList<>();
    if (reservedSeats.size() < 1) {
      Seat currentSeat = new Seat(0, 0);
      for (int i = 1; i <= quantity; i++) {
        if (currentSeat.getRow_no() > cinema.getWidth()) {
          currentSeat.setColumn_no(currentSeat.getColumn_no() + 1);
          currentSeat.setRow_no(cinema.getMin_distance() - currentSeat.getColumn_no());
        }
        if (currentSeat.getRow_no() <= cinema.getWidth() && currentSeat.getColumn_no() <= cinema.getHeight()) {
          availableSeats.add(new Seat(currentSeat.getRow_no(), currentSeat.getColumn_no()));
          currentSeat.setRow_no(currentSeat.getRow_no() + 1);
        }
      }
    }
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
    ArrayList<Seat> reservedSeatsTmp = new ArrayList<>();
    Cinema cinema = cinemaDao.getCinemaById(cinemaId);
    for (int i = 0; i < seats.size(); i++) {
      boolean validSeat = true;
      validSeat = isValidSeat(seats, invalidSeats, reservedSeats, cinema, i, validSeat);
      if (!validSeat) continue;
      validSeat = isValidSeat(seats, invalidSeats, reservedSeatsTmp, cinema, i, validSeat);
      if (validSeat) reservedSeatsTmp.add(seats.get(i));
    }
    if (invalidSeats.size() > 0)
      return new ReservedStatus(ReservedStatus.TYPE.RESERVE_FAIL, invalidSeats);
    else {
      if (cinemaDao.insertSeats(cinemaId, seats) > 0)
        return new ReservedStatus(ReservedStatus.TYPE.SUCCESS, invalidSeats);
      else return new ReservedStatus(ReservedStatus.TYPE.INSERT_FAIL, invalidSeats);
    }
  }

  private boolean isValidSeat(
    ArrayList<Seat> seats,
    ArrayList<Seat> invalidSeats,
    ArrayList<Seat> reservedSeatsTmp,
    Cinema cinema, int i, boolean validSeat
  ) {
    for (int j = 0; j < reservedSeatsTmp.size(); j++) {
      if (Seat.LmDistance(seats.get(i), reservedSeatsTmp.get(j)) < cinema.getMin_distance()) {
        invalidSeats.add(seats.get(i));
        validSeat = false;
        continue;
      }
    }
    return validSeat;
  }

}
