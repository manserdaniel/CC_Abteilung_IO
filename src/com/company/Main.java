package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int counter = 0;
        Person[] persons = new Person[11];
        ArrayList<Abteilung> abteilungen = new ArrayList<>();


        File textFile = new File("C:\\Users\\daniel\\Desktop\\CodingCampus\\IO\\Abteilung _IO\\Abteilungen1.txt");

        try {
            FileReader fileReader = new FileReader(textFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] splitted = line.split(";");
                persons[counter]  = new Person(splitted[0]);
                abteilungen.add(new Abteilung(splitted[1], persons[counter]));
                if (splitted.length > 2) {
                    abteilungen.get(counter).setTempParent(splitted[2]);
                }
                counter++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < abteilungen.size(); i++) {

            if (abteilungen.get(i).getTempParent() != "") {
                for (int j = 0; j < abteilungen.size(); j++) {
                    if (abteilungen.get(j).getName().equals(abteilungen.get(i).getTempParent())) {
                        abteilungen.get(j).setUnterAbteilung(abteilungen.get(i));
                        break;
                    }
                }
            }
        }

        System.out.println(abteilungen.get(0).toString());
    }
}
