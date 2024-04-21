package org.sillysociety.client;


import net.devh.boot.grpc.client.inject.GrpcClient;
import org.sillysociety.BeautySaloonServiceGrpc.BeautySaloonServiceBlockingStub;
import org.sillysociety.StylistRequest;
import org.sillysociety.StylistResponse;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("Server")
    private BeautySaloonServiceBlockingStub stub;

    public StylistResponse getStylist(Integer id) {
        return stub.getStylistByID(StylistRequest.newBuilder().setId(id).build());
    }
}
