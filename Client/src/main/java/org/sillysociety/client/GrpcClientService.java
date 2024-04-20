package org.sillysociety.client;


import net.devh.boot.grpc.client.inject.GrpcClient;
import org.sillysociety.beautysaloon.BeautySaloonServiceGrpc.BeautySaloonServiceBlockingStub;
import org.sillysociety.beautysaloon.StylistRequest;
import org.sillysociety.beautysaloon.StylistResponse;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("Server")
    private BeautySaloonServiceBlockingStub stub;

    public StylistResponse getStylist(Integer id) {
        return stub.getStylistByID(StylistRequest.newBuilder().setId(id).build());
    }
}
