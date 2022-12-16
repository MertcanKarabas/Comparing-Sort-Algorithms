package algoritmaprojesi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
/**
 *
 * @author mertcankarabas
 * @mail mertcan.karabas@stu.fsm.edu.tr
 * @studentNo 1921221025
 *
 */

public class Main {

    static SelectionSort ss = new SelectionSort();
    static InsertionSort is = new InsertionSort();
    static MergeSort ms = new MergeSort();
    static HeapSort hs = new HeapSort();
    static L_QuickSort lqs = new L_QuickSort();
    static H_QuickSort hqs = new H_QuickSort();

    //Calculating...
    static void cal(int arr[]) {
        
        String names[] = {"Selection", "Insertion", "Merge", "Heap", "Lomuto Quick", "Hoare Quick"};
        try {
                   
            FileWriter fWriter = new FileWriter("output.txt", true);
            for (int i = 0; i < 6; i++) { //0:ss, 1:is, 2:ms, 3:hs, 4:lqs, 5:hqs
                int cloneArr[] = arr.clone();

                System.out.println("value hesaplanıyor...");
                int value = (40 - (15 + names[i].length()) - 2) / 2; //The value that shows how many spaces we should leave for star box.
                fWriter.write("*");
                
                for (int j = 0; j < value; j++) 
                    fWriter.write(" ");               
                
                fWriter.write("Starting " + names[i] + " Sort:");

                value = 40 - (value + 15 + names[i].length() + 1);

                for (int j = 0; j < value - 1; j++) 
                    fWriter.write(" ");               
                
                fWriter.write("*\n");
                System.out.println("hesaplama bitti");
                long startTime; //Getting time before sorting algorithm
                System.out.println("sortlar başlıyor..");

                if (i == 0) {
                    System.out.println("Selection Sort Başladı.");
                    startTime = System.currentTimeMillis();
                    ss.sort(cloneArr);
                } else if (i == 1) {
                    System.out.println("Insertion Sort Başladı.");
                    startTime = System.currentTimeMillis();
                    is.sort(cloneArr);
                } else if (i == 2) {
                    System.out.println("Merge Sort Başladı.");
                    startTime = System.currentTimeMillis();
                    ms.sort(cloneArr, 0, cloneArr.length - 1);
                } else if(i == 3){
                    System.out.println("Heap Sort Başladı.");
                    startTime = System.currentTimeMillis();
                    hs.sort(cloneArr);
                } else if (i == 4) {
                    System.out.println("Lomuto Quick Sort Başladı.");
                    startTime = System.currentTimeMillis();
                    lqs.sort(cloneArr, 0, (cloneArr.length - 1));
                } else {
                    System.out.println("Horae Quick Sort Başladı.");
                    startTime = System.currentTimeMillis();
                    hqs.sort(cloneArr, 0, (cloneArr.length - 1));
                }
                
                System.out.println("sort bitti...");
                
                long endTime = System.currentTimeMillis(); // Getting time after sorting algorithm
                long duration = endTime - startTime; //Elapsed Time
                System.out.println("value hesaplanıyor...");
                
                int lengthOfNumber = numberLength(duration);
                value = ((40 - (16 + lengthOfNumber)) - 2) / 2;
                fWriter.write("*");
        
                for (int j = 0; j < value; j++) 
                    fWriter.write(" ");
                               
                fWriter.write("Duration in ms: " + duration);
                if (lengthOfNumber % 2 == 0) {
                    for (int j = 0; j < value; j++) 
                        fWriter.write(" ");
                    
                } else {
                    for (int j = 0; j < value + 1; j++) {
                        fWriter.write(" ");
                    }
                }
                
                System.out.println("value bitti...");
                fWriter.write("*\n");
                fWriter.write("*                                      *\n");
            }
            
            fWriter.close();
            
        } catch (Exception e) {
            // Print the exception
            System.out.print(e.getMessage());
        }
    }

    static void randomFillArray(int arr[], int number) {
        
        for (int i = 0; i < arr.length; i++) 
            arr[i] = (int) (Math.random() * number);      
    }

    static void fillMinToMaxArray(int arr[]) {
        
        for (int i = 0; i < arr.length; i++) 
            arr[i] = i + 1;     
    }

    static void fillMaxToMinArray(int arr[]) {
        
        int number = arr.length;
        for (int i = 0; i < arr.length; i++) 
            arr[i] = number--; 
    }

    static void printArray(int arr[]) {
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 10 == 0) 
                System.out.println();            
        }
        System.out.println();
    }

    static int numberLength(long number) {
        
        int count = 0;
        if (number == 0) 
            return 1;
    
        while (number > 0) {
            number = number / 10;
            count++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        
        try {
            
        FileWriter fWriter = new FileWriter("output.txt", false);
        fWriter.write("****************************************\n");
        fWriter.write("*                                      *\n");
        fWriter.close();
        //Random Array Sorting
        
        String arrayTypeNames[] = {"Random", "MinMax", "MaxMin"};
                   
            for (int j = 0; j < 3; j++) {
                
                // Create a FileWriter object
                // to write in the file
                fWriter = new FileWriter("output.txt", true);
                fWriter.write("*    ~~~~~~~~ " + arrayTypeNames[j] + " Array ~~~~~~~~    *\n");
                fWriter.write("*                                      *\n");
                fWriter.close();
                // Printing the contents of a file
                //1: 10, 2: 50, 3: 100, 4: 500, 5: 1000, 6: 5000, 7: 10000, 8: 50000, 9: 100000, 10: 500000, 11: 1000000
                for (int i = 0; i < 11; i++) { 
                    System.out.println("döngü başlıyor...");
                    fWriter = new FileWriter("output.txt", true);
                    
                    int lengthOfNumber = numberLength(i);
                    int value = ((40 - (27 + lengthOfNumber)) - 2) / 2;
                    fWriter.write("*");
        
                    for (int k = 0; k < value; k++) 
                        fWriter.write(" ");
                    
                    fWriter.write("-------- " + i + ". Sorting --------");
                    if (lengthOfNumber % 2 == 0) {
                        for (int k = 0; k < value + 1; k++) 
                            fWriter.write(" ");
                    
                    } else {
                        for (int k = 0; k < value; k++) {
                            fWriter.write(" ");
                        }
                    }
                    fWriter.write("*\n");
                    fWriter.write("*                                      *\n");
                    
                    int arrayLength[] = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
                    int length = arrayLength[i];
                    int arr[] = new int[length];
                    
                    System.out.println("array dolduruluyor.");                   
                    if (j == 0) 
                        randomFillArray(arr, 1000000);
                    else if (j == 1) 
                        fillMinToMaxArray(arr);
                    else 
                        fillMaxToMinArray(arr);            
                    System.out.println("array doldurma bitti");
                    
                    fWriter.close();
                    cal(arr);
                    System.out.println("hesaplama bitti.");
                }

                // Closing the file writing connection
                // Display message for successful execution of
                // program on the console
                System.out.println("File is created successfully with the content.");
                
            } // Catch block to handle if exception occurs
            
            fWriter = new FileWriter("output.txt", true);
            fWriter.write("****************************************\n");
            fWriter.close();
            System.out.println("GÖREV BAŞARILI ASKER");
            
        } catch (IOException e) {
            // Print the exception
            System.out.print(e.getMessage());
        }
    }
}
