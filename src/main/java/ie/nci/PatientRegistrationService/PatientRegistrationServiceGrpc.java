package ie.nci.PatientRegistrationService;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PatientRegistrationService.proto")
public final class PatientRegistrationServiceGrpc {

  private PatientRegistrationServiceGrpc() {}

  public static final String SERVICE_NAME = "PatientRegistrationService.PatientRegistrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.nci.PatientRegistrationService.PatientRequest,
      ie.nci.PatientRegistrationService.PatientResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = ie.nci.PatientRegistrationService.PatientRequest.class,
      responseType = ie.nci.PatientRegistrationService.PatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.nci.PatientRegistrationService.PatientRequest,
      ie.nci.PatientRegistrationService.PatientResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<ie.nci.PatientRegistrationService.PatientRequest, ie.nci.PatientRegistrationService.PatientResponse> getRegisterMethod;
    if ((getRegisterMethod = PatientRegistrationServiceGrpc.getRegisterMethod) == null) {
      synchronized (PatientRegistrationServiceGrpc.class) {
        if ((getRegisterMethod = PatientRegistrationServiceGrpc.getRegisterMethod) == null) {
          PatientRegistrationServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<ie.nci.PatientRegistrationService.PatientRequest, ie.nci.PatientRegistrationService.PatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PatientRegistrationService.PatientRegistrationService", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.PatientRegistrationService.PatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.PatientRegistrationService.PatientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientRegistrationServiceMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientRegistrationServiceStub newStub(io.grpc.Channel channel) {
    return new PatientRegistrationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientRegistrationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientRegistrationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientRegistrationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientRegistrationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PatientRegistrationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(ie.nci.PatientRegistrationService.PatientRequest request,
        io.grpc.stub.StreamObserver<ie.nci.PatientRegistrationService.PatientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.nci.PatientRegistrationService.PatientRequest,
                ie.nci.PatientRegistrationService.PatientResponse>(
                  this, METHODID_REGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class PatientRegistrationServiceStub extends io.grpc.stub.AbstractStub<PatientRegistrationServiceStub> {
    private PatientRegistrationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientRegistrationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientRegistrationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientRegistrationServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(ie.nci.PatientRegistrationService.PatientRequest request,
        io.grpc.stub.StreamObserver<ie.nci.PatientRegistrationService.PatientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PatientRegistrationServiceBlockingStub extends io.grpc.stub.AbstractStub<PatientRegistrationServiceBlockingStub> {
    private PatientRegistrationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientRegistrationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientRegistrationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientRegistrationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ie.nci.PatientRegistrationService.PatientResponse register(ie.nci.PatientRegistrationService.PatientRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PatientRegistrationServiceFutureStub extends io.grpc.stub.AbstractStub<PatientRegistrationServiceFutureStub> {
    private PatientRegistrationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientRegistrationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientRegistrationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientRegistrationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.nci.PatientRegistrationService.PatientResponse> register(
        ie.nci.PatientRegistrationService.PatientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientRegistrationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientRegistrationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((ie.nci.PatientRegistrationService.PatientRequest) request,
              (io.grpc.stub.StreamObserver<ie.nci.PatientRegistrationService.PatientResponse>) responseObserver);
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

  private static abstract class PatientRegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientRegistrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.nci.PatientRegistrationService.PatientRegistrationServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientRegistrationService");
    }
  }

  private static final class PatientRegistrationServiceFileDescriptorSupplier
      extends PatientRegistrationServiceBaseDescriptorSupplier {
    PatientRegistrationServiceFileDescriptorSupplier() {}
  }

  private static final class PatientRegistrationServiceMethodDescriptorSupplier
      extends PatientRegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientRegistrationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PatientRegistrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientRegistrationServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
