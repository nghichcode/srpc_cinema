package nc.proto.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: nc/proto/CinemaService.proto")
public final class CinemaServiceGrpc {

  private CinemaServiceGrpc() {}

  public static final String SERVICE_NAME = "nc.proto.generated.CinemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.CreateRequest,
      nc.proto.generated.CinemaServiceOuterClass.CreateResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "create",
      requestType = nc.proto.generated.CinemaServiceOuterClass.CreateRequest.class,
      responseType = nc.proto.generated.CinemaServiceOuterClass.CreateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.CreateRequest,
      nc.proto.generated.CinemaServiceOuterClass.CreateResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.CreateRequest, nc.proto.generated.CinemaServiceOuterClass.CreateResponse> getCreateMethod;
    if ((getCreateMethod = CinemaServiceGrpc.getCreateMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getCreateMethod = CinemaServiceGrpc.getCreateMethod) == null) {
          CinemaServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<nc.proto.generated.CinemaServiceOuterClass.CreateRequest, nc.proto.generated.CinemaServiceOuterClass.CreateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nc.proto.generated.CinemaServiceOuterClass.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nc.proto.generated.CinemaServiceOuterClass.CreateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest,
      nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse> getGetAvailableSeatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAvailableSeats",
      requestType = nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest.class,
      responseType = nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest,
      nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse> getGetAvailableSeatsMethod() {
    io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest, nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse> getGetAvailableSeatsMethod;
    if ((getGetAvailableSeatsMethod = CinemaServiceGrpc.getGetAvailableSeatsMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getGetAvailableSeatsMethod = CinemaServiceGrpc.getGetAvailableSeatsMethod) == null) {
          CinemaServiceGrpc.getGetAvailableSeatsMethod = getGetAvailableSeatsMethod =
              io.grpc.MethodDescriptor.<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest, nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAvailableSeats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("getAvailableSeats"))
              .build();
        }
      }
    }
    return getGetAvailableSeatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.ReserveRequest,
      nc.proto.generated.CinemaServiceOuterClass.ReserveResponse> getReserveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reserve",
      requestType = nc.proto.generated.CinemaServiceOuterClass.ReserveRequest.class,
      responseType = nc.proto.generated.CinemaServiceOuterClass.ReserveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.ReserveRequest,
      nc.proto.generated.CinemaServiceOuterClass.ReserveResponse> getReserveMethod() {
    io.grpc.MethodDescriptor<nc.proto.generated.CinemaServiceOuterClass.ReserveRequest, nc.proto.generated.CinemaServiceOuterClass.ReserveResponse> getReserveMethod;
    if ((getReserveMethod = CinemaServiceGrpc.getReserveMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getReserveMethod = CinemaServiceGrpc.getReserveMethod) == null) {
          CinemaServiceGrpc.getReserveMethod = getReserveMethod =
              io.grpc.MethodDescriptor.<nc.proto.generated.CinemaServiceOuterClass.ReserveRequest, nc.proto.generated.CinemaServiceOuterClass.ReserveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reserve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nc.proto.generated.CinemaServiceOuterClass.ReserveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nc.proto.generated.CinemaServiceOuterClass.ReserveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("reserve"))
              .build();
        }
      }
    }
    return getReserveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CinemaServiceStub newStub(io.grpc.Channel channel) {
    return new CinemaServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CinemaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CinemaServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CinemaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CinemaServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CinemaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(nc.proto.generated.CinemaServiceOuterClass.CreateRequest request,
        io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.CreateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    public void getAvailableSeats(nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest request,
        io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAvailableSeatsMethod(), responseObserver);
    }

    /**
     */
    public void reserve(nc.proto.generated.CinemaServiceOuterClass.ReserveRequest request,
        io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.ReserveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReserveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nc.proto.generated.CinemaServiceOuterClass.CreateRequest,
                nc.proto.generated.CinemaServiceOuterClass.CreateResponse>(
                  this, METHODID_CREATE)))
          .addMethod(
            getGetAvailableSeatsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest,
                nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse>(
                  this, METHODID_GET_AVAILABLE_SEATS)))
          .addMethod(
            getReserveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nc.proto.generated.CinemaServiceOuterClass.ReserveRequest,
                nc.proto.generated.CinemaServiceOuterClass.ReserveResponse>(
                  this, METHODID_RESERVE)))
          .build();
    }
  }

  /**
   */
  public static final class CinemaServiceStub extends io.grpc.stub.AbstractStub<CinemaServiceStub> {
    private CinemaServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(nc.proto.generated.CinemaServiceOuterClass.CreateRequest request,
        io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.CreateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAvailableSeats(nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest request,
        io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAvailableSeatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reserve(nc.proto.generated.CinemaServiceOuterClass.ReserveRequest request,
        io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.ReserveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReserveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CinemaServiceBlockingStub extends io.grpc.stub.AbstractStub<CinemaServiceBlockingStub> {
    private CinemaServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public nc.proto.generated.CinemaServiceOuterClass.CreateResponse create(nc.proto.generated.CinemaServiceOuterClass.CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse getAvailableSeats(nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAvailableSeatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public nc.proto.generated.CinemaServiceOuterClass.ReserveResponse reserve(nc.proto.generated.CinemaServiceOuterClass.ReserveRequest request) {
      return blockingUnaryCall(
          getChannel(), getReserveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CinemaServiceFutureStub extends io.grpc.stub.AbstractStub<CinemaServiceFutureStub> {
    private CinemaServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<nc.proto.generated.CinemaServiceOuterClass.CreateResponse> create(
        nc.proto.generated.CinemaServiceOuterClass.CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse> getAvailableSeats(
        nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAvailableSeatsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<nc.proto.generated.CinemaServiceOuterClass.ReserveResponse> reserve(
        nc.proto.generated.CinemaServiceOuterClass.ReserveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReserveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_GET_AVAILABLE_SEATS = 1;
  private static final int METHODID_RESERVE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CinemaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((nc.proto.generated.CinemaServiceOuterClass.CreateRequest) request,
              (io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.CreateResponse>) responseObserver);
          break;
        case METHODID_GET_AVAILABLE_SEATS:
          serviceImpl.getAvailableSeats((nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsRequest) request,
              (io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.GetAvailableSeatsResponse>) responseObserver);
          break;
        case METHODID_RESERVE:
          serviceImpl.reserve((nc.proto.generated.CinemaServiceOuterClass.ReserveRequest) request,
              (io.grpc.stub.StreamObserver<nc.proto.generated.CinemaServiceOuterClass.ReserveResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CinemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CinemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return nc.proto.generated.CinemaServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CinemaService");
    }
  }

  private static final class CinemaServiceFileDescriptorSupplier
      extends CinemaServiceBaseDescriptorSupplier {
    CinemaServiceFileDescriptorSupplier() {}
  }

  private static final class CinemaServiceMethodDescriptorSupplier
      extends CinemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CinemaServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CinemaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CinemaServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getGetAvailableSeatsMethod())
              .addMethod(getReserveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
