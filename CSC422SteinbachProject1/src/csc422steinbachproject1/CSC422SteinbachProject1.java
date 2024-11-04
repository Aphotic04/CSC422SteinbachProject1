
package csc422steinbachproject1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CSC422SteinbachProject1 {

    static void addPets(ArrayList<Pet> pets, Scanner scnr) {
        scnr.nextLine();
        String input;
        String name;
        int age;
        while(true) {
            Pet pet = new Pet();
            System.out.println("add pet (name, age):");
            
            input = scnr.nextLine();
            String[] inputArray = input.split(" ");
            name = inputArray[0];
            if (!name.equalsIgnoreCase("done")) {
                age = Integer.parseInt(inputArray[1]);
                pet.setName(name);
                pet.setAge(age);
                pets.add(pet);
            }
            else {
                break;
            }
            
        }
        
        
    }
    
    static void searchName(ArrayList<Pet> pets, Scanner scnr) {
        ArrayList<Pet> petsNames = new ArrayList<>();
        String input;
        System.out.println("Enter name to search");
        input = scnr.next();
        Pet current;
        for(int i = 0; i < pets.size(); i++) {
            current = pets.get(i);
            if (current.getName().equalsIgnoreCase(input)) {
                petsNames.add(current);
            }
        }
        printPets(petsNames);
    }
    
    static void searchAge(ArrayList<Pet> pets, Scanner scnr) {
        try {
            ArrayList<Pet> petsAges = new ArrayList<>();
            int input;
            System.out.println("Enter age to search");
            input = scnr.nextInt();
            Pet current;
            for(int i = 0; i < pets.size(); i++) {
                current = pets.get(i);
                if (current.getAge() == input) {
                    petsAges.add(current);
                }
            }
            printPets(petsAges);
        }
        catch(InputMismatchException e) {
            System.out.println(e);
        }
    }
    
    static void printPets(ArrayList<Pet> pets) {
        String line = "+----------------------+";
        System.out.println(line + "\n| ID | NAME      | AGE |\n" + line);
        int i = 0;
        for (i = 0; i < pets.size(); i++) {
            System.out.printf("|%3d |%10s |%4d |\n", i, pets.get(i).getName(), pets.get(i).getAge());
        }
        System.out.println(line + "\n" + i + " rows in set.");
    }
    
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        Scanner scnr = new Scanner(System.in);
        int input = 0;
        while (input != 5) {
            System.out.println("""
                           Pet Database Program
                           1) View all pets
                           2) Add more Pet
                           3) Search pets by name
                           4) Search pets by age
                           5) Exit
                           """);
            try {
                input = scnr.nextInt();
                switch(input) {
                    case(1) -> printPets(pets);
                    case(2) -> addPets(pets, scnr);
                    case(3) -> searchName(pets, scnr);
                    case(4) -> searchAge(pets, scnr);
                }
            }
            catch(InputMismatchException e) {
                System.out.println(e);
                scnr.nextInt();
            }
        }
        
    }
    
}
