package com.kshuran.onerepeatnumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.ho.yaml.Yaml;

/**
 *
 * @author Кулацкий
 */
public class OneRepeatNumber {

    /**
     * @param args the command line arguments - file adress
     */
    public static void main(String[] args) {

        //args[0] = src/main/resources/Data.yml
        String fileAdress = args[0];

        //load numbers to "list" from file *.yml
        //load numbers without duplicate to "set"
        try {
            InputStream input = new FileInputStream(new File(fileAdress));
            List<Integer> list = (List<Integer>) Yaml.load(input);
            HashSet<Integer> set = new HashSet<>();
            set.addAll(list);
            int listSize = list.size();
            int setSize = set.size();

            int k = 0;
            int m = 0;

            //adding all numbers from "list"
            for (Integer list1 : list) {
                k += list1;
            }

            //adding all numbers from "set"
            Iterator iSet = set.iterator();
            while (iSet.hasNext()) {
                m += (int) iSet.next();
            }

            //find number without duplicate
            if ((setSize * 2 - listSize) == 1) {
                int number = 2 * m - k;
                System.out.println(number);
            } else {
                System.out.println("File hasn't only one number without duplicate.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e);
        }
    }

}
