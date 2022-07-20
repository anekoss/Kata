import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(calc(s));
    }

    public static String calc(String input) throws IllegalFormatException {
        int sign1 = input.indexOf(" ");
        int sign2 = input.indexOf(" ", sign1 + 1);
        boolean r = true;
        int res;
        String one = input.substring(0, sign1).trim();
        String two = input.substring(sign2).trim();
        String sign = input.substring(sign1 + 1, sign2).trim();
        if (Number.convertToArab(one) != -1 && Number.convertToArab(two) != -1) {
            sign1 = Number.convertToArab(one);
            sign2 = Number.convertToArab(two);
        } else if (Integer.parseInt(one) >=1 && Integer.parseInt(two)>=1&&Integer.parseInt(one) <=10 && Integer.parseInt(two)<=10) {
            sign1 = Integer.parseInt(one);
            sign2 = Integer.parseInt(two);
            r = false;
        }
        else throw new NumberFormatException("Значения параметров не удовлетворяют условию.");

        switch (sign) {
            case "*": {
                res = sign1 * sign2;
                break;
            }
            case "/": {
                res = sign1 / sign2;
                break;
            }
            case "-": {
                res = sign1 - sign2;
                break;
            }
            case "+": {
                res = sign1 + sign2;
                break;
            }
            default:
                throw new IllegalStateException("Неверный знак выражения: " + sign);
        }
        if (!r) {
            return String.valueOf(res);
        }
        String s = Number.converToRim(res);
        if (s.equals("O")) throw new ArrayIndexOutOfBoundsException("Ответ не удовлетворяет условиям.") ;
        else return Number.converToRim(res);
    }
}