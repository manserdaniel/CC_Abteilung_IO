package com.company;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        int counter = 0;
        Person[] persons = new Person[11];
        Abteilung[] abteilungen = new Abteilung[11];


        File textFile = new File("C:\\Users\\daniel\\Desktop\\CodingCampus\\Objekte\\Abteilung\\Abteilungen.txt");
        try {
            FileReader fileReader = new FileReader(textFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitted = line.split(";");
                persons[counter]  = new Person(splitted[0]);

                for (int i = 0; i < abteilungen.length; i++) {
                    if (abteilungen[i] != null) {
                        if (abteilungen[i].getName() == splitted[1]) {
                            break;
                        }
                    } else {
                        abteilungen[i] = new Abteilung(splitted[1], persons[counter]);
                        break;
                    }
                }
                counter++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < abteilungen.length; i++) {

            System.out.println(abteilungen[i]);
        }

    }
}
