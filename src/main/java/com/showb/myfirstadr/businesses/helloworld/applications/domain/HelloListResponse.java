package com.showb.myfirstadr.businesses.helloworld.applications.domain;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;

import java.util.List;

public record HelloListResponse(
        List<Hello> hellos
) {}
