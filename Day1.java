import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day1 {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    Hashtable<Integer, Integer> hash2 = new Hashtable<Integer, Integer>();

    public Day1() {
    }

    private void readPairsFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split("   "); // Assuming space as delimiter

                if (numbers.length == 2) {
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    list1.add(num1);
                    list2.add(num2);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        Collections.sort(list1);
        Collections.sort(list2);
        // Print the pairs
        // for (int num1 : list1) {
        //     System.out.println(num1);
        // }
        // for (int num2 : list2) {
        //     System.out.println(num2);
        // }
    }

    private int totalDistance() {
        int total = 0;
        for (int idx=0; idx < list1.size(); idx++) {
            int num1 = list1.get(idx);
            int num2 = list2.get(idx);
            int distance = Math.abs(num1 - num2);
            // System.out.println(num1 + " " + num2 + " " + distance);
            total += Math.abs(num1 - num2);
        }
        return total;
    }

    private void condenseList2() {
        for (int num : list2) {
            Integer count = hash2.get(num);
            if (count == null) {
                hash2.put(num, 1);
            }
            else {
                hash2.put(num, count + 1);
            }
        }

    }

    private int similarityScore() {
        condenseList2();
    
        int totalScore = 0;

        for (int num : list1) {
            Integer count = hash2.get(num);
            if (count != null) {
                totalScore += num * count;
            }
        }

        return totalScore;
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.readPairsFromFile("pairs.txt");
        // day1.readPairsFromFile("small.txt");

        System.out.println("total distance is "+ day1.totalDistance());
        System.out.println("total similarity score is "+ day1.similarityScore());
    }

}
