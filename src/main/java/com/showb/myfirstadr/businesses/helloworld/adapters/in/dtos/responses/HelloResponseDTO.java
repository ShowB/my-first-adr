package com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.responses;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;
import lombok.Builder;

@Builder
public record HelloResponseDTO(
        String id,
        String key,
        String value,
        String extraData
) {
    public static HelloResponseDTO from(Hello from) {
        return HelloResponseDTO.builder()
                .id(from.id())
                .key(from.key())
                .value(from.value())
                .extraData(from.extraData())
                .build();
    }
}
