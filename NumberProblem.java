package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberProblem {
    static void main() {

//        getpairNumber1();
//        getpairNumber2();
        //  testNonZero();
        //  reverseArr1();
        //   reverseArr2();
        // checksecoundHightest();
        //findDuplicate();
        //  maxnumber();
        //   Secoundmaxnumber();
        //  FlatMapdemo();
        //  AverageOfOdd();
        //  pickElement();

        //boolean value=  validparanthisis();System.out.print("Valid Paranthisis "+value);

//      int [] result=  productExceptSelf();
//        for (int i : result) {
//            System.out.print(i +",");
//        }

        //   SingleNumber();
        //   MergeTwoSortedArray();
//      int result=  climbStairs();
//        System.out.print("climbStairs "+result);
        //removeDuplicates();
        //   getpairNumber1();

        // findTargetSum();
        // checkFirstAndLast();
        // findKthLargest();
//        int[] abc = checkMissingNumber();
//        for (int num : abc) System.out.print("nums are" + num);

       // checkkthOccurance();

      //  febonacciSeries();
       // mergeArray();
        finDuplicate2();
    }

    public static void getpairNumber1() {
        List<Integer> intList = List.of(3, 4, 5, 7, 5, 6);

        for (int i = 0; i < intList.size(); i++) {
            for (int j = i + 1; j < intList.size(); j++) {
                if (intList.get(i) + intList.get(j) == 10) {
                    System.out.print("number is " + intList.get(i) + " " + intList.get(j));
                }
            }
        }
    }

    public static void getpairNumber2() {

        List<Integer> intList = List.of(3, 4, 5, 7, 5, 6);
        Set<Integer> setData = new HashSet<>();
        for (Integer num : intList) {
            Integer comp = 10 - num;
            if (setData.contains(comp)) {
                System.out.print("Sum pair is " + num + "+" + comp);
            }
            setData.add(num);
        }
    }

    public static void testNonZero() {
        int arr[] = {1, 0, 3, 2, 0, 4, 5, 0};
        int count = 0;
        for (int num : arr) {
            if (num != 0)
                arr[count++] = num;
        }
        while (count < arr.length) {
            arr[count++] = 0;
        }

        for (int number : arr) {
            System.out.print(number + ",");
        }

    }

    public static void reverseArr1() {
        int arr[] = {7, 6, 5, 4, 2};
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        for (int num : arr) {
            System.out.print(num + ",");
        }
    }


    public static void reverseArr2() {
        int arr[] = {7, 6, 5, 4, 2};
        int arr2[] = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            arr2[j] = arr[i];
        }
        for (int num : arr2) {
            System.out.print(num + ",");
        }

    }

    public static void checksecoundHightest() {
        int arr[] = {2, 3, 4, 5, 6, 7};
        Integer first = Integer.MIN_VALUE;
        Integer secound = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                secound = first;
                first = arr[i];
            } else if (arr[i] > secound && arr[i] != first) {
                secound = arr[i];
            }
        }
        System.out.print("Secound number is  " + secound);
    }


    public static void findDuplicate() {
        int arr[] = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> comm = new HashSet<>();
        Set<Integer> duplicateValue = new HashSet<>();
        for (int num : arr) {
            if (!comm.add(num)) {
                duplicateValue.add(num);
            }
        }
        System.out.print("Duplicate value is " + duplicateValue);

    }

    public static void maxnumber() {
        Integer arr[] = {2, 4, 5, 6, 7, 8, 3};
        Optional<Integer> maxElement = Arrays.stream(arr).sorted(Comparator.reverseOrder()).findAny();
        System.out.print("Max Element is " + maxElement.get());
    }

    public static void Secoundmaxnumber() {
        Integer arr[] = {2, 4, 5, 6, 7, 8, 3};
        Optional<Integer> maxElement = Arrays.stream(arr).sorted(Comparator.reverseOrder()).skip(1).findAny();
        System.out.print(" Secound Max Element is " + maxElement.get());
    }


    public static void AverageOfOdd() {
        List<Integer> intList1 = List.of(1, 3, 5, 7, 9);
        List<Integer> intList2 = List.of(2, 4, 6, 8, 0);
        Set<Integer> listElement = Stream.of(intList1, intList2).flatMap(List::stream).sorted().collect(Collectors.toSet());
        int count = 0;
        int sum = 0;
        for (Integer num : listElement) {
            if (num % 2 != 0) {
                sum += num;
                count++;
            }
        }
        System.out.print(" AverageOfOdd " + sum / count);
    }

    public static void pickElement() {
        int arr[] = {2, 4, 5, 7, 8, 6, 3};
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        System.out.print("Pick Element is " + arr[left]);
    }

    public static boolean validparanthisis() {

        String paran = "()[{}]";
        Stack<Character> charac = new Stack<>();
        for (char ch : paran.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                charac.push(ch);
            else {
                if (charac.isEmpty()) return false;
                char pop = charac.pop();
                if ((ch == ')' && pop != '(') ||
                        (ch == ']' && pop != '[')
                        || (ch == '}' && pop != '{'))
                    return false;
            }
        }
        return charac.isEmpty();

    }


    public static int[] productExceptSelf() {
        int nums[] = {1, 2, 3, 4};
        int n = nums.length;
        int answer[] = new int[n];
        int prefex = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefex;
            prefex *= nums[i];
        } //[1,1,2,6]
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        } //[24,12,4,1] = [24,12,8,6]
        return answer;
    }

    public static void SingleNumber() {
        int arr[] = {2, 2, 3, 5, 5};
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        System.out.print("Single number Result is  " + xor);
    }

    public static void MergeTwoSortedArray() {
        int arr1[] = {2, 4, 7, 8};
        int arr2[] = {1, 3, 5, 6, 9};
        int n = arr1.length, m = arr2.length;
        int arr3[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < n)
            arr3[k++] = arr1[i++];
        while (j < m)
            arr3[k++] = arr2[j++];
        for (int nums : arr3) {
            System.out.print(nums + ",");
        }
    }

    public static int climbStairs() {
        int n = 4;
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
        // 1,1,1,1
        // 2,2
        //1,1,2
        //2,1,1
        //1,2,1
    }

    public static void removeDuplicates() {
        int arr[] = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> dupplicates = new HashSet<Integer>();
        Set<Integer> dupplicatesSet = new HashSet<Integer>();

        for (int nums : arr) {
            if (!dupplicates.add(nums)) {
                dupplicatesSet.add(nums);
            }
        }
        dupplicatesSet.forEach(num -> System.out.print("Duplicate is " + num));
    }

    public static void findTargetSum() {
                        //targetSumArray
        int arr[] = {1, 2, 3, 4, 6, 7};
        int target = 13;
        int start = 0;
        int sum = 0;
        List<Integer> pairArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target && start <= i) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                pairArray.add(arr[start]);
                pairArray.add(arr[i]);
                break;
            }
        }
        for (int ss : pairArray) {
            System.out.print("starting from " + ss + ",  To ");
        }
    }


    public static void checkFirstAndLast() {
        int arr[] = {1, 2, 3, 4, 5, 6, 4, 8, 9};
        int first = -1;
        int last = -1;
        int target = 4;
//        for (int i=0,j=arr.length-1;i<j;i++,j--){
//             if (arr[i] == target)
//                 first=i;
//             if (arr[j]== target)
//                 last=j;
//        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1)
                    first = i;
                last = i;
            }
        }


        System.out.print("First is " + first + "Last is " + last);
    }


    public static void findKthLargest() {
        int[] nums = {5, 6, 2, 3, 7, 8};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue(); // min-heap
        for (int x : nums) {
            pq.offer(x);
            if (pq.size() > k) pq.poll(); // drop smallest to keep top-k
        }
        System.out.print("K Largest value is " + pq.peek()); // k-th largest

//      Optional<Integer> result=  Arrays.stream(nums).boxed().distinct().
//                        sorted(Comparator.reverseOrder()).skip(2).findFirst();
//      System.out.print("K Largest element is "+result.get());
    }

    //How to find ALL zero-sum subarrays
    public static int[] checkMissingNumber() {
        int arr[] = {4, -2, 2, 2,1, 6};
        int sum = 0;
        Map<Integer, Integer> mapOfEntry = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (mapOfEntry.containsKey(sum)) {
                return new int[]{mapOfEntry.get(sum) + 1, i};
            }
            mapOfEntry.put(sum, i);
        }
        return new int[]{};
    }


    public static void checkkthOccurance() {
        int[] arr = {4, 4, 4, 3, 3, 2, 2, 2, 2, 1, 1};
        int k = 2;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b)); // min-heap
        for (int num : freqMap.keySet()) {

            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }
        List<Integer> result = new ArrayList<>(pq);
        System.out.print("Kth Numbers Occurance is " + result.get(0));

    }
  public static void febonacciSeries(){


      final long[] fib = {0, 1};

      Stream.generate(() -> {
                  long temp = fib[0];
                  long next = fib[0] + fib[1];
                  fib[0] = fib[1];
                  fib[1] = next;
                  return temp;
              })
              .limit(10)
              .forEach(System.out::println);

  }

  public static void mergeArray(){
        int arr1[]={1,2,5,0,0,0};
        int arr2[]={2,3,6};
        int i=2;
        int j=2;
        int k=arr1.length-1;
        while (i>=0 && j>=0){
            if (arr1[i]>arr2[j])
                 arr1[k--]=arr1[i--];
            if (arr2[j]>arr1[i])
                arr1[k--]=arr2[j--];
            else
                arr1[k--]=arr1[i--];
        }

for (int num : arr1){
    System.out.print(num+",");
}




  }

    public static void findDuplicateStream(){
        Integer arr []={1,2,2,3,4,4,5,5,6,6,7};
        Set<Integer>  duplicateList= new HashSet<>();
        Set<Integer> duplicate=  Arrays.stream(arr).filter( num -> !duplicateList.add(num)).collect(Collectors.toSet());
        System.out.print(duplicate);
    }


    public static void finDuplicate(){
        Integer [] arr1={1,2,3,4,5,6};
        Integer [] arr2 ={3,4,5,6,7,8,9};
        Set<Integer> withoutDupli = new HashSet<>();

        for (Integer num : arr1)
        {
            withoutDupli.add(num);
        }
        for (Integer num : arr2)
        {
            withoutDupli.add(num);
        }
        System.out.print(withoutDupli);
    }

    public static void finDuplicate2(){
        int [] arr1={1,2,3,4,5,6};
        int [] arr2 ={3,4,5,6,7,8,9};

        Set<Integer> collect = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().collect(Collectors.toSet());
//System.out.print(collect);

        Set<Integer> collect1 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting())).entrySet().stream().filter(n -> n.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.print(collect1);
    }

    public static void FlatMapdemo() {
        List<Integer> intList1 = List.of(1, 3, 5, 7, 9);
        List<Integer> intList2 = List.of(2, 4, 6, 8, 0);
        Set<Integer> listElement = Stream.of(intList1, intList2).flatMap(List::stream).sorted().collect(Collectors.toSet());
        System.out.print(" Stream of number " + listElement);
    }

    public static void checkEpamQ2(){

        int arr[]= {1,2,3,4,5,6,7};
        int k=3;
        int result[]=new int[arr.length];
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];

            if (i>=k)
                sum-=arr[i-k];
            result[i]=sum;
        }

        for (int num: result)
            System.out.print(num+",");

    }


}
