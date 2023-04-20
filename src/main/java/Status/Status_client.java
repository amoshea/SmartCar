package Status;

import JmDNS.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.jmdns.ServiceInfo;
import java.util.concurrent.TimeUnit;

public class Status_client {

    public static void main(String[] args) throws InterruptedException {
        //files based on class's files

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_FilterStatusService._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // port & host
        int port = 8089;
        String host = "localhost";

        // build a channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host , port)
                .usePlaintext()
                .build();


        doServerStreamingCall(channel);

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }



    //Server Streaming method

    private static void doServerStreamingCall(ManagedChannel channel)
    {
        String filterStatus = "The filter in good condition, within the period of use.";
        System.out.println("Starting server streaming...");
        System.out.println("Status of the filter: "+ filterStatus);
        StatusGrpc.StatusBlockingStub stub = StatusGrpc.newBlockingStub(channel);
        //preparing the request
        FilterStatusRequest request = FilterStatusRequest.newBuilder()
                .setFilterStatus(Integer.parseInt(filterStatus))
                .build();
        //streaming the responses
        stub.getStatus(request).forEachRemaining(response -> {

            //print for each response
            System.out.println("Response from server: "+response);
        });
    }
}
