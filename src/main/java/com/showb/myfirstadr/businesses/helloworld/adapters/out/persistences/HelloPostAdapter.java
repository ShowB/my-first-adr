package com.showb.myfirstadr.businesses.helloworld.adapters.out.persistences;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.Hello;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloPostRequest;
import com.showb.myfirstadr.businesses.helloworld.entities.HelloEntity;
import com.showb.myfirstadr.businesses.helloworld.ports.out.persistences.HelloPostPort;
import com.showb.myfirstadr.businesses.helloworld.repositories.HelloRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloPostAdapter implements HelloPostPort {
    private final HelloRepository helloRepository;


    public HelloPostAdapter(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public void save(HelloPostRequest request) {
        var entity = HelloEntity.from(request);
        this.helloRepository.save(entity);
    }

    @Override
    public List<Hello> findAll() {
        return helloRepository.findAll()
                .stream()
                .map(HelloEntity::toDomain)
                .toList();
    }
}
