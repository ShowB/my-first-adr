package com.showb.myfirstadr.businesses.helloworld.applications.domain;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;
import lombok.Builder;

@Builder
public record HelloModifyRequest(
        String id,
        String key,
        String value,
        String extraData
) {
    public Hello toPrimary() {
        return Hello.builder()
                .id(this.id)
                .key(this.key)
                .value(this.value)
                .extraData(this.extraData)
                .build();
    }
}
