package space.unbound.callback.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;


import reactor.core.publisher.Flux;
import space.unbound.callback.entity.ResponseData;


public interface ResponseDataRepository extends ReactiveMongoRepository<ResponseData, String> {

   // @Tailable
   // Flux<ResponseData> findAllTFlux();
   @Tailable
   Flux<ResponseData> findBy();

}