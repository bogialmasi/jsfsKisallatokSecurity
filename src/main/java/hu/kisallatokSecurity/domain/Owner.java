package hu.kisallatokSecurity.domain;


public class Owner {
    private int id;
    private String name;
    private String address;
    public Owner() {
    }

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
