import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day1 {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

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
            System.out.println(num1 + " " + num2 + " " + distance);
            total += Math.abs(num1 - num2);
        }
        return total;
    }

    // private Hashtable<Integer, Integer> condenseNumCount(List<Integer> list) {
    //     Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
    //     List<Integer> tmp = new ArrayList<>();
    //     for (int num : list) {

    //     list1 = new ArrayList<>();

    // }
    // private int similarityScore() {
    //     int totalScore = 0;
    //     int idx2 = 0;
    //     for (int idx1=0; idx1 < list1.size() && idx2 < list2.size(); idx1++) {
    //         if (list1[])
    //     }

    //     return totalScore;
    // }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        // day1.readPairsFromFile("pairs.txt");
        day1.readPairsFromFile("small.txt");

        System.out.println("total distance is "+ day1.totalDistance());
    }

}
