package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupAssertions(){
        //given
        Person person = new Person(1l,"Joe", "Duplantier");
        //then
        assertAll("Test Props set",
                    () -> assertEquals("Joe", person.getFirstName()),
                    () -> assertEquals("Duplantier", person.getLastName()));
    }

    @Test
    void groupAssertionsMessage(){
        //given
        Person person = new Person(1l, "Joe", "Duplantier");
        //then
        assertAll("Test Props set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Duplantier",person.getLastName(), "Last Name Failed"));
    }

}