import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mass = bufferedReader.readLine();
        String[] splittedmass = mass.split(" ");
        int[] arrayOne = new int[splittedmass.length];
        for (int i = 0; i < arrayOne.length; i++){
            arrayOne[i] = Integer.parseInt(splittedmass[i]);
        }
        mass = bufferedReader.readLine();
        splittedmass = mass.split(" ");
        int[] arrayTwo = new int[splittedmass.length];
        for (int i = 0; i < arrayTwo.length; i++){
            arrayTwo[i] = Integer.parseInt(splittedmass[i]);
        }
        System.out.println("Массив_1: " + Arrays.toString(arrayOne));
        System.out.println("Массив_2: " + Arrays.toString(arrayTwo));
        long start = System.currentTimeMillis();
        ListNode answ = addTwoNumbers(arrayToListNode(arrayOne), arrayToListNode(arrayTwo));
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode l3 = answer;
        int nextNum = 0;
        while (l1 != null || l2 != null){
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + nextNum;
            nextNum = 0;
            if (sum >= 10){
                l3.next = new ListNode(sum - 10);
                nextNum = 1;
            }
            else
                l3.next = new ListNode(sum);
            l3 = l3.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (nextNum == 1)
            l3.next = new ListNode(1);
        return answer.next;
    }

    public static ListNode arrayToListNode(int[] array){
        if (array.length == 1)
            return new ListNode(array[0]);
        ListNode listNode = new ListNode(array[0]);
        ListNode temp = new ListNode(array[1]);
        listNode.next = temp;
        for (int i = 2; i < array.length; i++){
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = array[i];
        }
        return listNode;
    }
/*
    public static ListNode arrayToListNode(LinkedList<Integer> array) {
        if(array.size() == 1)
            return new ListNode(array.pop());
        ListNode listNode = new ListNode(array.remove());
        ListNode temp = new ListNode(array.remove());
        listNode.next = temp;
        while (!array.isEmpty()){
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = array.remove();
        }
        return listNode;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        LinkedList<Integer> arrayOne = new LinkedList<>();
        LinkedList<Integer> arrayTwo = new LinkedList<>();
        LinkedList<Integer> answer = new LinkedList<>();
        while (l1 != null) {
            arrayOne.add(0, l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            arrayTwo.add(0, l2.val);
            l2 = l2.next;
        }
        System.out.println(Arrays.toString(arrayOne.toArray()));
        System.out.println(Arrays.toString(arrayTwo.toArray()));
        int max = Math.max(arrayOne.size(), arrayTwo.size());
        int nextDischarge = 0;
        for (int i = 0; i < max; i++){
            int arrOneNum = 0;
            int arrTwoNum = 0;
            int result;
            if (!arrayOne.isEmpty())
                arrOneNum = arrayOne.removeLast();
            if (!arrayTwo.isEmpty())
                arrTwoNum = arrayTwo.removeLast();
            result = arrOneNum + arrTwoNum + nextDischarge;
            nextDischarge = 0;
            if (result >= 10) {
                answer.add(result - 10);
                nextDischarge = 1;
            }
            else
                answer.add(result);
        }
        if(nextDischarge == 1)
            answer.add(1);
        System.out.println(Arrays.toString(answer.toArray()));
        return arrayToListNode(answer);
    }*/
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
