package Index;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Index_Impl extends IndexGrpc.IndexImplBase {

    private final List<Double> readings = new ArrayList<>();

    @Override
    public StreamObserver<NumberKmRequest> total(StreamObserver<AnalysisResponse> responseObserver) {
        return new StreamObserver<NumberKmRequest>() {
            @Override
            public void onNext(NumberKmRequest request) {
                readings.add(request.getKm());
            }

            @Override
            public void onError(Throwable t) {
                Logger.getLogger(Index_Impl.class.getName()).warning("Total failed with error " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                double sum = 0;
                AnalysisResponse response = AnalysisResponse.newBuilder().setTotal(String.valueOf(sum)).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<NumberKmRequest> usage(StreamObserver<AnalysisResponse> responseObserver) {
        return null;
    }
}
