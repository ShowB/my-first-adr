package com.showb.myfirstadr.businesses.helloworld.ports.in;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloCreateRequest;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloModifyRequest;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;

public interface HelloUseCase {
    void insert(HelloCreateRequest request);
    HelloListResponse getAll();
    Hello get(String id);
    void update(HelloModifyRequest request);
    void delete(String id);
}
