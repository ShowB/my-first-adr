package com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.requests;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloModifyRequest;

public record HelloModifyRequestDTO(
        String id,
        String key,
        String value,
        String extraData
) {
    public HelloModifyRequest toDomain() {
        return HelloModifyRequest.builder()
                .id(this.id)
                .key(this.key)
                .value(this.value)
                .extraData(this.extraData)
                .build();
    }
}
