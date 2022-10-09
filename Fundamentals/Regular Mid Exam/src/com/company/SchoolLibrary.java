package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> books= Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String [] action=scanner.nextLine().split(" \\| ");
        String bookName="";
        int index=0;
        while (!action[0].equals("Done")){
            String command=action[0];
            if(command.equals("Check Book")){
                index=Integer.parseInt(action[1]);
            }else {
                 bookName=action[1];
            }
//Don Quixote&The Great Gatsby&Moby Dick
//Add Book | Ulysses
//Take Book | Don Quixote
//Insert Book | pod igot
//Done
            switch (command){
                case "Add Book":
                    if(!books.contains(bookName)){
                        books.add(0,bookName);
                    }
                    break;
                case "Take Book":
                    books.remove(bookName);
                    break;
                case "Swap Books":
                    String secondBookName=action[2];
                    int indexFirstBook=0;
                    int indexSecondBook=0;
                    if(books.contains(bookName)&&books.contains(secondBookName)){
                        for(int i=0;i<books.size();i++){
                            if(books.get(i).equals(bookName)){
                                indexFirstBook=i;
                            }
                            if(books.get(i).equals(secondBookName)){
                                indexSecondBook=i;
                            }
                        }
                        Collections.swap(books,indexFirstBook,indexSecondBook);
                    }
                    break;
                case "Insert Book":
                    if(!books.contains(bookName)){
                        books.add(bookName);
                    }
                    break;
                case "Check Book":
                    if(index>=0&&index<books.size()){
                        System.out.println(books.get(index));
                    }
                    break;
            }

            action=scanner.nextLine().split(" \\| ");
        }
        System.out.print(books.get(0));
        for(int i=1;i<books.size();i++){
            System.out.print(", "+books.get(i));
        }
    }
}
