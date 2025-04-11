package turnstile;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: turnstile.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TurnstileServiceGrpc {

  private TurnstileServiceGrpc() {}

  public static final String SERVICE_NAME = "turnstile.TurnstileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<turnstile.Turnstile.CheckPinRequest,
      turnstile.Turnstile.CheckPinResponse> getCheckPinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckPin",
      requestType = turnstile.Turnstile.CheckPinRequest.class,
      responseType = turnstile.Turnstile.CheckPinResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<turnstile.Turnstile.CheckPinRequest,
      turnstile.Turnstile.CheckPinResponse> getCheckPinMethod() {
    io.grpc.MethodDescriptor<turnstile.Turnstile.CheckPinRequest, turnstile.Turnstile.CheckPinResponse> getCheckPinMethod;
    if ((getCheckPinMethod = TurnstileServiceGrpc.getCheckPinMethod) == null) {
      synchronized (TurnstileServiceGrpc.class) {
        if ((getCheckPinMethod = TurnstileServiceGrpc.getCheckPinMethod) == null) {
          TurnstileServiceGrpc.getCheckPinMethod = getCheckPinMethod =
              io.grpc.MethodDescriptor.<turnstile.Turnstile.CheckPinRequest, turnstile.Turnstile.CheckPinResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckPin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  turnstile.Turnstile.CheckPinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  turnstile.Turnstile.CheckPinResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TurnstileServiceMethodDescriptorSupplier("CheckPin"))
              .build();
        }
      }
    }
    return getCheckPinMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TurnstileServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TurnstileServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TurnstileServiceStub>() {
        @java.lang.Override
        public TurnstileServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TurnstileServiceStub(channel, callOptions);
        }
      };
    return TurnstileServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TurnstileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TurnstileServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TurnstileServiceBlockingStub>() {
        @java.lang.Override
        public TurnstileServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TurnstileServiceBlockingStub(channel, callOptions);
        }
      };
    return TurnstileServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TurnstileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TurnstileServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TurnstileServiceFutureStub>() {
        @java.lang.Override
        public TurnstileServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TurnstileServiceFutureStub(channel, callOptions);
        }
      };
    return TurnstileServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TurnstileServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * To allow someone to enter the building get a valid pin
     * </pre>
     */
    public void checkPin(turnstile.Turnstile.CheckPinRequest request,
        io.grpc.stub.StreamObserver<turnstile.Turnstile.CheckPinResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckPinMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckPinMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                turnstile.Turnstile.CheckPinRequest,
                turnstile.Turnstile.CheckPinResponse>(
                  this, METHODID_CHECK_PIN)))
          .build();
    }
  }

  /**
   */
  public static final class TurnstileServiceStub extends io.grpc.stub.AbstractAsyncStub<TurnstileServiceStub> {
    private TurnstileServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TurnstileServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TurnstileServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * To allow someone to enter the building get a valid pin
     * </pre>
     */
    public void checkPin(turnstile.Turnstile.CheckPinRequest request,
        io.grpc.stub.StreamObserver<turnstile.Turnstile.CheckPinResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckPinMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TurnstileServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TurnstileServiceBlockingStub> {
    private TurnstileServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TurnstileServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TurnstileServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * To allow someone to enter the building get a valid pin
     * </pre>
     */
    public turnstile.Turnstile.CheckPinResponse checkPin(turnstile.Turnstile.CheckPinRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckPinMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TurnstileServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TurnstileServiceFutureStub> {
    private TurnstileServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TurnstileServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TurnstileServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * To allow someone to enter the building get a valid pin
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<turnstile.Turnstile.CheckPinResponse> checkPin(
        turnstile.Turnstile.CheckPinRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckPinMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_PIN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TurnstileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TurnstileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_PIN:
          serviceImpl.checkPin((turnstile.Turnstile.CheckPinRequest) request,
              (io.grpc.stub.StreamObserver<turnstile.Turnstile.CheckPinResponse>) responseObserver);
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

  private static abstract class TurnstileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TurnstileServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return turnstile.Turnstile.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TurnstileService");
    }
  }

  private static final class TurnstileServiceFileDescriptorSupplier
      extends TurnstileServiceBaseDescriptorSupplier {
    TurnstileServiceFileDescriptorSupplier() {}
  }

  private static final class TurnstileServiceMethodDescriptorSupplier
      extends TurnstileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TurnstileServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TurnstileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TurnstileServiceFileDescriptorSupplier())
              .addMethod(getCheckPinMethod())
              .build();
        }
      }
    }
    return result;
  }
}
