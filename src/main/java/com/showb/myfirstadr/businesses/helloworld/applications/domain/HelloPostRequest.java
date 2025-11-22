package com.showb.myfirstadr.businesses.helloworld.applications.domain;

import lombok.Builder;

@Builder
public record HelloPostRequest(
        String key,
        String value,
        String extraData
) {}
