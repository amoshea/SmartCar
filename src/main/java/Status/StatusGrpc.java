package Status;

import io.grpc.stub.ClientCalls;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: status.proto")
public class StatusGrpc {
    private StatusGrpc() {}

    public static final String SERVICE_NAME = "SmartCar.FilterStatusService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Status.FilterStatusRequest,
            Status.FilterStatusResponse> getStatusMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "SmartCar.FilterStatusService",
            requestType = Status.FilterStatusRequest.class,
            responseType = Status.FilterStatusResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<Status.FilterStatusRequest,
            Status.FilterStatusResponse> getStatusMethod() {
        io.grpc.MethodDescriptor<Status.FilterStatusRequest, Status.FilterStatusResponse> getStatusMethod;
        if ((getStatusMethod = StatusGrpc.getStatusMethod) == null) {
            synchronized (StatusGrpc.class) {
                if ((getStatusMethod = StatusGrpc.getStatusMethod) == null) {
                    StatusGrpc.getStatusMethod = getStatusMethod =
                            io.grpc.MethodDescriptor.<Status.FilterStatusRequest, Status.FilterStatusResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "SmartCar.FilterStatusService", "Status"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Status.FilterStatusRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Status.FilterStatusResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new StatusMethodDescriptorSupplier("Status"))
                                    .build();
                }
            }
        }
        return getStatusMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static StatusStub newStub(io.grpc.Channel channel) {
        return new StatusStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static StatusBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new StatusBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static StatusFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new StatusFutureStub(channel);
    }

    /**
     */
    public static abstract class StatusImplBase implements io.grpc.BindableService {

        /**
         */
        public void status(Status.FilterStatusRequest request,
                                  io.grpc.stub.StreamObserver<Status.FilterStatusResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getStatusMethod(), responseObserver);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getStatusMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            Status.FilterStatusRequest,
                                            Status.FilterStatusResponse>(
                                            this, METHODID_STATUS)))
                    .build();
        }
    }

    /**
     */
    public static final class StatusStub extends io.grpc.stub.AbstractStub<StatusStub> {
        private StatusStub(io.grpc.Channel channel) {
            super(channel);
        }

        private StatusStub(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected StatusStub build(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
            return new StatusStub(channel, callOptions);
        }

        /**
         */
        public void getHeartBeats(Status.FilterStatusRequest request,
                                  io.grpc.stub.StreamObserver<Status.FilterStatusResponse> responseObserver) {
            ClientCalls.asyncServerStreamingCall(
                    getChannel().newCall(getStatusMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class StatusBlockingStub extends io.grpc.stub.AbstractStub<StatusBlockingStub> {
        private StatusBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private StatusBlockingStub(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected StatusBlockingStub build(io.grpc.Channel channel,
                                                  io.grpc.CallOptions callOptions) {
            return new StatusBlockingStub(channel, callOptions);
        }

        /**
         */
        public java.util.Iterator<Status.FilterStatusResponse> getStatus(
                Status.FilterStatusRequest request) {
            return blockingServerStreamingCall(
                    getChannel(), getStatusMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class StatusFutureStub extends io.grpc.stub.AbstractStub<StatusFutureStub> {
        private StatusFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private StatusFutureStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected StatusFutureStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new StatusFutureStub(channel, callOptions);
        }
    }

    private static final int METHODID_STATUS = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final StatusImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(StatusImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_STATUS:
                    serviceImpl.status((Status.FilterStatusRequest) request,
                            (io.grpc.stub.StreamObserver<Status.FilterStatusResponse>) responseObserver);
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

    private static abstract class StatusBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        StatusBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Status.StatusImpl.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Status");
        }
    }

    private static final class StatusFileDescriptorSupplier
            extends StatusBaseDescriptorSupplier {
        StatusFileDescriptorSupplier() {}
    }

    private static final class StatusMethodDescriptorSupplier
            extends StatusBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        StatusMethodDescriptorSupplier(String methodName) {
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
            synchronized (StatusGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new StatusFileDescriptorSupplier())
                            .addMethod(getStatusMethod())
                            .build();
                }
            }
        }
        return result;
    }
}
