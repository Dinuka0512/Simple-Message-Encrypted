import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static char[] lowercaseLetters = new char[26];
    private static char[] uppercaseLetters = new char[26];

    static {
        for (int i = 0; i < 26; i++) {
            lowercaseLetters[i] = (char) ('a' + i);
            uppercaseLetters[i] = (char) ('A' + i);
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        do {
            menu();

            System.out.print(" \n\nDo you want to exit (Y/N) : ");
            char letterCheck = scanner.next().charAt(0);

            if(letterCheck == 'N' || letterCheck == 'n'){
                exit = true;
            }else{
                exit = false;
                System.out.println("SEE YOU AGAIN BYE.....!");
            }
        }while (exit);
    }

    public static void menu(){
        System.out.println("=================================");
        System.out.println(" \tWELCOME TO CHAT ENCRIPTER");
        System.out.println("================================= \n\n");

        System.out.println("1) Chat Encrypt \t\t 2) Chat Decrypt");

        //HERE CAN CHOOSE THE OPTION
        System.out.print(" \n(THERE YOU NEED TO ENTER ONLY NUMBER 1 or 2 !!!!) \nChoose Option : ");
        int chooseOption = scanner.nextInt();
        scanner.nextLine();

        if(chooseOption == 1){
            encript();
        }else{
            decript();
        }
    }

    public static void encript(){
        System.out.println("===============================");
        System.out.println(" \t\tCHAT ENCRYPT");
        System.out.println("===============================");

        System.out.print("Enter the massage You need to encrypt : ");
        String message = scanner.nextLine();

        //CONVERT THE STRING MASSAGE TO CHAT ARRAY
        char[] array = message.toCharArray();

        //CREATE THE ARRAYLIST FOR STORE THE CONVERTED MESSAGE
        ArrayList<String> concerted = new ArrayList<>();

        for(char letter : array){

            //HERE CHECK THE LETTER WE GET IS IT EQUAL THE CAPITAL OR SIMPLE
            //EX - (letter == 'A' || letter == 'a'){}

            boolean check = true;
            for(int i = 0; i < 26; i++){
                if(letter == lowercaseLetters[i] || letter == uppercaseLetters[i]){
                    concerted.add(String.valueOf(i+1));
                    check = false;
                }
            }

            if(check && letter == ' '){
                concerted.add(" ");
            }
        }

        //PRINT ARRAY CONVERTED
        for(String i : concerted){
            System.out.print(i + ".");
        }
    }

    public static void decript(){
        System.out.println("=============================");
        System.out.println(" \t\tCHAT DECRYPT");
        System.out.println("=============================");

        System.out.print(" \n\nEnter your Secret massage to decript : ");
        String message = scanner.nextLine();

        //THERE SPLIT BY THE DOT "."
        String[] parts = message.split("\\.");

        //CREATE ARRAYLIST TO ADD INTEGERS WHERE SPLIT
        ArrayList<Integer> integers = new ArrayList<>();
        for(String part : parts){
            if(!part.equals(" ")){
                integers.add(Integer.valueOf(part));
            }else{
                integers.add(0);
            }
        }

        //CREATED THE REAL MESSAGE ARRAYLIST
        ArrayList<String> realMessage = new ArrayList<>();

        //SEE REAL MESSAGE
        for(int i : integers){
            if (i != 0){
                realMessage.add(String.valueOf(lowercaseLetters[i-1]));
            }else{
                realMessage.add(" ");
            }
        }


        //PRINT REAL MESSAGE
        for (String letter : realMessage){
            System.out.print(letter);
        }
    }
}