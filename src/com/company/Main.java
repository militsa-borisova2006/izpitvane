package com.company;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        File file_chetene = new File("test_data.txt");

        Scanner input = null;

        Map<Apartment, Integer> evtiniApartamenti = new HashMap<>();
        Map<String, Integer> brouachNaGradove = new HashMap<>();

        Set<String> podhodqshtiGradove = new HashSet<>();

        podhodqshtiGradove.add("София");
        podhodqshtiGradove.add("Варна");
        podhodqshtiGradove.add("Бургас");

        int broiNaApartamenti = 0;

        try {
            input = new Scanner(file_chetene);

            while (input.hasNext()) {

                String city = input.next();
                int rooms = input.nextInt();
                int kvadratura = input.nextInt();
                int cena = input.nextInt();
                int telefon = input.nextInt();

                Apartment apart = new Apartment(city, rooms, kvadratura, cena, telefon);

                if (kvadratura > 100 && rooms == 3 && podhodqshtiGradove.contains(city)) {
                    broiNaApartamenti++;
                }
                else continue;
                if (brouachNaGradove.containsKey(city)) {
                    brouachNaGradove.put(city, brouachNaGradove.get(city) + 1);
                }
                else {
                    brouachNaGradove.put(city, 1);
                }
                evtiniApartamenti.put(apart,  cena);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            assert input != null;
            input.close();
        }
        try {
            if (broiNaApartamenti == 0) {
                throw new  UnsuitableApartmentsException("No home for you :(");
            }
        }
        catch ( UnsuitableApartmentsException a) {
            System.out.println(a.getMessage());
        }
        List<Map.Entry<Apartment, Integer>> sortiraniEvtiniApartamenti = new ArrayList<>(evtiniApartamenti.entrySet());
        sortiraniEvtiniApartamenti.sort(Map.Entry.comparingByValue());

        List<Map.Entry<String, Integer>> sortiranMap = new ArrayList<>(brouachNaGradove.entrySet());
        sortiranMap.sort(Map.Entry.comparingByValue());

        File file_pisane = new File("output_data.txt");

        if (file_pisane.exists()) {
            System.out.println("There is file awlready :)");
            System.exit(1);
        }

        PrintWriter output = null;

        try {
            output = new PrintWriter(file_pisane);

            int i = 0;

            for (Map.Entry<Apartment, Integer> entry : sortiraniEvtiniApartamenti) {
                if (i == 5) break;
                i++;
                output.println(entry.getKey().getTelefon());
            }
            output.println();

            i = 0;

            for (Map.Entry<String, Integer> entry : sortiranMap) {
                if (i == 3) ;
                i++;
                output.println(entry.getKey() + " " + entry.getValue());
            }
            output.println();
        }
        catch (FileNotFoundException c) {
            System.out.println(c.getMessage());
        }
        finally {
            assert input != null;
            output.close();
        }
    }
}
