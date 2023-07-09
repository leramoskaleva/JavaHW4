// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном
// порядке и каждый из их узлов содержит одну цифру.
// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два
// числа должны быть отрицательными.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class HW4_2 {
    public static void main(String[] args) {

        Deque<Integer> num1 = new ArrayDeque<>();
        num1.add(3);
        num1.add(2);
        num1.add(1);

        Deque<Integer> num2 = new ArrayDeque<>();

        num2.addLast(-6);
        num2.addLast(-5);
        num2.addLast(4);

        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);

        Deque<Integer> sum = addTwoNumbers(num1, num2);
        System.out.println("Сумма чисел = " + sum);
    }

    public static Deque<Integer> addTwoNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        int carry = 0;
        Deque<Integer> sum = new LinkedList<>();

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.remove();
            int digit2 = num2.isEmpty() ? 0 : num2.remove();
            int currSum = digit1 + digit2 + carry;
            int currDigit = currSum % 10;
            carry = currSum / 10;
            sum.add(currDigit);
        }

        return sum;
    }
}
