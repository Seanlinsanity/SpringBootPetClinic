package seanlindev.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import seanlindev.springframework.springpetclinic.model.Owner;
import seanlindev.springframework.springpetclinic.model.Vet;
import seanlindev.springframework.springpetclinic.services.OwnerService;
import seanlindev.springframework.springpetclinic.services.VetService;
import seanlindev.springframework.springpetclinic.services.map.OwnerServiceMap;
import seanlindev.springframework.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Stephen");
        owner1.setLastName("Curry");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Klay");
        owner2.setLastName("Thomphson");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Stephen");
        vet1.setLastName("Cat");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Klay");
        vet2.setLastName("Dog");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
