package com.company;

import javax.print.DocFlavor;

public class Abteilung {
    private String name;
    private Person leiter;
    private String tempParent = "";

    Abteilung[] unterAbteilung = new Abteilung[10];
    Person[] mitarbeiter = new Person[128];


    public Abteilung(String name, Person leiter) {
        this.name = name;
        this.leiter = leiter;
    }

    @Override
    public String toString() {
        return struktur("\t");
    }

    public String struktur(String myTabString) {
        myTabString = myTabString + "\t";
        String struktur = "";
        struktur = "Abteilung: " + this.name +
                "\t Leiter: " + this.leiter + '\n'
                + '\t' + myTabString + getMitarbeiter() + '\n';

        for (int i = 0; i <= this.unterAbteilung.length; i++) {
            if (this.unterAbteilung[i] == null) {
                return struktur;
            } else {
                struktur = struktur + '\n' + myTabString + " |" + '\t' + unterAbteilung[i].struktur(myTabString);
            }
        }
        return struktur;
    }

    public Person getLeiter() {
        return leiter;
    }

    public void setLeiter(Person leiter) {
        this.leiter = leiter;
    }

    public String getMitarbeiter() {
        String mitarbeiter = "";
        for (int i = 0; i < this.mitarbeiter.length; i++) {
            if (this.mitarbeiter[i] != null) {
                mitarbeiter = "Mitarbeiter " + this.name + ":\t";
                mitarbeiter = mitarbeiter + this.mitarbeiter[i];
            }
        }
        return mitarbeiter;
    }

    public void setMitarbeiter(Person mitarbeiter) {
        mitarbeiter.setAbteilung(this);
        for (int i = 0; i < this.mitarbeiter.length; i++) {
            if (this.mitarbeiter[i] == null) {
                this.mitarbeiter[i] = mitarbeiter;
                break;
            }
        }

    }

    public String getUnterAbteilung() {
        String unterAbteilung = "";
        for (int i = 0; i < this.unterAbteilung.length; i++) {
            if (this.unterAbteilung != null) {
                unterAbteilung = unterAbteilung + this.unterAbteilung[i];
                break;
            }
        }
        return unterAbteilung;
    }

    public void setUnterAbteilung(Abteilung unterAbteilung) {
        for (int i = 0; i < this.unterAbteilung.length; i++) {
            if (this.unterAbteilung[i] == null) {
                this.unterAbteilung[i] = unterAbteilung;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getTempParent() {
        return tempParent;
    }

    public void setTempParent(String tempParent) {
        this.tempParent = tempParent;
    }
}
