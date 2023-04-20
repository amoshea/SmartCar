package Track;


import io.grpc.stub.ClientCalls;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Smart Car for Track service definition
 * </pre>
 */

@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: track.proto")
public class TrackGrpc {

    private TrackGrpc() {}

    public static final String SERVICE_NAME = "SmartCar.TrackService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Track.TrackRequest,
            Track.TrackResponse> getTrackMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "track",
            requestType = Track.TrackRequest.class,
            responseType = Track.TrackResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Track.TrackRequest,
            Track.TrackResponse> getTrackMethod() {
        io.grpc.MethodDescriptor<Track.TrackRequest, Track.TrackResponse> getTrackMethod;
        if ((getTrackMethod = TrackGrpc.getTrackMethod) == null) {
            synchronized (TrackGrpc.class) {
                if ((getTrackMethod = TrackGrpc.getTrackMethod) == null) {
                    TrackGrpc.getTrackMethod = getTrackMethod =
                            io.grpc.MethodDescriptor.<Track.TrackRequest, Track.TrackResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "SmartCar.TrackService", "Track"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Track.TrackRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Track.TrackResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new TrackMethodDescriptorSupplier("track"))
                                    .build();
                }
            }
        }
        return getTrackMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static TrackStub newStub(io.grpc.Channel channel) {
        return new TrackStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static TrackBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new TrackBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static TrackFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new TrackFutureStub(channel);
    }

    /**
     * <pre>
     * Smart Car for Track service definition
     * </pre>
     */
    public static abstract class TrackImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *unary
         * </pre>
         */
        public void track(Track.TrackRequest request,
                                      io.grpc.stub.StreamObserver<Track.TrackResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getTrackMethod(), responseObserver);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getTrackMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Track.TrackRequest,
                                            Track.TrackResponse>(
                                            this, METHODID_TRACK)))
                    .build();
        }
    }

    /**
     * <pre>
     * Smart Car for Track service definition
     * </pre>
     */
    public static final class TrackStub extends io.grpc.stub.AbstractStub<TrackStub> {
        private TrackStub(io.grpc.Channel channel) {
            super(channel);
        }

        private TrackStub(io.grpc.Channel channel,
                             io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TrackStub build(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            return new TrackStub(channel, callOptions);
        }

        /**
         * <pre>
         *unary
         * </pre>
         */
        public void track(Track.TrackRequest request,
                                      io.grpc.stub.StreamObserver<Track.TrackResponse> responseObserver) {
            ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getTrackMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * <pre>
     * Smart Car for Track service definition
     * </pre>
     */
    public static final class TrackBlockingStub extends io.grpc.stub.AbstractStub<TrackBlockingStub> {
        private TrackBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private TrackBlockingStub(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TrackBlockingStub build(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            return new TrackBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         *unary
         * </pre>
         */
        public Track.TrackResponse track(Track.TrackRequest request) {
            return blockingUnaryCall(
                    getChannel(), getTrackMethod(), getCallOptions(), request);
        }
    }

    /**
     * <pre>
     * Smart Car for Track service definition
     * </pre>
     */
    public static final class TrackFutureStub extends io.grpc.stub.AbstractStub<TrackFutureStub> {
        private TrackFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private TrackFutureStub(io.grpc.Channel channel,
                                   io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TrackFutureStub build(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            return new TrackFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         *unary
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<Track.TrackResponse> track(
                Track.TrackRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getTrackMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_TRACK = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final TrackImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(TrackImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_TRACK:
                    serviceImpl.track((Track.TrackRequest) request,
                            (io.grpc.stub.StreamObserver<Track.TrackResponse>) responseObserver);
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

    private static abstract class TrackBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        TrackBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Track.TrackImpl.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Track");
        }
    }

    private static final class TrackFileDescriptorSupplier
            extends TrackBaseDescriptorSupplier {
        TrackFileDescriptorSupplier() {}
    }

    private static final class TrackMethodDescriptorSupplier
            extends TrackBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        TrackMethodDescriptorSupplier(String methodName) {
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
            synchronized (TrackGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new TrackFileDescriptorSupplier())
                            .addMethod(getTrackMethod())
                            .build();
                }
            }
        }
        return result;
    }
}
