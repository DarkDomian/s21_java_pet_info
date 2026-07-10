package dev.trelawnm.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

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
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < n; i++){
            try {
                String type = sc.nextLine().trim().toLowerCase();

                Animal pet = switch (type) {
                    case "dog" -> Dog.builder()
                                        .setName(sc.nextLine())
                                        .setAge(Integer.parseInt(sc.nextLine()))
                                        .build();
                    case "cat" -> Cat.builder()
                                        .setName(sc.nextLine())
                                        .setAge(Integer.parseInt(sc.nextLine()))
                                        .build();
                    default -> throw new IllegalArgumentException("Incorrect input. Unsupported pet type");
                };

                petList.add(pet);

                tasks.add(() -> {
                    try {
                        final double startToWolk = (double) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime) / 1000;
                        final double afterWolk = startToWolk + pet.goToWalk();
                        System.out.printf(
                            "%s, start time = %.2f, end time = %.2f\n",
                            pet,
                            startToWolk,
                            afterWolk
                        );
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(
                            pet.toString() + ", walk interrupted"
                        );
                    }
                });
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Runnable task : tasks) {
            executor.execute(task);
        }

        executor.shutdown();
    }
}
