package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 야구 게임
        System.out.println("\nbaseball game");

        Random random = new Random(); // 난수 발생
        Scanner sc = new Scanner(System.in);
        int[] num_list = new int[5];
        int index = 0;

        while(index < 5) {
            boolean flag = false;
            int rand = random.nextInt(8) + 1;
            for(int i = 0; i < index; i++){
                if(num_list[i] == rand) flag = true;
            }
            if(flag)continue;
            num_list[index++] = rand;
        }
        System.out.println("공백으로 숫자를 구분해서 입력하세요");

        while(true){
            int strike = 0;
            int ball = 0;

            String answer = sc.nextLine();
            int[] answer_list = Arrays.stream(answer.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            if(answer_list.length != 5) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            for(int i = 0; i < 5; i++){
                if(answer_list[i] == num_list[i]) strike++;
                else if(answer.contains(Integer.toString(num_list[i]))) ball++;
            }

            System.out.println(strike + " strike " + ball + " ball\n");
            if(strike == 5){
                System.out.println("정답입니다.");
                for(int a : answer_list) System.out.print(a + " ");
                break;
            }
        }
    }
}