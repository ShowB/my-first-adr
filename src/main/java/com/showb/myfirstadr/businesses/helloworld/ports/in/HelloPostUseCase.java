package com.showb.myfirstadr.businesses.helloworld.ports.in;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloPostRequest;

public interface HelloPostUseCase {
    void post(HelloPostRequest request);
    HelloListResponse getAll();
}
