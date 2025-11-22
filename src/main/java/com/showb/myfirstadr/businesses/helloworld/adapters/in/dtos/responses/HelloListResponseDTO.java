package com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.responses;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public record HelloListResponseDTO(
        List<Hello> hellos
) {
    public static HelloListResponseDTO from(HelloListResponse from) {
        return from.hellos()
                .stream()
                .map(Hello::from)
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                HelloListResponseDTO::new
                        )
                );
    }

    @Builder
    public record Hello(
            String id,
            String key,
            String value,
            String extraData
    ) {
        public static Hello from(com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello from) {
            return Hello.builder()
                    .id(from.id())
                    .key(from.key())
                    .value(from.value())
                    .extraData(from.extraData())
                    .build();
        }
    }
}
