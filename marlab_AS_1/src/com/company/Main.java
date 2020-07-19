package com.company;
import java.lang.String;
import java.util.*;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        String s = "Hello World";
        String palindromeString = "123321";
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(1, "chen");
        hash_map.put(2, "ke");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //1.
        System.out.println("==============/n test 1");
        getReversed(s);
        System.out.println(s);

        //2.
        System.out.println("==============/n test 2");
        System.out.println(getNumberOfWords(s));

        //3.
        System.out.println("==============/n test 3");
        loopHashMap(hash_map);

        //4.
        System.out.println("==============/n test 4");
        if(isPalindrome(palindromeString)){
            System.out.println(palindromeString + " is palindrome string");
        }
        else{
            System.out.println(palindromeString + " is not palindrome string");
        }

        //5.
        System.out.println("==============/n test 5");
        loopArrayList(arrayList);

        //6.
        System.out.println("==============/n test 6");
        ArrayList<Character> testArray = new ArrayList();
        String testString6 = "womenyiqixuemaojiao";
        testArray = duplicateCharacters(testString6);
        for (Character c : testArray){
            System.out.print(c);
        }

        //7.
        System.out.println("==============/n test 7");
        int[] testArray7 = {1, 2, 3, 5, 8, 7, 19, 21, 4};
        System.out.println(findSecondHighest(testArray7));

        //8.
        System.out.println("==============/n test 8");
        String testS = "I Love Zimeng Chen";
        removeSpace(testS);

        //9.
        System.out.println("==============/n test 9");
        int[] testArray9 = {1, 2, 4, 4, 5, 6, 8, 9, 9};
        findMissingNumber(testArray9);
    }

    //1.Write a Java Program to reverse a string without using String inbuilt function reverse.
    public static void  getReversed(String s){
        String ret = "";
        for (int i = s.length() - 1; i >= 0; i--){
            ret += s.charAt(i);
        }
        s = ret;
    }

    //2.Write a Java Program to count the number of words in a string using HashMap.

    public static int getNumberOfWords(String s){
        HashMap<String, Integer> wordToNumber = new HashMap<String, Integer>();
        String[] wordArray = s.split(" ");
        int count = 0;
        for (int i = 0; i < wordArray.length; i++){
            if (!wordToNumber.containsKey(wordArray[i])) {
                wordToNumber.put(wordArray[i], 1);
                count += 1;
            }
        }
        return count;
    }


    //3.Iterate HashMap using while and advance for loop
    public static void loopHashMap(HashMap<Integer, String> hash_map){
        //for loop
        for (Map.Entry<Integer, String> set :hash_map.entrySet() ){
            System.out.println(set.getKey() + "=" + set.getValue());
        }

        Iterator<Entry<Integer, String>> it = hash_map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String> set = (Map.Entry<Integer, String>) it.next();
            System.out.println(set.getKey() + "=" + set.getValue());
        }
    }

    //4.find whether a string is palindrome or not
    public static boolean isPalindrome(String s){
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    //5.loop arraylist
    public static void loopArrayList(ArrayList<Integer> array_list){
        //for loop
        for (int i = 0; i < array_list.size(); i++){
            System.out.println(array_list.get(i));
        }
        //while loop
        int i = 0;
        while (i < array_list.size()) {
            System.out.print(array_list.get(i));
            i++;
        }
        //advance for loop
        for (int num : array_list){
            System.out.println(num);
        }
    }

    //6.find duplicate characters in a string
    public static ArrayList duplicateCharacters(String s){
        HashMap <Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                int time = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), time);
            }
            else{
                map.put(s.charAt(i), 1);
            }
        }
        ArrayList<Character> array = new ArrayList();
        for (Character ch : map.keySet()){
            if (map.get(ch) == 1){
                continue;
            }
            array.add(ch);
        }

        return array;
    }

    //7.find the second highest number in a array
    public static int findSecondHighest(int[] array){
        if (array.length == 1){
            return array[0];
        }
        int first = Math.max(array[0], array[1]);
        int second = Math.min(array[0], array[1]);
        for (int i = 0; i < array.length; i++){
            int temp = array[i];
            if (temp > first){
                int t = first;
                first = temp;
                second = t;
            }
            else{
                if (temp > second){
                    second = temp;
                }
            }
        }
        return second;
    }

    //8.remove all white space in a string without using replace
    public  static void removeSpace(String s){
        String ret = "";
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                ret += s.charAt(i);
            }
        }
        System.out.println(ret);
    }

    //9.find missing numbers in a array of numbers
    public static void findMissingNumber(int[] array){
        int l = array.length;
        ArrayList a = new ArrayList();
        for (int i = 0; i <= l; i++){
            a.add(i);
        }
        for (int i = 0; i < l; i++){
            if (a.contains(array[i])){
                a.remove( (Integer)(array[i]));
            }
        }
        System.out.println(a);
    }

    //10.find the most repeated word in a text file
    public static void findReapedWordInFile(FileReader file) throws Exception{
        BufferedReader br = new BufferedReader(file);
        String line, word = "";
        int count = 0, maxCount = 0;
        ArrayList<String> words = new ArrayList<>();
        while ((line = br.readLine()) != null){
            String[] string = line.toLowerCase().split("[,.\\s]+");
            for (String s : string){
                words.add(s);
            }
        }
        for (int i = 0; i < words.size(); i++){
            count = 1;
            for (int j = i + 1; j < words.size(); j++){
                if (words.get(i).equals(words.get(j))){
                    count += 1;
                }
            }
            if (count > maxCount){
                maxCount = count;
                word = words.get(i);
            }
        }
        System.out.println("The most repeated word is " + word);
        br.close();
    }
}
