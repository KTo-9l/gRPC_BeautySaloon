package org.sillysociety.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.sillysociety.*;
import org.sillysociety.models.Client;
import org.sillysociety.models.Stylist;
import org.sillysociety.service.ClientService;
import org.sillysociety.service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class BeautySaloonServiceImpl extends BeautySaloonServiceGrpc.BeautySaloonServiceImplBase {
    @Autowired
    private StylistService stylistService;
    @Autowired
    private ClientService clientService;

    @Override
    public void getStylistByID(StylistRequest request, StreamObserver<StylistResponse> responseObserver) {
        responseObserver.onNext(checkStylist(request));
        responseObserver.onCompleted();
    }
    private StylistResponse checkStylist(StylistRequest request) {
        Stylist stylist = stylistService.getById(request.getId());
        if ((stylist != null) && (!stylist.getDeleted())) {
            return StylistResponse.newBuilder()
                    .setId(stylist.getId())
                    .setName(stylist.getName())
                    .setIsDeleted(stylist.getDeleted())
                    .build();
        }
        return StylistResponse.newBuilder().setId(-1).setName("Stylist doesn't exist").setIsDeleted(true).build();
    }

    @Override
    public void getClientByID(ClientRequest request, StreamObserver<ClientResponse> responseObserver) {
        responseObserver.onNext(checkClient(request));
        responseObserver.onCompleted();
    }

    private ClientResponse checkClient(ClientRequest request) {
        // check client in DB
        Client client = clientService.getById(request.getId());
        if ((client != null) && (!client.getDeleted())) {
            Stylist stylist = client.getStylist();
            return ClientResponse.newBuilder()
                    .setId(client.getId())
                    .setName(client.getName())
                    .setStylist(StylistResponse.newBuilder()
                        .setId(stylist.getId())
                        .setName(stylist.getName())
                        .setIsDeleted(stylist.getDeleted())
                        .build())
                    .setIsDeleted(client.getDeleted())
                    .build();
        }
        return ClientResponse.newBuilder().setId(-1).setName("Client doesn't exist").setIsDeleted(true).build();
    }
}
