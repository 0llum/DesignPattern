import java.util.ArrayList;

public class Repository {
    ArrayList<Person> persons;

    public Repository() {
        persons = new ArrayList<>();
    }

    public Repository(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) throws PersonAlreadyExistsException{
        if (persons.contains(person)) {
            throw new PersonAlreadyExistsException();
        } else {
            persons.add(person);
        }
    }

    public void removePerson(Person person) throws PersonNotFoundException{
        if (!persons.contains(person)) {
            throw new PersonNotFoundException();
        } else {
            persons.remove(person);
        }
    }

    public void clearRepository() {
        persons.clear();
    }

    public void printPersons() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public ArrayList<Person> findPersonByFirstName(String firstName) throws PersonNotFoundException{
        ArrayList<Person> matches = new ArrayList<>();

        for (Person person : persons) {
            if (person.getFirstName().equals(firstName)) {
                matches.add(person);
            }
        }

        if (matches.size() == 0) {
            throw new PersonNotFoundException();
        }

        return matches;
    }

    public ArrayList<Person> findPersonByLastName(String lastName) throws PersonNotFoundException{
        ArrayList<Person> matches = new ArrayList<>();

        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) {
                matches.add(person);
            }
        }

        if (matches.size() == 0) {
            throw new PersonNotFoundException();
        }

        return matches;
    }
}
