package qa.circus.tests.data;

import java.io.File;
import java.util.Locale;

import com.github.javafaker.Faker;

public class PracticeFormData {
    private final Faker fake = new Faker(new Locale("ru"));
    public final File image =new File("src/test/resources/kek.jpg");
    public final String imageName = image.getName();
    public final String firstName = fake.name().firstName();
    public final String lastName = fake.name().lastName();
    public final String email = fake.bothify("????##@????????.???",true);
    public final String gender = fake.options().option("Female", "Male", "Other");
    public final String phone = fake.numerify("##########");
    public final String day =  String.valueOf(fake.number().numberBetween(1,29));
    public final String month = fake.options().option("October", "September", "November");
    public final String year =  String.valueOf(fake.number().numberBetween(1900,2050));
    public final String subject = fake.options().option("Maths", "Arts", "Accounting", "Chemistry");
    public final String hobby = fake.options().option("Sports", "Reading", "Music");
    public final String address = fake.address().fullAddress();
    public final String state = "NCR";
    public final String city = fake.options().option("Delhi", "Gurgaon", "Noida");
    public final String[] assertTable = {
            String.join(" ", firstName, lastName),
            email, gender, phone,
            String.format("%s %s,%s", day.transform(n -> (n.length() == 1 ? "0" : "") + n), month, year),
            subject, hobby, "", address,
            String.join(" ", state, city)
    };
}
