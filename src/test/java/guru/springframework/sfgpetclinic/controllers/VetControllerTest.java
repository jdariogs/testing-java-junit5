package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.fauxspring.ModelMapImp;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Tag("controller")
class VetControllerTest {

    private SpecialityMapService specialityMapService;
    private VetMapService vetMapService;
    private VetController controller;

    @BeforeEach
    void beforeAll(){
        specialityMapService = new SpecialityMapService();
        vetMapService = new VetMapService(specialityMapService);
        controller = new VetController(vetMapService);


        Vet vet1 = new Vet(1l, "Joe", "Duplantier", null);
        Vet vet2 = new Vet(2l, "Mac", "Kraby",null);
        vetMapService.save(vet1);
        vetMapService.save(vet2);

    }

    @Test
    void listVets() {
       Model model = new ModelMapImp();
       assertEquals("vets/index",controller.listVets(model));
       Set modelAttributes = (Set) ((ModelMapImp) model).getMap().get("vets");
       assertEquals(2,(modelAttributes.size()));
    }
}