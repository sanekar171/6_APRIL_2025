package org.example;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class StringCode {
    public static void main(String[] args) {
        String str1 = "testValue";
        String str2 = "testValue";
        String str3 = "testValue";

        if (str1 == str2 && str2 == str3 && str3 == str1)
            System.out.println("All references are equal, string literals created in String constant Pool");

        if (str1.equals(str2) && str2.equals(str3) && str3.equals(str1))
            System.out.println("All Values are equal");

        String str4 = new String("testValue");
        String str5 = new String("testValue");

        if (str4 != str5)
            System.out.println("References NOT equal, since Strings created on HEAP space using constructor/new keyword");

        if (str4.intern() == str5.intern())
            System.out.println("Even though strings were created both on heap separately, interning them makes them point to same String literal on the SCP/SLP, thereby leading to equal references");

        String str6 = new String("testValue");
        String str7 = str6.intern();

        if (str6 != str7)
            System.out.println("References are NOT equal, since str6 exists on the HEAP space and str7 exists in the SCP/SLP");

        String str8 = "Hello";
        str8.concat("World");
        System.out.println(str8 + " Old value of str8 will be referred to, since we've NOT reassigned new value to str8, a new String literal 'hello world' gets created on SCP/SLP");

        StringBuilder stringBuilder = new StringBuilder("testValue");
        stringBuilder.append("World");
        System.out.println(stringBuilder);

        System.out.println(str1.replace("T", "Z"));
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());
        System.out.println(str1.substring(0));
        System.out.println(str1.substring(3));
        System.out.println(str1.substring(2, 5));
        System.out.println(str1.substring(0, 3));

        System.out.println(str1.lastIndexOf("t"));
        System.out.println(str1.indexOf("t"));

        System.out.println(str1.replaceAll("t", "*^I"));

        String str9 = "  SPA C E      S       ";
        System.out.println(str9.replaceAll("\\s+", "*"));
        System.out.println(str9.replaceAll("\\s", "*"));

        String[] parts = str9.split("\\s+");
        System.out.println(Arrays.toString(parts));

        parts = str9.split("\\s");
        System.out.println(Arrays.toString(parts));

        String number = "1234567";
        int n = Integer.parseInt(number);
        System.out.println(n);
        n = Integer.valueOf(number);
        System.out.println(n);

        //invalid number
        number = "1234*2";
        try {
            n = Integer.valueOf(number);
            //this is NOT unreachable code compilation issue, but control will move to catch block after valueOf() call only
            //Integer.parseInt() will not be executed
            n = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            nfe.printStackTrace(pw);
            String message = sw.toString();
            message = message.replaceAll("\r\n\t", "*");
            System.out.println(message);
        }

        //String comparisons
        str1 = "Australia";
        str2 = "Australia";

        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
        System.out.println(Objects.equals(str1, str2));
        System.out.println(Objects.equals(null, null));

        str2 = "AUSTRALIA";
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(Objects.equals(str1.toUpperCase(), str2));
        System.out.println(Objects.equals(str1.toLowerCase(), str2.toLowerCase()));

        str2 = "Austria";
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(Objects.equals(str1, str2));

        str1 = str2;
        str2 = "Australia";

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str2.compareTo(str1));
        System.out.println(str2.compareToIgnoreCase(str1));

        str1 = "This is an apple in the pie of the bakery";
        //print even lengthed words
        String[] words = str1.split("\\s");
        int N = words.length;
        for (int i = 0; i <= N - 1; i++) {
            if (words[i].length() % 2 == 0)
                System.out.print(words[i] + "\t");
        }
        System.out.println();

        str1 = "Alice in Wonderland";
        byte[] bytes = str1.getBytes();
        str1 = new String(bytes);
        System.out.println(str1);

        char[] chars = str1.toCharArray();
        str1 = new String(chars);
        System.out.println(str1);

        //Reversal
        //using getBytes()\
        byte[] bytes1 = str1.getBytes();
        byte temp;
        N = bytes1.length;
        for (int i = 0; i <= N/2; i++)
        {
            temp=bytes1[N-1-i];
            bytes1[N-1-i]=bytes1[i];
            bytes1[i]=temp;
        }
        str1=new String(bytes1);
        System.out.println(str1);

        //using toCharArray
        str1="Alice in Wonderland";
        char[]chars1=str1.toCharArray();
        N=chars1.length;
        char t;

        for(int i=0;i<N/2;i++)
        {
            t=chars1[N-1-i];
            chars1[N-1-i]=chars1[i];
            chars1[i]=t;
        }
        str1=new String(chars1);
        System.out.println(str1);

        str1="Alice in Wonderland";
        //using StringBuilder
        System.out.println(new StringBuilder(str1).reverse());

        //using StringBuffer
        System.out.println(new StringBuffer(str1).reverse());

        //using ArrayList of Character and Collections.reverse() method
        chars=str1.toCharArray();
        ArrayList<Character> charList=new ArrayList<>();
        for(char temp1:chars)
        {
            charList.add(temp1);
        }
        Collections.reverse(charList);
        for(int i=0;i<=charList.size()-1;i++)
        {
            chars[i]=charList.get(i);
        }
        str1=new String(chars);
        System.out.println(str1);

        //sort by Arrays.sort method
        str1="Alice in Wonderland";
        str1=str1.toLowerCase();
        chars=str1.toCharArray();
        Arrays.sort(chars);
        str1=new String(chars);
        System.out.println(str1);

        //swap pairs of characters in String
        //Bakery => aBekyr
        str1="Bakery";
        chars=str1.toCharArray();
        char temp1;
        N=str1.length();
        for(int i=0;i<=N-2;i++,i++)
        {
            temp1=chars[i];
            chars[i]=chars[i+1];
            chars[i+1]=temp1;
        }
        str1=new String(chars);
        System.out.println(str1);

        //using append
        str1="Bakerys";
        N=str1.length();
        Boolean isLengthOdd=N%2!=0;
        StringBuilder sb2=new StringBuilder(N);
        for(int i=0;i<=N-2;i+=2)
        {
            sb2.append(str1.charAt(i+1));
            sb2.append(str1.charAt(i));
        }
        if(isLengthOdd)
            sb2.append(str1.charAt(N-1));
        System.out.println(sb2);

        //is a String pangram
        //a pangram contains all alphabets A-Z irrespective of string
        str1="AbcdefghijklMMMnopqrstuvVVVwxyz";
        str1=str1.toUpperCase();
        boolean isPangram=Boolean.TRUE;
        for(char ch='A';ch<='Z';ch++)
        {
            if(!str1.contains(ch+""))
            {
                isPangram=Boolean.FALSE;
                break;
            }
        }
        if(isPangram)
            System.out.println("The String "+str1+" is a pangram");

        //get second letter of every word in a string
        str1="Alice in wondrous WOnderland";
        parts=str1.split("\\s");
        N=parts.length;
        sb2=new StringBuilder();
        for(int i=0;i<=N-1;i++)
        {
           // sb2.append(parts[i].charAt(0));//for first letter
            sb2.append(parts[i].charAt(1));
        }
        System.out.println(sb2);

        //Remove leading zeroes from a String
        str1="000000100000100000101000";
        int leadingZeroCount=0;
        N=str1.length();
        for(int i=0;i<=N-1;i++)
        {
            if(str1.charAt(i)=='0')
            {
                leadingZeroCount+=1;
            }
            else
            {
                break;
            }
        }
        //replace
        str2=str1.substring(leadingZeroCount,N-1);
        System.out.println("String before removal of leading zeros="+str1+"\nand after removing leading zeroes="+str2);

        //Remove Trailing zeroes
        str1="120000110020000";
        N=str1.length();
        //count trailing zeroes
        int trailingZeroCount=0;
        for(int i=N-1;i>=0;i--)
        {
            if(str1.charAt(i)=='0')
            {
                trailingZeroCount++;
            }
            else
            {
                break;
            }
        }
        str2=str1.substring(0,((N-1)-trailingZeroCount)+1);
        System.out.println("Substring before removing trailing zeroes="+str1+"\nafter removal of trailing zeroes="+str2);
    }

}
