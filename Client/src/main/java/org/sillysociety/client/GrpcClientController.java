package org.sillysociety.client;

import org.sillysociety.StylistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcClientController {
    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/stylist")
    public StylistResponse getStylist(@RequestBody Integer id) {
        return grpcClientService.getStylist(id);
    }
}
