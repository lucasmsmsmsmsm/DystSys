package time;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: time.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WaitServiceGrpc {

  private WaitServiceGrpc() {}

  public static final String SERVICE_NAME = "time.WaitService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<time.Time.WaitTimeRequest,
      time.Time.WaitTimeUpdate> getStreamWaitTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamWaitTime",
      requestType = time.Time.WaitTimeRequest.class,
      responseType = time.Time.WaitTimeUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<time.Time.WaitTimeRequest,
      time.Time.WaitTimeUpdate> getStreamWaitTimeMethod() {
    io.grpc.MethodDescriptor<time.Time.WaitTimeRequest, time.Time.WaitTimeUpdate> getStreamWaitTimeMethod;
    if ((getStreamWaitTimeMethod = WaitServiceGrpc.getStreamWaitTimeMethod) == null) {
      synchronized (WaitServiceGrpc.class) {
        if ((getStreamWaitTimeMethod = WaitServiceGrpc.getStreamWaitTimeMethod) == null) {
          WaitServiceGrpc.getStreamWaitTimeMethod = getStreamWaitTimeMethod =
              io.grpc.MethodDescriptor.<time.Time.WaitTimeRequest, time.Time.WaitTimeUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamWaitTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  time.Time.WaitTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  time.Time.WaitTimeUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new WaitServiceMethodDescriptorSupplier("StreamWaitTime"))
              .build();
        }
      }
    }
    return getStreamWaitTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WaitServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WaitServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WaitServiceStub>() {
        @java.lang.Override
        public WaitServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WaitServiceStub(channel, callOptions);
        }
      };
    return WaitServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WaitServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WaitServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WaitServiceBlockingStub>() {
        @java.lang.Override
        public WaitServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WaitServiceBlockingStub(channel, callOptions);
        }
      };
    return WaitServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WaitServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WaitServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WaitServiceFutureStub>() {
        @java.lang.Override
        public WaitServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WaitServiceFutureStub(channel, callOptions);
        }
      };
    return WaitServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WaitServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server sending messages to client with the remaining time
     * </pre>
     */
    public void streamWaitTime(time.Time.WaitTimeRequest request,
        io.grpc.stub.StreamObserver<time.Time.WaitTimeUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamWaitTimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamWaitTimeMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                time.Time.WaitTimeRequest,
                time.Time.WaitTimeUpdate>(
                  this, METHODID_STREAM_WAIT_TIME)))
          .build();
    }
  }

  /**
   */
  public static final class WaitServiceStub extends io.grpc.stub.AbstractAsyncStub<WaitServiceStub> {
    private WaitServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WaitServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WaitServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server sending messages to client with the remaining time
     * </pre>
     */
    public void streamWaitTime(time.Time.WaitTimeRequest request,
        io.grpc.stub.StreamObserver<time.Time.WaitTimeUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamWaitTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WaitServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WaitServiceBlockingStub> {
    private WaitServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WaitServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WaitServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server sending messages to client with the remaining time
     * </pre>
     */
    public java.util.Iterator<time.Time.WaitTimeUpdate> streamWaitTime(
        time.Time.WaitTimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamWaitTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WaitServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WaitServiceFutureStub> {
    private WaitServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WaitServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WaitServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_WAIT_TIME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WaitServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WaitServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_WAIT_TIME:
          serviceImpl.streamWaitTime((time.Time.WaitTimeRequest) request,
              (io.grpc.stub.StreamObserver<time.Time.WaitTimeUpdate>) responseObserver);
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

  private static abstract class WaitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WaitServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return time.Time.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WaitService");
    }
  }

  private static final class WaitServiceFileDescriptorSupplier
      extends WaitServiceBaseDescriptorSupplier {
    WaitServiceFileDescriptorSupplier() {}
  }

  private static final class WaitServiceMethodDescriptorSupplier
      extends WaitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WaitServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WaitServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WaitServiceFileDescriptorSupplier())
              .addMethod(getStreamWaitTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
