package Index;

import Index.IndexGrpc.IndexStub;
import JmDNS.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javax.jmdns.ServiceInfo;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Index_client {

    public static void main(String[] args) throws InterruptedException {
        //files based on class's files

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_IndexPollution._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // port & host
        int port = 50052;
        String host = "localhost";

        // build a channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host , port)
                .usePlaintext()
                .build();


        doBidirectionalCall(channel);

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }



    //Bidirectional
    public static void doBidirectionalCall(ManagedChannel channel) {
        System.out.println("Starting bidirectional streaming...");
        IndexStub stub = IndexGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<NumberKmRequest> requestObserver =
                stub.index(new StreamObserver<AnalysisResponse>() {
                    @Override
                    public void onNext(AnalysisResponse response) {
                        System.out.println("Response from server: "+response);
                    }

                    @Override
                    // Handle errors
                    public void onError(Throwable t) {
                        System.out.println("RPC call was canceled");
                    }
                    @Override
                    public void onCompleted() {
                        latch.countDown();
                    }
                });
        double total = 0;
        for (int i=0; i<5; i++)//Define analysis for 5 sending mileage
        {
            int number = createRandomNumber(10, 500);//Setting random mileage

            System.out.println("Sending Mileage "+number+"km to server...");
            total += number;
            requestObserver.onNext(NumberKmRequest.newBuilder()
                    .setKm(number).build());
        }
        System.out.println("Total Pollution Index: " + String.format("%.2f", total) + "%");
        requestObserver.onCompleted();
        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.shutdownNow();
    }

    public static int createRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max+1)+min;
        return number;
    }
}
