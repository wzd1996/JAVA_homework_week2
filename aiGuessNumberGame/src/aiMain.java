import ai_support.Ai;

import java.util.Scanner;

public class aiMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean stopGame = false;
        System.out.println("=================== 猜 数 字 ===================");
        Ai ai = new Ai();
        ai.genNumber();
        while (!stopGame) {
            int guessNum = in.nextInt();
            if (guessNum == -1) {
                stopGame = true;
            } else {
                if (ai.needReset(guessNum)) {
                    ai.genNumber();
                }
            }
        }
        ai.printTotalConut();
    }
}