package nc.app.repository;

import nc.app.dao.CinemaDao;
import nc.app.models.Cinema;
import nc.app.models.Cinema.AvailableStatus;
import nc.app.models.Cinema.CreateStatus;
import nc.app.models.Cinema.ReservedStatus;
import nc.app.models.Seat;

import java.util.ArrayList;
import java.util.HashSet;

public class CinemaRepository {
  private CinemaDao cinemaDao = new CinemaDao();

  public CreateStatus createCinema(Cinema cinema) {
    // Check min_distance is valid
    if (cinema == null || cinema.getMin_distance() <= 0
      || cinema.getMin_distance() > cinema.getHeight() + cinema.getWidth() - 2
    )
      return new CreateStatus(CreateStatus.TYPE.INVALID, -1);
    return cinemaDao.createCinema(cinema);
  }

  public AvailableStatus getAvailableSeats(int cinemaId, int quantity) {
    ArrayList<Seat> availableSeats = new ArrayList<>();
    if (quantity < 1) return new AvailableStatus(AvailableStatus.TYPE.NOT_AVAILABLE, availableSeats);
    Cinema cinema = cinemaDao.getCinemaById(cinemaId);
    if (cinema == null) return new AvailableStatus(AvailableStatus.TYPE.GET_FAIL, availableSeats);
    if (quantity > cinema.getWidth() * cinema.getHeight())
      return new AvailableStatus(AvailableStatus.TYPE.NOT_AVAILABLE, availableSeats);

    ArrayList<Seat> reservedSeats = cinemaDao.getReservedSeats(cinemaId);

    // Get all invalid seats as HashSet
    HashSet<Integer> invalidSeatsSet = new HashSet<>();
    for (int i = 0; i < reservedSeats.size(); i++) {
      Seat reservedSeat = reservedSeats.get(i);
      int minColumn = reservedSeat.getColumn_no() - cinema.getMin_distance() + 1;
      minColumn = minColumn < 0 ? 0 : minColumn;
      int maxColumn = (minColumn + cinema.getMin_distance() < cinema.getHeight())
        ? minColumn + cinema.getMin_distance() : cinema.getHeight();
      int minRow = reservedSeat.getRow_no() - cinema.getMin_distance() + 1;
      minRow = minRow < 0 ? 0 : minRow;
      int maxRow = (reservedSeat.getRow_no() + cinema.getMin_distance() < cinema.getWidth())
        ? reservedSeat.getRow_no() + cinema.getMin_distance() : cinema.getWidth();
      for (int j = minColumn; j < maxColumn; j++) {
        for (int k = minRow; k < maxRow; k++) {
          Seat seat = new Seat(k, j);
          if (Seat.LmDistance(reservedSeat, seat) < cinema.getMin_distance())
            invalidSeatsSet.add(seat.flat(cinema));
        }
      }
    }
    // Check enough available seats
    int count = 0;
    for (int i = 0; i < cinema.getWidth(); i++) {
      for (int j = 0; j < cinema.getHeight(); j++) {
        if (!invalidSeatsSet.contains(Seat.flat(cinema, j, i))) {
          availableSeats.add(new Seat(j, i));
          count++;
        }
        if (count >= quantity) break;
      }
      if (count >= quantity) break;
    }
    if (count == quantity) return new AvailableStatus(AvailableStatus.TYPE.SUCCESS, availableSeats);
    else return new AvailableStatus(AvailableStatus.TYPE.NOT_AVAILABLE, availableSeats);
  }

  private ArrayList<Seat> getAvailableSeats(int quantity, Cinema cinema, Seat currentSeat) {
    ArrayList<Seat> availableSeats = new ArrayList<>();
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
    return availableSeats;
  }

  public Cinema getLastCinema() {
    return cinemaDao.getLastCinema();
  }

  public ReservedStatus reserve(int cinemaId, ArrayList<Seat> seats) {
    ArrayList<Seat> invalidSeats = new ArrayList<>();
    if (seats == null || seats.size() <= 0)
      return new ReservedStatus(ReservedStatus.TYPE.EMPTY, invalidSeats);
    Cinema cinema = cinemaDao.getCinemaById(cinemaId);
    if (cinema == null)
      return new ReservedStatus(ReservedStatus.TYPE.RESERVE_FAIL, invalidSeats);

    ArrayList<Seat> reservedSeats = cinemaDao.getReservedSeats(cinemaId);
    ArrayList<Seat> reservedSeatsTmp = new ArrayList<>();
    for (int i = 0; i < seats.size(); i++) {
      boolean validSeat = true;
      validSeat = isValidDistanceSeat(cinema, reservedSeats, seats.get(i));
      if (!validSeat) {
        invalidSeats.add(seats.get(i));
        continue;
      }
      validSeat = isValidSeat(cinema, reservedSeatsTmp, seats.get(i));
      if (validSeat) reservedSeatsTmp.add(seats.get(i));
      else invalidSeats.add(seats.get(i));
    }
    if (invalidSeats.size() > 0)
      return new ReservedStatus(ReservedStatus.TYPE.RESERVE_FAIL, invalidSeats);
    else {
      if (cinemaDao.insertSeats(cinemaId, seats) > 0)
        return new ReservedStatus(ReservedStatus.TYPE.SUCCESS, invalidSeats);
      else return new ReservedStatus(ReservedStatus.TYPE.INSERT_FAIL, invalidSeats);
    }
  }

  public void insertSeats(Cinema cinema, ArrayList<Seat> seats) {
    cinemaDao.insertSeats(cinema.getId(), seats);
  }

  private boolean isValidDistanceSeat(
    Cinema cinema, ArrayList<Seat> reservedSeats, Seat seat
  ) {
    boolean validSeat = true;
    for (int j = 0; j < reservedSeats.size(); j++) {
      if (Seat.LmDistance(seat, reservedSeats.get(j)) < cinema.getMin_distance()) {
        validSeat = false;
        continue;
      }
    }
    return validSeat;
  }

  private boolean isValidSeat(
    Cinema cinema, ArrayList<Seat> reservedSeats, Seat seat
  ) {
    boolean validSeat = true;
    for (int j = 0; j < reservedSeats.size(); j++) {
      if (seat.equals(reservedSeats.get(j))) {
        validSeat = false;
        continue;
      }
    }
    return validSeat;
  }

}
