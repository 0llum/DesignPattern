import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Date;

public class RepositoryTest {
    private Repository repository;
    private static Person person1, person2, person3, person4;

    @BeforeClass
    public static void setup() {
        person1 = new Person("Max", "Mustermann", new Date(1989, 1, 1));
        person2 = new Person("Jemand", "Anderes", new Date(1990, 2, 2));
        person3 = new Person("Jemand", "Ganzanderes", new Date(1988, 3, 3));
        person4 = new Person("Ganzjemand", "Anderes", new Date(1987, 4, 4));
    }

    @Before
    public void prepare() {
        repository = new Repository();
    }

    @Test
    public void shouldReturnEmptyArrayList() {
        ArrayList<Person> persons = repository.getPersons();
        assertThat(persons.size(), equalTo(0));
    }

    @Test
    public void shouldAddPerson() {
        repository.addPerson(person1);
        ArrayList<Person> persons = repository.getPersons();
        assertThat(persons.size(), equalTo(1));
        assertThat(persons.get(0), equalTo(person1));
    }

    @Test(expected = PersonAlreadyExistsException.class)
    public void shouldNotAddDuplicates() {
        repository.addPerson(person1);
        repository.addPerson(person1);
    }

    @Test
    public void shouldRemovePersonThatExists() {
        repository.addPerson(person1);
        repository.removePerson(person1);
        ArrayList<Person> persons = repository.getPersons();
        assertThat(persons.size(), equalTo(0));
    }

    @Test(expected = PersonNotFoundException.class)
    public void shouldNotRemovePersonThatNotExists() {
        repository.addPerson(person1);
        repository.removePerson(person2);
    }

    @Test
    public void shouldFindPersonByFirstNameThatExists() {
        repository.addPerson(person1);
        repository.addPerson(person2);
        ArrayList<Person> persons = repository.findPersonByFirstName("Jemand");
        assertThat(persons.size(), equalTo(1));
        assertThat(persons.get(0), equalTo(person2));
    }

    @Test
    public void shouldFindPersonsByFirstNameThatExist() {
        repository.addPerson(person1);
        repository.addPerson(person2);
        repository.addPerson(person3);
        ArrayList<Person> persons = repository.findPersonByFirstName("Jemand");
        assertThat(persons.size(), equalTo(2));
        assertThat(persons.get(0), equalTo(person2));
        assertThat(persons.get(1), equalTo(person3));
    }

    @Test(expected = PersonNotFoundException.class)
    public void shouldNotFindPersonByFirstNameThatNotExists() {
        repository.addPerson(person1);
        repository.addPerson(person2);
        repository.findPersonByFirstName("Irgend");
    }

    @Test
    public void shouldFindPersonByLastNameThatExists() {
        repository.addPerson(person1);
        repository.addPerson(person2);
        ArrayList<Person> persons = repository.findPersonByLastName("Anderes");
        assertThat(persons.size(), equalTo(1));
        assertThat(persons.get(0), equalTo(person2));
    }

    @Test
    public void shouldFindPersonsByLastNameThatExist() {
        repository.addPerson(person1);
        repository.addPerson(person2);
        repository.addPerson(person4);
        ArrayList<Person> persons = repository.findPersonByLastName("Anderes");
        assertThat(persons.size(), equalTo(2));
        assertThat(persons.get(0), equalTo(person2));
        assertThat(persons.get(1), equalTo(person4));
    }

    @Test(expected = PersonNotFoundException.class)
    public void shouldNotFindPersonByLastNameThatNotExists() {
        repository.addPerson(person1);
        repository.addPerson(person2);
        repository.findPersonByLastName("Ganz");
    }
}
