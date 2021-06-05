package seanlindev.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seanlindev.springframework.springpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
