package com.showb.myfirstadr.businesses.helloworld.adapters.in.controllers;

import com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.requests.HelloPostRequestDTO;
import com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.responses.HelloListResponseDTO;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import com.showb.myfirstadr.businesses.helloworld.ports.in.HelloPostUseCase;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    private final HelloPostUseCase helloPostUseCase;


    public HelloWorldController(HelloPostUseCase helloPostUseCase) {
        this.helloPostUseCase = helloPostUseCase;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @PostMapping
    public ResponseEntity<@NonNull Void> post(HelloPostRequestDTO request) {
        helloPostUseCase.post(request.toDomain());

        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<@NonNull HelloListResponseDTO> getAll() {
        HelloListResponse response = helloPostUseCase.getAll();
        HelloListResponseDTO body = HelloListResponseDTO.from(response);

        return ResponseEntity.ok()
                .body(body);
    }
}
