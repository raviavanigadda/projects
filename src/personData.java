import java.util.ArrayList;
import  java.util.List;

public class personData {

    static int age;
    static String name;

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        personData.age = age;
    }

    public static void setName(String name) {
        personData.name = name;
    }

    public static String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<personData> persons = new ArrayList<personData>();

        personData person = new personData();
        personData.setName("Teju");
        personData.setAge(20);
        persons.add(person);

        person = new personData();
        personData.setName("Ravi gadu");
        personData.setAge(24);
        persons.add(person);

for(int i=0;i<2;i++)
{

}
    }

}
