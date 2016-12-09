import java.util.Date;

public class Person implements Comparable<Person>{
    protected String firstName, lastName;
    protected Date birthDate;

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getBirthDate().getDate() + "." + getBirthDate().getMonth() + "." + getBirthDate().getYear();
    }

    @Override
    public int compareTo(final Person o) {
        return firstName.compareTo(o.firstName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!Person.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Person other = (Person) obj;

        if (!this.firstName.equals(other.getFirstName())) {
            return false;
        }

        if (!this.lastName.equals(other.getLastName())) {
            return false;
        }

        if (!this.birthDate.equals(other.getBirthDate())) {
            return false;
        }

        return true;
    }
}
