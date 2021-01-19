package nc.app;

import io.grpc.*;
import nc.app.service.CinemaServiceImpl;

public class App {
  public static void main(String[] args) throws Exception {
    Server server = ServerBuilder.forPort(8080).addService(new CinemaServiceImpl()).build();
    server.start();
    System.out.println("Running");
    server.awaitTermination();
  }
}