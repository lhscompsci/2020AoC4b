package com.wtxcompsci;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inf = new Scanner(new File(("input.dat")));


        ArrayList<Map<String, String>> pptList = new ArrayList<>();

        Map<String, String> m = new TreeMap<>();

        //       int counter = 0;

        while (inf.hasNextLine()) {
            String line = inf.nextLine();
            if (!line.equals("")) {
                Scanner parts = new Scanner(line);
                while (parts.hasNext()) {
                    Scanner part = new Scanner(parts.next());
                    part.useDelimiter(":");
                    m.put(part.next(), part.next());
                }
            } else {
                //               System.out.println("set "+ ++counter+": "+m);
                pptList.add(m);
                m = new TreeMap<>();
            }
        }

//        System.out.println();
//        System.out.println(pptList);
//        System.out.println();

        int ans = 0, ans2 = 0;

        for (Map<String, String> stringStringMap : pptList) {
//            System.out.println(stringStringMap);
            if (validate(stringStringMap))
                ans++;


        }

        //203 is too low
        //259 is too high


        System.out.println(ans);
//        System.out.println(ans2);

    }

    public static boolean validate(Map<String, String> m){
        int byr = Integer.parseInt(m.get("byr"));
        int iyr = Integer.parseInt(m.get("iyr"));
        int eyr = Integer.parseInt(m.get("eyr"));
        Set<String> ecl = new TreeSet<>(Arrays.asList(new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"}));
        int pid = m.get("pid").length();

        if(byr<1920 || byr>2002)
            return false;

        if(iyr<2010 || iyr>2020)
            return false;

        if (eyr<2020 || eyr>2030)
            return false;

        if(!ecl.contains(m.get("ecl")))
            return false;




        return true;
    }

}
