// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном
// порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class HW4 {
    public static void main(String[] args) {

        Deque<Integer> num1 = new ArrayDeque<>();
        Deque<Integer> num2 = new ArrayDeque<>();

        num1.addLast(3);
        num1.addLast(2);
        num1.addLast(1);

        num2.addLast(6);
        num2.addLast(5);
        num2.addLast(4);

        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);

        LinkedList<Integer> product = multiplyNumbers(num1, num2);
        System.out.println("Произведение чисел = " + product);
    }

    public static LinkedList<Integer> multiplyNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        LinkedList<Integer> result = new LinkedList<>();

        Iterator<Integer> iterator1 = num1.iterator();

        while (iterator1.hasNext()) {
            int digit1 = iterator1.next();

            Iterator<Integer> iterator2 = num2.iterator();
            int carry = 0;
            LinkedList<Integer> tempResult = new LinkedList<>();

            for (int i = 0; i < result.size(); i++) {
                tempResult.addLast(0);
            }

            while (iterator2.hasNext()) {
                int digit2 = iterator2.next();
                int product = (digit1 * digit2) + carry;

                tempResult.addLast(product % 10);
                carry = product / 10;
            }

            if (carry > 0) {
                tempResult.addLast(carry);
            }

            result = addLists(result, tempResult);
        }

        return result;
    }

    public static LinkedList<Integer> addLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (list1.size() < list2.size()) {
            LinkedList<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }

        LinkedList<Integer> sum = new LinkedList<>();
        int carry = 0;

        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();

        while (iterator2.hasNext()) {
            int digit1 = iterator1.next();
            int digit2 = iterator2.next();

            int total = digit1 + digit2 + carry;
            sum.addLast(total % 10);
            carry = total / 10;
        }

        while (iterator1.hasNext()) {
            int digit = iterator1.next() + carry;

            sum.addLast(digit % 10);
            carry = digit / 10;
        }

        if (carry > 0) {
            sum.addLast(carry);
        }

        return sum;
    }
}
