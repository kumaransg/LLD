package SystemDesign.JukeBox;

public class Person {
    private String name;
    private String Address;
    private Gender gender;

    public Person(String name, String address, Gender gender) {
        this.name = name;
        Address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
