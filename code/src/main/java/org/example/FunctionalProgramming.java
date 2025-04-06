package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.swing.text.html.HTML.Attribute.N;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numbers=List.of(1,2,3,279,-943,28,79,127,289);

        //display all numbers
        numbers.stream().forEach(FunctionalProgramming::printNum);
        System.out.println();

        //display all numbers
        numbers.stream().forEach(System.out::print);
        System.out.println();

        //display only even numbers
        numbers.stream().filter(FunctionalProgramming::isEven).forEach(X->System.out.print(X+"\t"));
        System.out.println();

        //display only even numbers
        numbers.stream().filter(X->X%2==0).forEach(N->System.out.print(N+" "));
        System.out.println();

        //display only odd numbers
        numbers.stream().filter(P->P%2!=0).forEach(M->System.out.print(M+"  "));
        System.out.println();

        //print square of evn numbers
        numbers.stream().filter(N->N%2==0).map(Num->Math.pow(Num,2)).forEach(Sqr->System.out.print(Sqr+"  "));
        System.out.println();

        //print squares of even as int not double
        numbers.stream().filter(N->N%2==0).map(N->(int)(Math.pow(N,2))).forEach(P->System.out.print(P+"  "));
        System.out.println();

        //print cubes of odd numbers as double
        numbers.stream().filter(N->N%2!=0).map(Num->Math.pow(Num,3)).forEach(Cube->System.out.print(Cube+"  "));
        System.out.println();

        //print cubes of all even numbers as int
        numbers.stream().filter(X->X%2!=0).map(Num->(int)(Math.pow(Num,3))).forEach(M->System.out.print(M+"  "));
        System.out.println();

        List<String>books=List.of("Head First Java","Head First Python","Head First SQL","Northanger Abbey","Pride and Prejudice");

        //print all books
        books.stream().forEach(book->System.out.print(book+"  "));
        System.out.println();

        //print books having Head First in them
        books.stream().filter(book->book.toUpperCase().trim().contains("HEAD FIRST")).forEach(bookName->System.out.print(bookName+"  "));
        System.out.println();

        //print length of all books not having Head First in them
        books.stream().filter(bookName->!(bookName.toLowerCase().trim().contains("head first")))
                .map(bookName->bookName.length()).forEach(length->System.out.print("Length is "+length+"  "));
        System.out.println();

        //print all books whose name has length at least 17
        books.stream().filter(bookName->bookName.length()>=17)
                .forEach(bookName->System.out.print(bookName+"  "));
        System.out.println();


        //return List of cubes of odd numbers
        List<Integer>nums=numbers.stream().filter(X->X%2!=0).map(Num->(int)(Math.pow(Num,3)))
                .collect(Collectors.toList());
        System.out.println(nums);

        //return set of unique numbers
        numbers=List.of(11,11,11,11,11,22,33,22,33,22,33,22,22,22,44,44,44,44,55,44,55,44,55);
        Set<Integer>unique=numbers.stream().collect(Collectors.toSet());
        System.out.println(unique);

        //return list of even number squares
        List<Integer> numberSquares=numbers.stream().filter(Num->Num%2==0)
                .map(X->(int)(Math.pow(X,2)))
                .collect(Collectors.toList());
        System.out.println(numberSquares);

    }

    static void printNum(final int n)
    {
        System.out.print(n+"\t");
    }

    //filter methods must return boolean
    static boolean isEven(final int n)
    {
        return n%2==0;
    }
}
