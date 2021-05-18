package seanlindev.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seanlindev.springframework.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
