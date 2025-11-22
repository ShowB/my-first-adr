package com.showb.myfirstadr.businesses.helloworld.adapters.in.controllers;

import com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.requests.HelloCreateRequestDTO;
import com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.requests.HelloModifyRequestDTO;
import com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.responses.HelloListResponseDTO;
import com.showb.myfirstadr.businesses.helloworld.adapters.in.dtos.responses.HelloResponseDTO;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.HelloListResponse;
import com.showb.myfirstadr.businesses.helloworld.applications.domain.primary.Hello;
import com.showb.myfirstadr.businesses.helloworld.ports.in.HelloUseCase;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    private final HelloUseCase helloUseCase;


    public HelloWorldController(HelloUseCase helloUseCase) {
        this.helloUseCase = helloUseCase;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @PostMapping
    public ResponseEntity<@NonNull Void> post(HelloCreateRequestDTO request) {
        helloUseCase.insert(request.toDomain());

        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<@NonNull HelloListResponseDTO> getAll() {
        HelloListResponse response = helloUseCase.getAll();
        HelloListResponseDTO body = HelloListResponseDTO.from(response);

        return ResponseEntity.ok()
                .body(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull HelloResponseDTO> get(@PathVariable String id) {
        Hello response = helloUseCase.get(id);
        HelloResponseDTO body = HelloResponseDTO.from(response);

        return ResponseEntity.ok()
                .body(body);
    }

    @PutMapping
    public ResponseEntity<@NonNull Void> modify(HelloModifyRequestDTO request) {
        helloUseCase.update(request.toDomain());

        return ResponseEntity.noContent()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Void> delete(@PathVariable String id) {
        helloUseCase.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
