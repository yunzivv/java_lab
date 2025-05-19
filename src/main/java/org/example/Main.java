package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // 로또 번호 추첨기
        System.out.println("100% Winning Lotto");

        Random random = new Random(); // 난수 발생
        int[] lotto = new int[6];
        int index = 0;

        while(index < 6) {
            boolean flag = false;
            int rand = random.nextInt(45) + 1;
            for(int i = 0; i < index; i++){
                if(lotto[i] == rand) flag = true;
            }
            if(flag)continue;
            lotto[index++] = rand;
        }

        for(int l : lotto) {
            System.out.print(l + " ");
        }
    }
}