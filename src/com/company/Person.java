package com.company;

public class Person {

    // Variables
    private String name = "";

    private String abteilungString = "";
    private Abteilung abteilung;


    @Override
    public String toString() {
        return  name;
    }

    // --- Constructor
    public Person(String name) {
        this.name = name;
    }

    // Methode
    public void changeAbteilung(Abteilung newAbteilung) {
        for (int i = 0; i < abteilung.mitarbeiter.length; i++) {
            if (abteilung.mitarbeiter[i].equals(this)) {
                abteilung.mitarbeiter[i] = null;
                newAbteilung.setMitarbeiter(this);
                break;
            }
        }
    }

    // Getter & Setter
    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getAbteilung() {
        return abteilung.getName();
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }
}
