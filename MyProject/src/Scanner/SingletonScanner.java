package Scanner;

import java.util.Scanner;

public class SingletonScanner {
    private static Scanner scanner = new Scanner(System.in);
    private static SingletonScanner instance = new SingletonScanner();

    private SingletonScanner() {}

    public static SingletonScanner getScanner(){
        return instance;
    }

    public String readInput(){
        return scanner.nextLine();
    }

}
