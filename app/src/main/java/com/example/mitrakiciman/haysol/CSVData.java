package com.example.mitrakiciman.haysol;

import com.example.mitrakiciman.haysol.Location;

import java.util.*;
import java.io.*;

public class CSVData {
    public static void getArea(Map<Integer, Location> l, File f) {
        Scanner in;
        try {
            in = new Scanner(f);
            in.nextLine();
            while (in.hasNextLine()) {
                String[] line = in.nextLine().split(",");
                if (!line[2].equals("")) {
                    if (l.containsKey(new Integer(Integer.parseInt(line[2])))) {
                        l.get(Integer.parseInt(line[2])).setArea(Double.parseDouble(line[8]));
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public static void getArea(Map<Integer, Location> l, String s) {
        String[] in = s.substring(s.indexOf("\n")+1).split("\n");
        for (String str : in) {
                String[] line = str.split(",");
                if (!line[2].equals("")) {
                    if (l.containsKey(new Integer(Integer.parseInt(line[2])))) {
                        l.get(Integer.parseInt(line[2])).setArea(Double.parseDouble(line[8]));
                    }
                }
            }
    }
}
