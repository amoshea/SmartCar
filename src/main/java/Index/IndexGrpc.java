package Index;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: index.proto")
public class IndexGrpc {

    private IndexGrpc() {}

    public static final String SERVICE_NAME = "wearGRPC.IndexPollution";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Index.NumberKmRequest,
            Index.AnalysisResponse> getIndexMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Index",
            requestType = Index.NumberKmRequest.class,
            responseType = Index.AnalysisResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
    public static io.grpc.MethodDescriptor<Index.NumberKmRequest,
            Index.AnalysisResponse> getIndexMethod() {
        io.grpc.MethodDescriptor<Index.NumberKmRequest, Index.AnalysisResponse> getIndexMethod;
        if ((getIndexMethod = IndexGrpc.getIndexMethod) == null) {
            synchronized (IndexGrpc.class) {
                if ((getIndexMethod = IndexGrpc.getIndexMethod) == null) {
                    IndexGrpc.getIndexMethod = getIndexMethod =
                            io.grpc.MethodDescriptor.<Index.NumberKmRequest, Index.AnalysisResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "wearGRPC.IndexPollution", "Index"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Index.NumberKmRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Index.AnalysisResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new IndexMethodDescriptorSupplier("Index"))
                                    .build();
                }
            }
        }
        return getIndexMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static IndexStub newStub(io.grpc.Channel channel) {
        return new IndexStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static IndexBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new IndexBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static IndexFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new IndexFutureStub(channel);
    }

    /**
     */
    public static abstract class IndexImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *Bi-directional Streaming
         * </pre>
         */
        public io.grpc.stub.StreamObserver<Index.NumberKmRequest> index(
                io.grpc.stub.StreamObserver<Index.AnalysisResponse> responseObserver) {
            return asyncUnimplementedStreamingCall(getIndexMethod(), responseObserver);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getIndexMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            Index.NumberKmRequest,
                                            Index.AnalysisResponse>(
                                            this, METHODID_INDEX)))
                    .build();
        }

        public abstract StreamObserver<NumberKmRequest> total(StreamObserver<AnalysisResponse> responseObserver);

        public abstract StreamObserver<NumberKmRequest> usage(StreamObserver<AnalysisResponse> responseObserver);
    }

    /**
     */
    public static final class IndexStub extends io.grpc.stub.AbstractStub<IndexStub> {
        private IndexStub(io.grpc.Channel channel) {
            super(channel);
        }

        private IndexStub(io.grpc.Channel channel,
                                io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IndexStub build(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            return new IndexStub(channel, callOptions);
        }

        /**
         * <pre>
         *Bi-directional Streaming
        * </pre>
         */
        public io.grpc.stub.StreamObserver<Index.NumberKmRequest> index(
                io.grpc.stub.StreamObserver<Index.AnalysisResponse> responseObserver) {
            return asyncBidiStreamingCall(
                    getChannel().newCall(getIndexMethod(), getCallOptions()), responseObserver);
        }
    }

    /**
     */
    public static final class IndexBlockingStub extends io.grpc.stub.AbstractStub<IndexBlockingStub> {
        private IndexBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private IndexBlockingStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IndexBlockingStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new IndexBlockingStub(channel, callOptions);
        }

        public AnalysisResponse index(NumberKmRequest request) {
            return null;
        }
    }

    /**
     */
    public static final class IndexFutureStub extends io.grpc.stub.AbstractStub<IndexFutureStub> {
        private IndexFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private IndexFutureStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IndexFutureStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new IndexFutureStub(channel, callOptions);
        }
    }

    private static final int METHODID_INDEX = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final IndexImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(IndexImplBase serviceImpl, int methodId) {
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
                case METHODID_INDEX:
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.index(
                            (io.grpc.stub.StreamObserver<Index.AnalysisResponse>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class IndexBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        IndexBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Index.IndexImpl.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("IndexPollution");
        }
    }

    private static final class IndexFileDescriptorSupplier
            extends IndexBaseDescriptorSupplier {
        IndexFileDescriptorSupplier() {}
    }

    private static final class IndexMethodDescriptorSupplier
            extends IndexBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        IndexMethodDescriptorSupplier(String methodName) {
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
            synchronized (IndexGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new IndexFileDescriptorSupplier())
                            .addMethod(getIndexMethod())
                            .build();
                }
            }
        }
        return result;
    }
}
