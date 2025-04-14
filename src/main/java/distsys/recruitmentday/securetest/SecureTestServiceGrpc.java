package distsys.recruitmentday.securetest;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: securetest.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecureTestServiceGrpc {

  private SecureTestServiceGrpc() {}

  public static final String SERVICE_NAME = "securetest.SecureTestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<distsys.recruitmentday.securetest.SecureTestProto.Video,
      distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse> getMonitorTestSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorTestSession",
      requestType = distsys.recruitmentday.securetest.SecureTestProto.Video.class,
      responseType = distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.recruitmentday.securetest.SecureTestProto.Video,
      distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse> getMonitorTestSessionMethod() {
    io.grpc.MethodDescriptor<distsys.recruitmentday.securetest.SecureTestProto.Video, distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse> getMonitorTestSessionMethod;
    if ((getMonitorTestSessionMethod = SecureTestServiceGrpc.getMonitorTestSessionMethod) == null) {
      synchronized (SecureTestServiceGrpc.class) {
        if ((getMonitorTestSessionMethod = SecureTestServiceGrpc.getMonitorTestSessionMethod) == null) {
          SecureTestServiceGrpc.getMonitorTestSessionMethod = getMonitorTestSessionMethod =
              io.grpc.MethodDescriptor.<distsys.recruitmentday.securetest.SecureTestProto.Video, distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorTestSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.recruitmentday.securetest.SecureTestProto.Video.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecureTestServiceMethodDescriptorSupplier("MonitorTestSession"))
              .build();
        }
      }
    }
    return getMonitorTestSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.recruitmentday.securetest.SecureTestProto.TestAnswer,
      distsys.recruitmentday.securetest.SecureTestProto.TestResult> getSubmitTestAnswersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitTestAnswers",
      requestType = distsys.recruitmentday.securetest.SecureTestProto.TestAnswer.class,
      responseType = distsys.recruitmentday.securetest.SecureTestProto.TestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.recruitmentday.securetest.SecureTestProto.TestAnswer,
      distsys.recruitmentday.securetest.SecureTestProto.TestResult> getSubmitTestAnswersMethod() {
    io.grpc.MethodDescriptor<distsys.recruitmentday.securetest.SecureTestProto.TestAnswer, distsys.recruitmentday.securetest.SecureTestProto.TestResult> getSubmitTestAnswersMethod;
    if ((getSubmitTestAnswersMethod = SecureTestServiceGrpc.getSubmitTestAnswersMethod) == null) {
      synchronized (SecureTestServiceGrpc.class) {
        if ((getSubmitTestAnswersMethod = SecureTestServiceGrpc.getSubmitTestAnswersMethod) == null) {
          SecureTestServiceGrpc.getSubmitTestAnswersMethod = getSubmitTestAnswersMethod =
              io.grpc.MethodDescriptor.<distsys.recruitmentday.securetest.SecureTestProto.TestAnswer, distsys.recruitmentday.securetest.SecureTestProto.TestResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitTestAnswers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.recruitmentday.securetest.SecureTestProto.TestAnswer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.recruitmentday.securetest.SecureTestProto.TestResult.getDefaultInstance()))
              .setSchemaDescriptor(new SecureTestServiceMethodDescriptorSupplier("SubmitTestAnswers"))
              .build();
        }
      }
    }
    return getSubmitTestAnswersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecureTestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureTestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecureTestServiceStub>() {
        @java.lang.Override
        public SecureTestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecureTestServiceStub(channel, callOptions);
        }
      };
    return SecureTestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecureTestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureTestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecureTestServiceBlockingStub>() {
        @java.lang.Override
        public SecureTestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecureTestServiceBlockingStub(channel, callOptions);
        }
      };
    return SecureTestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecureTestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureTestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecureTestServiceFutureStub>() {
        @java.lang.Override
        public SecureTestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecureTestServiceFutureStub(channel, callOptions);
        }
      };
    return SecureTestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SecureTestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.Video> monitorTestSession(
        io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorTestSessionMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.TestAnswer> submitTestAnswers(
        io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.TestResult> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSubmitTestAnswersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorTestSessionMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                distsys.recruitmentday.securetest.SecureTestProto.Video,
                distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse>(
                  this, METHODID_MONITOR_TEST_SESSION)))
          .addMethod(
            getSubmitTestAnswersMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                distsys.recruitmentday.securetest.SecureTestProto.TestAnswer,
                distsys.recruitmentday.securetest.SecureTestProto.TestResult>(
                  this, METHODID_SUBMIT_TEST_ANSWERS)))
          .build();
    }
  }

  /**
   */
  public static final class SecureTestServiceStub extends io.grpc.stub.AbstractAsyncStub<SecureTestServiceStub> {
    private SecureTestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureTestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureTestServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.Video> monitorTestSession(
        io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorTestSessionMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.TestAnswer> submitTestAnswers(
        io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.TestResult> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSubmitTestAnswersMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SecureTestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SecureTestServiceBlockingStub> {
    private SecureTestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureTestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureTestServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class SecureTestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SecureTestServiceFutureStub> {
    private SecureTestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureTestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureTestServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MONITOR_TEST_SESSION = 0;
  private static final int METHODID_SUBMIT_TEST_ANSWERS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecureTestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecureTestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_TEST_SESSION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorTestSession(
              (io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.MonitoringResponse>) responseObserver);
        case METHODID_SUBMIT_TEST_ANSWERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.submitTestAnswers(
              (io.grpc.stub.StreamObserver<distsys.recruitmentday.securetest.SecureTestProto.TestResult>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SecureTestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecureTestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return distsys.recruitmentday.securetest.SecureTestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecureTestService");
    }
  }

  private static final class SecureTestServiceFileDescriptorSupplier
      extends SecureTestServiceBaseDescriptorSupplier {
    SecureTestServiceFileDescriptorSupplier() {}
  }

  private static final class SecureTestServiceMethodDescriptorSupplier
      extends SecureTestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecureTestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecureTestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecureTestServiceFileDescriptorSupplier())
              .addMethod(getMonitorTestSessionMethod())
              .addMethod(getSubmitTestAnswersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
