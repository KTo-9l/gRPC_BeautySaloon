package org.sillysociety.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.sillysociety.*;

public class GrpcClientService {
    private final ManagedChannel channel;
    private final BeautySaloonServiceGrpc.BeautySaloonServiceBlockingStub stub;

    public GrpcClientService(String host, Integer port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        stub = BeautySaloonServiceGrpc.newBlockingStub(channel);
    }

    public StylistResponse getStylist(Integer id) {
        return stub.getStylistByID(StylistRequest.newBuilder().setId(id).build());
    }

    public ClientResponse getClient(Integer id) {
        return stub.getClientByID(ClientRequest.newBuilder().setId(id).build());
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown();
    }

    public Boolean isShutdown() {
        return channel.isShutdown();
    }
}
