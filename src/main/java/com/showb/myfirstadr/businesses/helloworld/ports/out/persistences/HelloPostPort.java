package com.showb.myfirstadr.businesses.helloworld.ports.out.persistences;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.Hello;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloPostRequest;

import java.util.List;

public interface HelloPostPort {
    void save(HelloPostRequest request);
    List<Hello> findAll();
}
