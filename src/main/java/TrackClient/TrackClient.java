package TrackClient;

import JmDNS.ServiceDiscovery;
import Track.TrackGrpc;
import Track.TrackGrpc.TrackBlockingStub;
import Track.TrackRequest;
import Track.TrackResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

        // build a channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host , port)
                .usePlaintext()
                .build();

        // stub
        bStub = TrackGrpc.newBlockingStub(channel);

        TrackRequest request = TrackRequest.newBuilder().build();
        TrackResponse Response = bStub.track(request);
        JOptionPane.showMessageDialog(null,Response.getTrackingStatus());

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
