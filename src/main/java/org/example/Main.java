package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 짝 맞히기 게임
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMatching Game");

        String[][] list = {{"J","I","D","O","A","L"},
                            {"C","I","R","K","K","C"},
                            {"G","H","Q","E","F","F"},
                            {"H","B","A","G","M","P"},
                            {"M","O","S","J","R","S"},
                            {"P","E","B","L","Q","D"}};

        String[][] list_index = {
                {"1", "2", "3", "4", "5", "6"},
                {"7", "8", "9", "10", "11", "12"},
                {"13", "14", "15", "16", "17", "18"},
                {"19", "20", "21", "22", "23", "24"},
                {"25", "26", "27", "28", "29", "30"},
                {"31", "32", "33", "34", "35", "36"}
        };

//        {17, 18}, {3, 36}, {4, 26}, {14, 19}, {16, 32}, {2, 8}, {1, 28},
//        {5, 21}, {35, 15}, {31, 24}, {6, 34}, {33, 20}, {25, 23},
//        {12, 7}, {9, 29}, {13, 22}, {27, 30}, {10, 11}

        for(int i = 0; i < list.length; i++){
            System.out.println("\n-------------------------------");
            System.out.print("|");
            for(int j = 0; j < list[i].length; j++){
                System.out.printf(" %2s |", list_index[i][j]);
            }

        }
        System.out.println("\n-------------------------------");
        System.out.println("\n좌표를 공백으로 구분하여 입력하세요");
        System.out.println("게임을 그만 두시려면 'out'을 입력하세요");
        int count = 0;

        while(true) {
            String first = "";
            String second = "";

            int firstX = 0;
            int firstY = 0;
            int secondX = 0;
            int secondY = 0;

            String[] answer = sc.nextLine().split(" ");
            if(answer[0].equals("out")){
                System.out.println("게임 종료");
                break;
            }
            if(answer.length != 2){
                System.out.println("좌표를 공백으로 구분하여 입력하세요");
                continue;
            }else if (answer[0].equals(answer[1])) {
                System.out.println("서로 다른 좌표를 입력하세요.");
                continue;
            }

            // 입력 받은 좌표의 문자열 비교
            for(int i = 0; i < list.length; i++){
                for(int j = 0; j < list[i].length; j++){
                    if(list_index[i][j].equals(answer[0])) {
                        first = list[i][j];
                        firstX = i;
                        firstY = j;
                    }
                    else if(list_index[i][j].equals(answer[1])) {
                        second = list[i][j];
                        secondX = i;
                        secondY = j;
                    }
                }
            }

            if (first.equals("") || second.equals("")) {
                System.out.println("유효하지 않은 좌표입니다.");
                continue;
            }

            System.out.println("first : " + first);
            System.out.println("second : " + second);

            try {
                Integer.parseInt(list_index[firstX][firstY]);
                Integer.parseInt(list_index[secondX][secondY]);
            } catch (NumberFormatException e) {
                System.out.println("이미 맞춘 칸입니다. 다른 좌표를 선택하세요.");
                continue;
            }

            if(first.equals(second)){
                count++;
                list_index[firstX][firstY] = list[firstX][firstY];
                list_index[secondX][secondY] = list[secondX][secondY];
            }

            for(int i = 0; i < list.length; i++){
                System.out.println("\n-------------------------------");
                System.out.print("|");
                for(int j = 0; j < list[i].length; j++){
                    System.out.printf(" %2s |", list_index[i][j]);
                }

            }
            System.out.println("\n-------------------------------");

            if(count == 18){
                System.out.println("Success!");
                break;
            }
        }
    }
}