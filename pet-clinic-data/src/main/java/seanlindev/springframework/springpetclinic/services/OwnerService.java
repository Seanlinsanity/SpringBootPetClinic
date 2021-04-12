package seanlindev.springframework.springpetclinic.services;

import seanlindev.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
