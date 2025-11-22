package com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.requests;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloPostRequest;

public record HelloPostRequestDTO(
        String key,
        String value,
        String extraData
) {
    public HelloPostRequest toDomain() {
        return HelloPostRequest.builder()
                .key(this.key)
                .value(this.value)
                .extraData(this.extraData)
                .build();
    }
}
