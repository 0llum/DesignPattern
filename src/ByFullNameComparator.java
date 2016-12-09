import java.util.Comparator;

public class ByFullNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int i = o1.lastName.compareTo(o2.lastName);

        if (i != 0) {
            return i;
        }

        return o1.firstName.compareTo(o2.firstName);
    }
}
