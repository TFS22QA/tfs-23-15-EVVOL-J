package person;

import person.models.Phone;
import person.models.Physical;
import person.models.appearance.Appearance;

public class Person {

    private final String id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final Physical phys;
    private final Appearance appearance;
    private final Phone phone;

    public Person(String id, String lastName, String firstName, String middleName,
                  Physical phys, Appearance appearance, Phone phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phys = phys;
        this.appearance = appearance;
        this.phone = phone;
    }

    @Override
    public final String toString() {
        return id + "\n" + lastName + "\n" + firstName + "\n" +
                middleName + "\n" + phys + "\n" + appearance + "\n" + phone;
    }
}
