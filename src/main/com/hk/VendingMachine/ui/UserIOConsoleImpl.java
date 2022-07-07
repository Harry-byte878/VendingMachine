package main.com.hk.VendingMachine.ui;


import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String string = input.next();
        return string;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int num = input.nextInt();
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int Num = input.nextInt();
        while(Num < min || Num > max) {
            System.out.println(prompt);
            Num = input.nextInt();
        }
        return Num;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double d = input.nextDouble();
        return d;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double D = input.nextDouble();
        while (D < min || D > max){
            System.out.println(prompt);
            D = input.nextDouble();
        }
        return D;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float f = input.nextFloat();
        return f;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float F = input.nextFloat();
        while (F < min || F > max){
            System.out.println(prompt);
            F = input.nextFloat();
        }
        return F;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long l = input.nextLong();
        return l;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long L = input.nextLong();
        while (L < min || L > max){
            System.out.println(prompt);
            L = input.nextLong();
        }
        return L;
    }
}
