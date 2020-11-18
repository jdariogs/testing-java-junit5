package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependantAssertionsTest(){

        Owner owner = new Owner(
                1l, "Joe", "Duplantier");
        owner.setCity("Saltillo");
        owner.setTelephone("8441003322");

        assertAll( "Person Properties",
                () -> assertAll("Person Properties",
                    () -> assertEquals("Joe", owner.getFirstName()),
                    () -> assertEquals("Duplantier", owner.getLastName())),
                () -> assertAll("Owner Properties",
                    () -> assertEquals("Saltillo", owner.getCity()),
                    () -> assertEquals("8441003322", owner.getTelephone()))

        );

    }

}