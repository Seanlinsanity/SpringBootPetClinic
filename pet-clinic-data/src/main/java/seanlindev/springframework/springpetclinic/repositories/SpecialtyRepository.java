package seanlindev.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seanlindev.springframework.springpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
