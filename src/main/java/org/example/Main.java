package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 숫자 맞히기 게임
        System.out.println("\nuess the number between 1 and 100");
        System.out.println("Enter a number");

        int random = new Random().nextInt(100) + 1; // 난수 발생
        Scanner sc = new Scanner(System.in);

        int count = 0;

        while(true) {
            int choice = sc.nextInt();
            count++;

            if(choice == random) {
                System.out.println("You win!");
                System.out.println("Count is " + count);
                break;
            }else if(choice > random) {
                System.out.println("Down");
            }else {
                System.out.println("Up");
            }
        }
    }
}