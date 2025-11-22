package com.showb.myfirstadr.businesses.helloworld.ports.out.persistences;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;

import java.util.List;
import java.util.Optional;

public interface HelloPort {
    void save(Hello request);
    List<Hello> findAll();
    Optional<Hello> findById(String id);
    void delete(String id);
}
