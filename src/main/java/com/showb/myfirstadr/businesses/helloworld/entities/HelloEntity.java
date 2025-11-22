package com.showb.myfirstadr.businesses.helloworld.entities;

import com.showb.myfirstadr.businesses.helloworld.applications.domain.Hello;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloPostRequest;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "hello")
@Getter
@Builder
public class HelloEntity {
    @Id
    private final String id;

    private final String key;
    private final String value;
    private final String extraData;
    private final LocalDateTime createdAt;


    public HelloEntity(String id, String key, String value, String extraData, LocalDateTime createdAt) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.extraData = extraData;
        this.createdAt = createdAt;
    }

    public static HelloEntity from(HelloPostRequest from) {
        return HelloEntity.builder()
                .key(from.key())
                .value(from.value())
                .extraData(from.extraData())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Hello toDomain() {
        return Hello.builder()
                .id(this.id)
                .key(this.key)
                .value(this.value)
                .extraData(this.extraData)
                .build();
    }
}
