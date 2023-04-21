package Status;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import JmDNS.ServiceDiscovery;
import javax.jmdns.ServiceInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Status_client {

    private static StatusGrpc.StatusBlockingStub bStub;

    public static void main(String[] args) throws InterruptedException {

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_FilterStatusService._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // Port & Host
        int port = 50052;
        String host = "localhost";

        // Build a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // Create a new instance of Status Service
        Status_Impl statusService = new Status_Impl();

        // Call the server streaming method on the Status Service instance
        doServerStreamingCall(channel, statusService);

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Server Streaming Method
    private static void doServerStreamingCall(ManagedChannel channel, Status_Impl statusService) throws InterruptedException {
        int filterStatus = 1;
        System.out.println("Starting server streaming...");

        // Prepare the request
        FilterStatusRequest request = FilterStatusRequest.newBuilder()
                .setFilterStatus(filterStatus)
                .build();

        // Stream the responses
        CountDownLatch latch = new CountDownLatch(1);
        final boolean[] printStatus = {false};
        statusService.status(request, new StreamObserver<FilterStatusResponse>() {
            @Override
            public void onNext(FilterStatusResponse response) {
                // Print the  status response only once
                if (!printStatus[0]) {
                    System.out.println("Current filter status: " + response.getFilterStatusCurr() + " - The filter in good condition, within the period of use.");
                    printStatus[0] = true;
                }
            }

            @Override
            // Handle errors
            public void onError(Throwable t) {
                t.printStackTrace();
                System.out.println("RPC call was canceled");
                latch.countDown();
            }
            @Override
            // Complete the RPC
            public void onCompleted() {
                latch.countDown();
            }
        });
        latch.await();
    }
}
