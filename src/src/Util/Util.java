package Util;

import java.util.Scanner;

public class Util {
    public static String getString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s 입력 >> ", msg);
        String value = scanner.nextLine();
        return value;
    }

    public static int getInteger(String msg, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s 입력 (%d ~ %d) >> ", msg, min, max);
            try {
                int value = scanner.nextInt();
                if (value < min || value > max) {
                    System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("알 수 없는 입력값 입니다. 다시 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("스레드 인터럽트 예외 발생");
        }
    }

    public static void printLoading(int millis) {
        System.out.print("로딩중");
        for (int i = 0; i < 3; i++) {
            delay(millis);
            System.out.print(".");
        }
        System.out.println();
    }

    public static int getRandInteger(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
