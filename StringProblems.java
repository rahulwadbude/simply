package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringProblems {
    static void main() {

        //  StringRevers();
        // StringRevers2();
        // StringDuplicateChar();
        // StringDuplicateChar2();
        //  DuplicateWordCount();
        //  firstStringArray();
//        boolean result = checkAnagram();
//        System.out.print("Two String Anagram is " + result);

        // checkDiffChar();
        //   findCommonString();
//        List<List<String>> returnResult = groupAnagrams();
//        System.out.print("groupAnagrams Anagram is " + returnResult);

        //     StringCompressionLeetCode443();
        // generateRomanNumber();
        // boolean result=  checkStringArray(); System.out.print(result);

        //  firstRepeatChar();
        //  freonce();
        // countMostFreVovelAndConst();
        // removeDuplicate();
        // rotateArray();
//        boolean resValue = checksubsequence();
//        System.out.print(resValue);

        //  KfreqElement();
        //  kthsmalestElemen();
       // reverseSentence();
        //testmethod();
     //   finDuplicate2();
      //  paladrom();
      //  checkEpamQ1();


    }
    int count = 10;

    public static void StringRevers() {
        String abc = "LTM";
        String reverse = "";
        for (int i = abc.length() - 1; i >= 0; i--) {
            char ch = abc.charAt(i);
            reverse = reverse + ch;
        }
        System.out.print("Reverse String is " + reverse);
    }

    public static void StringRevers2() {
        String abc = "LTIMindtree";
        String reverseString = IntStream.range(0, abc.length()).mapToObj(i -> abc.charAt(abc.length() - i - 1)).map(String::valueOf).collect(Collectors.joining());
        System.out.print("Reverse String is " + reverseString);
    }

    public static void StringDuplicateChar() {
        String abc = "LTIMindtree";
        Map<Character, Long> result = abc.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.print(result);
    }


    public static void StringDuplicateChar2() {
        String abc = "LTIMindtree";
        List<Character> result = abc.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().filter(val -> val.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.print(result);
    }

    public static void StringDuplicateChar3() {
        String abc = "LTIMindtree";
        List<Character> result = abc.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().filter(val -> val.getValue() >1 ).map(Map.Entry::getKey).toList();
        System.out.print(result);
    }

    public static void DuplicateWordCount() {
        String abc = "LTIMindtree LTIMindtree is good Company Company";
        java.util.Map<String, Long> duplicateWord = Arrays.stream(abc.split(" ")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.print(duplicateWord);
    }

    public static void firstStringArray() {

        String abcs = "dog,cat,cat2,dog2,elephant,lion";
        Map<Character, Long> result = Arrays.stream(abcs.split(",")).collect(Collectors.groupingBy(ch -> ch.charAt(0), Collectors.counting()));
        List<Character> charList = result.entrySet().stream().filter(word -> word.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.print(charList);
    }

    public static boolean checkAnagram() {
        String s1 = "raaahulw";
        String S2 = "raaahulu";
        int arr[] = new int[26];
        if (s1.length() != S2.length()) return false;
        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : S2.toCharArray())
            if (--arr[ch - 'a'] < 0) return false;
        return true;
    }

    public static boolean checkDiffChar() {

        String abc[] = {"orange", "bana", "banaba", "banuma"};
        String target = "banana";

        for (String word : abc) {
            int count = 0;
            if (target.length() != word.length()) continue;

            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != word.charAt(i))
                    count++;
            }
            if (count == 1) System.out.print("Count of diff " + count + "for  " + word);
        }

        return true;
    }


    public static void findCommonString() {

        String abc[] = {"My name is Rahul", "My name is Rahul", "My name is abc", "My is wadbude"};

        Map<String, Long> countWord = Arrays.stream(abc).flatMap(line -> Arrays.stream(line.split(" "))).collect(Collectors.groupingBy(
                word -> word, Collectors.counting()
        ));

        countWord.forEach((e, v) -> System.out.print("key " + e + "  value " + v + " \n"));

    }


    public static List<List<String>> groupAnagrams() {
        String[] strs = {"abc", "bca", "bcas", "cab"};
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            return new ArrayList<>(map.values());
        }

        return null;
    }

    public static void StringCompressionLeetCode443() {
        Character[] stringList = {'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int listSize = stringList.length;
        int index = 0;
        int i = 0;
        while (i < listSize) {
            int count = 0;
            char ch = stringList[i];
            while (i < listSize && stringList[i] == ch) {
                count++;
                i++;
            }
            stringList[index] = ch;
            index++;
            if (count > 1) {
                String countSplit = String.valueOf(count);
                for (char coun : countSplit.toCharArray()) {
                    stringList[index] = coun;
                    index++;
                }
            }
        }
        for (int in = 0; in < index; in++) {
            System.out.print(stringList[in]);
        }
        System.out.print("Count is " + index);
    }


    public static void generateRomanNumber() {
        int num = 10;
        Integer[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            int times = num / nums[i];
            while (times != 0) {
                result += symbol[i];
                times--;
            }
            num = num % nums[i];
        }
        System.out.print(result);
    }

    // checking two string array is equivalent or not
    public static boolean checkStringArray() {

        String[] arr1 = {"ab", "cd"};
        String[] arr2 = {"a", "bcd"};

        /*
        String result1="";
        String result2="";
        for (String  arr :arr1){
            result1+=arr;
        }
        for (String  arr :arr2){
            result2+=arr;
        }
            return result1.equalsIgnoreCase(result2); */

        int m = arr1.length;
        int n = arr2.length;

        int wr1 = 0, i = 0;
        int wr2 = 0, j = 0;
        while (wr1 < m && wr2 < n) {

            if (arr1[wr1].charAt(i) != arr2[wr2].charAt(j))
                return false;
            i++;
            j++;

            if (i == arr1[wr1].length()) {
                i = 0;
                wr1++;
            }
            if (j == arr2[wr2].length()) {
                j = 0;
                wr2++;
            }

            if (wr1 == arr1.length && wr2 == arr2.length)
                return true;
        }


        return false;
    }

    public static void firstRepeatChar() {
        String abc = "abccbdef";
        int count[] = new int[26];
        for (char ch : abc.toCharArray()) {

            if (count[ch - 'a'] > 0) {
                System.out.print("first char is " + ch);
            }
            count[ch - 'a']++;
        }
    }

    public static void freonce() {
        String abc = "abcbad";
        int chArray[] = new int[26];

        for (char ch : abc.toCharArray()) chArray[ch - 'a']++;

        for (int i = 0; i < abc.length() - 1; i++) {
            if (chArray[abc.charAt(i) - 'a'] == 1)
                System.out.print(abc.charAt(i));
        }
    }

    public static void countMostFreVovelAndConst() {
        String abc = "successese";
        int chArray[] = new int[26];
        for (char ch : abc.toCharArray()) chArray[ch - 'a']++;
        int vowelCount = 0;
        int constCount = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (isVowel(ch))
                vowelCount = Math.max(vowelCount, chArray[i]);
            else
                constCount = Math.max(constCount, chArray[i]);
        }
        Integer count = vowelCount + constCount;
        System.out.print("Total Count is " + count);
    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        else
            return false;
    }

    public static void removeDuplicate() {

        int arr[] = {2, 2, 2, 5, 5, 7, 7, 8};
        int i = 0;
        int j = 1;
        while (i < arr.length - 1 && j <= arr.length - 1) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j++];
            }
            j++;
        }
        for (int ret = 0; ret <= i; ret++) {
            System.out.print("num is " + arr[ret]);
        }
    }

    public static void rotateArray() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7}; // {5,6,7,1,2,3,4}
        int k = 3;
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);
        for (int num : arr)
            System.out.print(num);


    }

    public static void reverseArray(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


    public static boolean checksubsequence() {
        String t = "ahbgdc";
        String s = "abc";
        int i = 0;
        int j = 0;
        while (i < t.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else
                i++;
        }
        if (j == s.length()) return true;
        return false;
    }

    public static void KfreqElement() {
        int arr[] = {1, 2, 3, 2, 1, 1, 1, 4, 2, 4, 3, 3, 3, 2, 6, 7, 8};

        Map<Integer, Integer> freMap = new HashMap<>();
        for (Integer num : arr)
            freMap.put(num, freMap.getOrDefault(num, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < 3; i++)
            System.out.println(list.get(i).getKey());
    }

    public static void kthsmalestElemen() {

        int arr[] = {3, 5, 6, 7, 8, 9};// for min use collections.reverse()
        int k = 2;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        System.out.print(queue.peek());
    }

    public static void reverseSentence() {
        String abc = " The Sky is   Blue color";
        String[] stringArr = abc.trim().split("\\s+");
        int left = 0;
        int right = stringArr.length - 1;
        while (left < right) {
            String temp = stringArr[left];
            stringArr[left] = stringArr[right];
            stringArr[right] = temp;
            left++;
            right--;
        }
        for (String word : stringArr) {
            System.out.println(word.toString());
        }
    }

    public static void testmethod() {
        AtomicInteger count = new AtomicInteger(1);
        new Thread(() -> {
            System.out.println("increment number is "+count.incrementAndGet());
        }).start();

    }

    public static void finDuplicate2(){
        String [] arr1={"one","two","Three","Four"};
        String [] arr2 ={"one","two"};

        Set<String> collect = Stream.of(arr1, arr2).flatMap(Arrays::stream).collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream()
                .filter(val -> val.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        for (String s : collect) {
            System.out.println(s);
        }

        Map<Integer,String> bb= new HashMap<>();

    }

    public static void  checkSorting(){
        //1. UnsortedList ("a", "c", "d", "b") -> sorted list ("d", "c", "b", "a")
        // 2. unsortedMap to sorted list ("a", "arg1", "b", "arg2", "c", "arg3")
        //3. unsortedMap to sorted list ("a", "b", "c", "arg1", "arg2", "arg3")
        List<String> UNSORTED_LIST =
                Arrays.asList("c", "a", "d", "b");
        Map<String, String> UNSORTED_MAP = Map.of(
                "a", "arg1",
                "c", "arg3",
                "b", "arg2"
        );
        List<String> sorted = UNSORTED_LIST.stream().sorted(Comparator.reverseOrder()).toList();

        sorted.forEach(ele -> System.out.print(" ' "+ele+" ', "));

        List<String> result1 = UNSORTED_MAP.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        System.out.println(result1);

        List<String> collectKey = UNSORTED_MAP.keySet().stream().sorted().collect(Collectors.toList());
        List<String> collectValues = UNSORTED_MAP.values().stream().sorted().collect(Collectors.toList());
        List<String> collect = Stream.of(collectKey, collectValues).flatMap(List::stream).collect(Collectors.toList());
        System.out.print(collect);
    }

    public static void paladrom() {
        String str = "MADAM";
        boolean b = IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
        System.out.print(b);

    }

public static void checkEpamQ1(){
        String sbc="hello world    whatsup";
    String collect ="#"+Arrays.stream(sbc.split("\\s+")).map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1)).collect(Collectors.joining());
System.out.print(collect);

}




}
