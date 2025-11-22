package com.showb.myfirstadr.businesses.helloworld.adapters.out.persistences;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;
import com.showb.myfirstadr.businesses.helloworld.entities.HelloEntity;
import com.showb.myfirstadr.businesses.helloworld.ports.out.persistences.HelloPort;
import com.showb.myfirstadr.businesses.helloworld.repositories.HelloRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HelloAdapter implements HelloPort {
    private final HelloRepository helloRepository;


    public HelloAdapter(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public void save(Hello hello) {
        var entity = HelloEntity.from(hello);
        this.helloRepository.save(entity);
    }

    @Override
    public List<Hello> findAll() {
        return helloRepository.findAll()
                .stream()
                .map(HelloEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Hello> findById(String id) {
        return helloRepository.findById(id)
                .map(HelloEntity::toDomain);
    }

    @Override
    public void delete(String id) {
        helloRepository.deleteById(id);
    }
}
