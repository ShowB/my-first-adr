package com.showb.myfirstadr.businesses.helloworld.repositories;

import com.showb.myfirstadr.businesses.helloworld.entities.HelloEntity;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends MongoRepository<@NonNull HelloEntity, @NonNull String> {}
