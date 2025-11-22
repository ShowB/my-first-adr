package com.showb.myfirstadr.businesses.helloworld.applications.domain;

import lombok.Builder;

@Builder
public record Hello(
        String id,
        String key,
        String value,
        String extraData
) {}
