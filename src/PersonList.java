import java.util.ArrayList;
import java.util.Date;

public class PersonList {
    public static ArrayList<Person> createList() {
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(new Person("Oliver", "Dolgener", new Date(1989, 9, 9)));
        personList.add(new Person("Lisa", "Dolgener", new Date(1989, 8, 12)));
        personList.add(new Person("Maren", "Frangenheim", new Date(1989, 8, 12)));
        personList.add(new Person("Robert", "Knipp", new Date(1990, 10, 12)));
        personList.add(new Person("Dustin", "Lorenz", new Date(1991, 9, 22)));
        personList.add(new Person("Robert", "Hoerster", new Date(1987, 12, 29)));
        personList.add(new Person("Saša", "Petrović", new Date(1989, 10, 16)));
        personList.add(new Person("Ute", "Dolgener", new Date(1958, 11, 16)));
        personList.add(new Person("Fiona", "Freund", new Date(1989, 10, 2)));
        personList.add(new Person("Saskia", "Schneider", new Date(1990, 2, 14)));
        personList.add(new Person("Nico", "Bernau", new Date(1988, 6, 2)));
        personList.add(new Person("Annemarie", "Kausche", new Date(1989, 3, 17)));

        return personList;
    }
}
