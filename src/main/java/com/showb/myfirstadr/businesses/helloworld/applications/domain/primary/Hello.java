package com.showb.myfirstadr.businesses.helloworld.applications.domain.primary;

import lombok.Builder;

@Builder(toBuilder = true)
public record Hello(
        String id,
        String key,
        String value,
        String extraData
) {
    public Hello update(Hello newHello) {
        return this.toBuilder()
                .key(newHello.key())
                .value(newHello.value())
                .extraData(newHello.extraData())
                .build();
    }
}
