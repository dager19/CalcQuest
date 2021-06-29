import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    static Scanner input = new Scanner(System.in);
    static int a, b;
    static int result;
    static char operator;

    public static void main(String[] args) {
        // Calc calc = new Calc();
            System.out.println("Введите выражение или два римских числа от I до X ");
            String getUserInput = input.nextLine();
            char[] limitChar = new char[10];
            for (int i = 0; i < getUserInput.length(); i++) {  //getUserInput(userInput.length())
                limitChar[i] = getUserInput.charAt(i);
                if (limitChar[i] == '+') {
                    operator = '+';
                }
                if (limitChar[i] == '-') {
                    operator = '-';
                }
                if (limitChar[i] == '*') {
                    operator = '*';
                }
                if (limitChar[i] == '/') {
                    operator = '/';
                }
            }
            String limitCharString = String.valueOf(limitChar);
            String[] blacks = limitCharString.split("[+-/*]");
            String stable00 = blacks[0];
            String stable01 = blacks[1];
            String string03 = stable01.trim();
            a = rimToNumber(stable00);
            b = rimToNumber(string03);
            if (a < 0 && b < 0) {
                result = 0;
            } else {
                result = calculating(a, b, operator);
                System.out.println("Результат для римских цифр");
                String resultRoman = convertNumToRoman(result);
                System.out.println(stable00 + " " + operator + " " + string03 + " = " + resultRoman);
            }
            a = Integer.parseInt(stable00);
            b = Integer.parseInt(string03);
            result = calculating(a, b, operator);
            System.out.println("Результат для арабских цифр");
            System.out.println(a + " " + operator + " " + b + " = " + result);
        }





    /*public enum Operators {
        normal, add, minus, multiply, divide
    }*/

            //int[] arabNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


            //private int a, b;
//    int a = input.nextInt();
//    int b = input.nextInt();

            // private Operators mode = Operators.normal;




           // public Calc() {
            //}

            private static String convertNumToRoman(int numArabian) {
                String[] rim = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                        "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

                final String str = rim[numArabian];
                return str;
            }

            private static int rimToNumber(String rim) {
                try {
                    if (rim.equals("I")) {
                        return 1;
                    } else if (rim.equals("II")) {
                        return 2;
                    } else if (rim.equals("III")) {
                        return 3;
                    } else if (rim.equals("IV")) {
                        return 4;
                    } else if (rim.equals("V")) {
                        return 5;
                    } else if (rim.equals("VI")) {
                        return 6;
                    } else if (rim.equals("VII")) {
                        return 7;
                    } else if (rim.equals("VIII")) {
                        return 8;
                    } else if (rim.equals("IX")) {
                        return 9;
                    } else if (rim.equals("X")) {
                        return 10;
                    }
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Ошибка! Неверный формат данных"); //IllegalInputExc();
                }
                return -1;
            }

    /*public void getUserInput() {

    }*/




/*
    //@Override
    public void showMainMenu() {
        System.out.println("Выберите вид операции");
        System.out.println("1. + ");
        System.out.println("2. - ");
        System.out.println("3. * ");
        System.out.println("4. / ");

        System.out.println("Пожалуйста, выберите с 1 по 4: ");
        try {
            getUserInput();
        }catch(IllegalInputException e) {
            System.out.println("Вы ввели "+e.getInput()+", это не подходящее число，введите число с 1 по 4");
        }finally {
            showMainMenu();
        }
    }


    private void menu() throws IllegalInputException{
        int choice = input.nextInt();
        switch(choice) {
            case 1: showDetailInfo(); break;
            default:
                throw new IllegalInputException(choice);
        }
    }
    */

    public static int calculating(int a, int b, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                try {
                    result = a / b;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

    }
