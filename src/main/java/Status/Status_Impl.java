package Status;

import io.grpc.stub.StreamObserver;

public class Status_Impl extends StatusGrpc.StatusImplBase {

    //Status Server Implementation
    // Defining a default status set point
    private static final double DEFAULT_STATUS = 1;

    @Override
    public void status(FilterStatusRequest request, StreamObserver<FilterStatusResponse> responseObserver) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                double status = getStatus();
                FilterStatusResponse response = FilterStatusResponse.newBuilder()
                        .setFilterStatusCurr(status)
                        .build();
                responseObserver.onNext(response);
                Thread.sleep(1000L); // Sleep for 1 second before sending next update
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    private double getStatus() {
        // Return the default status
        return DEFAULT_STATUS;
    }
}
