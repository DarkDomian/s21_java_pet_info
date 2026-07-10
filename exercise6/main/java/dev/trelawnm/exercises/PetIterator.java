package dev.trelawnm.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class PetIterator {
    static int readInteger(Scanner sc) {
        while (true) {
            String str = sc.nextLine();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = readInteger(sc);

        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        List<Animal> petList = new ArrayList<>();
        AnimalIterator iter = new AnimalIterator(petList);

        for (int i = 0; i < n; i++){
            try {
                String type = sc.nextLine().trim().toLowerCase();

                petList.add(
                    switch (type) {
                        case "dog" -> Dog.builder()
                                            .setName(sc.nextLine())
                                            .setAge(Integer.parseInt(sc.nextLine()))
                                            .build();
                        case "cat" -> Cat.builder()
                                            .setName(sc.nextLine())
                                            .setAge(Integer.parseInt(sc.nextLine()))
                                            .build();
                        default -> throw new IllegalArgumentException("Incorrect input. Unsupported pet type");
                    }
                );
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }
}
