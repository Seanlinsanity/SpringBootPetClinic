package seanlindev.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seanlindev.springframework.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
