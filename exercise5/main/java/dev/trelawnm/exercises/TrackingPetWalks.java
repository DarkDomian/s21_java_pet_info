package dev.trelawnm.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrackingPetWalks {
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
        
        final long startTime = System.nanoTime();

        Scanner sc = new Scanner(System.in);
        int n = readInteger(sc);

        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        List<Animal> petList = new ArrayList<>();

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

        Function<Animal, String> goingToWolk = animal -> {
            try {
                final double startToWolk = (double) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime) / 1000;
                final double afterWolk = startToWolk + animal.goToWalk();
                return animal.toString() + String.format(", start time = %.2f, end time = %.2f", startToWolk, afterWolk);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return animal.toString() + ", walk interrupted";
            }
        };

        // When the walk is finished, the program must print the following information to a line in the console: the pet's info, the start time of the walk, and the end time of the walk.
        System.out.println(
            petList.parallelStream()
                   .map(goingToWolk)
                   .collect(Collectors.joining("\n"))
        );
    }
}
