package seanlindev.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import seanlindev.springframework.springpetclinic.model.*;
import seanlindev.springframework.springpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Stephen");
        owner1.setLastName("Curry");
        owner1.setAddress("CA Road 123");
        owner1.setCity("Sanfransico");
        owner1.setTelephone("9120480147");

        Pet curryDog = new Pet();
        curryDog.setPetType(savedDogPetType);
        curryDog.setOwner(owner1);
        curryDog.setBirthDate(LocalDate.now());
        curryDog.setName("Steve");
        owner1.getPets().add(curryDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Klay");
        owner2.setLastName("Thomphson");
        owner2.setAddress("LA street 4901");
        owner2.setCity("Los Angels");
        owner2.setTelephone("1548711239");

        Pet klayCat = new Pet();
        klayCat.setPetType(savedCatPetType);
        klayCat.setOwner(owner2);
        klayCat.setBirthDate(LocalDate.now());
        klayCat.setName("Tcat");
        owner2.getPets().add(klayCat);

        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Visit catVisit = new Visit();
        catVisit.setPet(klayCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loaded Visits....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Stephen");
        vet1.setLastName("Vet");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Klay");
        vet2.setLastName("Vet");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
