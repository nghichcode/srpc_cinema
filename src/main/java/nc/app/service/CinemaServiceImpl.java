package nc.app.service;

import io.grpc.stub.StreamObserver;
import nc.app.models.Cinema;
import nc.app.models.Seat;
import nc.app.repository.CinemaRepository;
import nc.proto.generated.CinemaServiceGrpc;
import nc.proto.generated.CinemaServiceOuterClass;
import nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse;

import nc.proto.generated.CinemaServiceOuterClass.*;

import java.util.ArrayList;


public class CinemaServiceImpl extends CinemaServiceGrpc.CinemaServiceImplBase {
  CinemaRepository repository = new CinemaRepository();

  @Override
  public void create(
    CreateRequest request,
    StreamObserver<CreateResponse> responseObserver
  ) {
    Cinema.CreateStatus status = repository.create(
      new Cinema(request.getWidth(), request.getHeight(), request.getMinDistance())
    );
    CreateResponse response = CreateResponse.newBuilder()
      .setCode(status.type.code)
      .setStatus(status.type.status)
      .setCinemaId(status.cinema_id)
      .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getAvailableSeats(
    GetAvailableSeatsRequest request, StreamObserver<GetAvailableSeatsResponse> responseObserver
  ) {
    Cinema.AvailableStatus status = repository.getAvailableSeats(
      request.getCinemaId(), request.getQuantity()
    );
    GetAvailableSeatsResponse.Builder builder = GetAvailableSeatsResponse.newBuilder()
      .setCode(status.type.code)
      .setStatus(status.type.status);
    for (int i = 0; i < status.availableSeats.size(); i++) {
      builder.addAvailableSeats(
        CinemaServiceOuterClass.Seat.newBuilder()
          .setRowNo(status.availableSeats.get(i).getRow_no())
          .setColumnNo(status.availableSeats.get(i).getColumn_no())
      );
    }
    GetAvailableSeatsResponse response = builder.build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void reserve(ReserveRequest request, StreamObserver<ReserveResponse> responseObserver) {
    ArrayList<Seat> seats = new ArrayList<>();
    for (CinemaServiceOuterClass.Seat requestSeat : request.getSeatsList()) {
      seats.add(new Seat(requestSeat.getRowNo(), requestSeat.getColumnNo()));
    }
    Cinema.ReservedStatus status = repository.reserve(
      request.getCinemaId(), seats
    );
    ReserveResponse.Builder builder = ReserveResponse.newBuilder()
      .setCode(status.type.code)
      .setStatus(status.type.status);
    for (int i = 0; i < status.invalid_seats.size(); i++) {
      builder.addInvalidSeats(
        CinemaServiceOuterClass.Seat.newBuilder()
          .setRowNo(status.invalid_seats.get(i).getRow_no())
          .setColumnNo(status.invalid_seats.get(i).getColumn_no())
      );
    }
    ReserveResponse response = builder.build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
