package space.unbound.callback.controller;

import java.time.Duration;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import space.unbound.callback.repository.*;
import space.unbound.callback.entity.ResponseData;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class ResponseDataController{

private final ResponseDataRepository repo;

public ResponseDataController(ResponseDataRepository repo){
    this.repo = repo;
}

//@GetMapping(value = "data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
@GetMapping(value = "data")
public Flux<ResponseData> all(){
    return repo.findAll();
}
/*
@GetMapping(value = "mda", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<ResponseData> getAll(){
    return repo.findBy();
} */

@GetMapping(value = "mda", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
public Flux<ResponseData> getAll(){
    return repo.findBy();
}



@GetMapping(value = "streaming", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
public Flux<Long> getItemsStream(){

    return Flux.interval(Duration.ofSeconds(1));
}

@PostMapping("data")
public Mono<ResponseData> create(@RequestBody ResponseData data){
    return repo.save(data);
}


}