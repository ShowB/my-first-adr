package com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.requests;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloCreateRequest;

public record HelloCreateRequestDTO(
        String key,
        String value,
        String extraData
) {
    public HelloCreateRequest toDomain() {
        return HelloCreateRequest.builder()
                .key(this.key)
                .value(this.value)
                .extraData(this.extraData)
                .build();
    }
}
