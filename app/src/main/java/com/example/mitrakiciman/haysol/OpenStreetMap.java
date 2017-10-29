package com.example.mitrakiciman.haysol;
import java.io.*;
import java.util.*;

public class OpenStreetMap {
    public static String getFile(File f) {
        String data = "";
        try {
            Scanner in = new Scanner(f);
            in.useDelimiter("\\Z");
            data = in.next();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return data;
    }

    public static HashSet<Location> getLocations(String txt) {
        HashSet<Location> buildings = new HashSet<>();
        int indexID = txt.indexOf("node id=");
        int indexLat;
        int indexLong;
        while(indexID != -1) {
            indexLat = txt.indexOf("lat=", indexID);
            indexLong = txt.indexOf("lon=", indexID);
            Location l = new Location();
            l.setID(Integer.parseInt(txt.substring(indexID+9, txt.indexOf(" ", indexID+10)-1)));
            l.setLatitude(Double.parseDouble(txt.substring(indexLat+5, txt.indexOf(" ", indexLat+7)-1)));
            l.setLongitude(Double.parseDouble(txt.substring(indexLong+5, txt.indexOf("\"", indexLong+7))));
            buildings.add(l);
            indexID = txt.indexOf("node id=", indexID+1);
        }
        return buildings;
    }

    public static void main(String[] args) {
        OpenStreetMap test = new OpenStreetMap();
        String data = test.getFile(new File("C:\\Users\\Mitra Kiciman\\Documents\\Solar Panel\\ID_Location.txt"));
        Set<Location> buildings = test.getLocations(data);
        Map<Integer, Location> ids = new HashMap<>();
        for (Location l : buildings) {
            // System.out.println(l);
            ids.put(l.getID(), l);
        }
        CSVData tester = new CSVData();
        tester.getArea(ids, new File("C:\\Users\\Mitra Kiciman\\Documents\\3504308\\Atlanta_01_Buildings.csv"));
        tester.getArea(ids, new File("C:\\Users\\Mitra Kiciman\\Documents\\3504308\\Atlanta_02_Buildings.csv"));
        tester.getArea(ids, new File("C:\\Users\\Mitra Kiciman\\Documents\\3504308\\Atlanta_03_Buildings.csv"));
        for (Integer i : ids.keySet()) {
            System.out.println(ids.get(i));
        }
    }
}
