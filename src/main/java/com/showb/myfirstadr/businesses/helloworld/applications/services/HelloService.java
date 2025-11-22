package com.showb.myfirstadr.businesses.helloworld.applications.services;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloCreateRequest;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloModifyRequest;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;
import com.showb.myfirstadr.businesses.helloworld.ports.in.HelloUseCase;
import com.showb.myfirstadr.businesses.helloworld.ports.out.persistences.HelloPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloService implements HelloUseCase {
    private final HelloPort helloPort;

    private static final String ERROR_MSG_NOT_FOUND_HELLO = "Hello not found";


    public HelloService(HelloPort helloPort) {
        this.helloPort = helloPort;
    }

    @Override
    @Transactional
    public void insert(HelloCreateRequest request) {
        Hello hello = request.toPrimary();
        helloPort.save(hello);
    }

    @Override
    @Transactional(readOnly = true)
    public HelloListResponse getAll() {
        return new HelloListResponse(helloPort.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Hello get(String id) {
        return helloPort.findById(id)
                .orElseThrow(() -> new RuntimeException(ERROR_MSG_NOT_FOUND_HELLO));
    }

    @Override
    @Transactional
    public void update(HelloModifyRequest request) {
        String id = request.id();
        Hello prevHello = helloPort.findById(id)
                .orElseThrow(() -> new RuntimeException(ERROR_MSG_NOT_FOUND_HELLO));

        Hello requestedHello = request.toPrimary();
        Hello newHello = prevHello.update(requestedHello);

        helloPort.save(newHello);
    }

    @Override
    @Transactional
    public void delete(String id) {
        helloPort.findById(id)
                .orElseThrow(() -> new RuntimeException(ERROR_MSG_NOT_FOUND_HELLO));

        helloPort.delete(id);
    }
}
