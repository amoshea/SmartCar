package TrackClient;

import JmDNS.ServiceDiscovery;
import Track.TrackGrpc;
import Track.TrackGrpc.TrackBlockingStub;
import Track.TrackRequest;
import Track.TrackResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TrackClient {
    private static TrackBlockingStub bStub;

    public static void main(String[] args) throws InterruptedException {
        //files based on class's files

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_Tracker._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // port & host
        int port = 8080;
        String host = "localhost";

        // Build a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // Stub
        bStub = TrackGrpc.newBlockingStub(channel);

        try {
            // Set a deadline of 10 seconds for the RPC call
            TrackResponse response = bStub.withDeadlineAfter(10, TimeUnit.SECONDS)
                    .track(TrackRequest.getDefaultInstance());
            // Print the response
            JOptionPane.showMessageDialog(null, response.getTrackingStatus());
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()) {
                // Handling of Deadline Exceeded errors:
                System.out.println("RPC call timed out");
            } else {
                // Handling of other errors:
                System.out.println("Error: " + e.getStatus());
            }
        }

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
