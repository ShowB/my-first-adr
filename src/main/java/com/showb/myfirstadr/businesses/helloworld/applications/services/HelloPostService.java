package com.showb.myfirstadr.businesses.helloworld.applications.services;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloPostRequest;
import com.showb.myfirstadr.businesses.helloworld.ports.in.HelloPostUseCase;
import com.showb.myfirstadr.businesses.helloworld.ports.out.persistences.HelloPostPort;
import org.springframework.stereotype.Service;

@Service
public class HelloPostService implements HelloPostUseCase {
    private final HelloPostPort helloPostPort;


    public HelloPostService(HelloPostPort helloPostPort) {
        this.helloPostPort = helloPostPort;
    }

    @Override
    public void post(HelloPostRequest request) {
        helloPostPort.save(request);
    }

    @Override
    public HelloListResponse getAll() {
        return new HelloListResponse(helloPostPort.findAll());
    }
}
