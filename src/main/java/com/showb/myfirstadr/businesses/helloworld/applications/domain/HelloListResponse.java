package com.showb.myfirstadr.businesses.helloworld.applications.domain;

import java.util.List;

public record HelloListResponse(
        List<Hello> hellos
) {}
