
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
            scnr.next();
        }
    }
    
    static void updatePet(ArrayList<Pet> pets, Scanner scnr) {
        try {
            Pet petUpdate;
            String input;
            String name;
            int age;
            
            printPets(pets);
            System.out.println("Enter the pet ID you want to update: ");
            petUpdate = pets.get(scnr.nextInt());
            System.out.println("Enter new name and new age: ");
            
            scnr.nextLine();
            input = scnr.nextLine();
            String[] inputArray = input.split(" ");
            name = inputArray[0];
            age = Integer.parseInt(inputArray[1]);
            
            System.out.print(petUpdate + " changed to ");
            petUpdate.setName(name);
            petUpdate.setAge(age);
            System.out.println(petUpdate);
        }
        catch(InputMismatchException e) {
            System.out.println(e);
            scnr.next();
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
       
        
    }
    
    static void removePet(ArrayList<Pet> pets, Scanner scnr) {
        try {
            Pet petRemove;
            int input;
            printPets(pets);
            System.out.println("Enter the pet ID you want to remove: ");
            input = scnr.nextInt();
            petRemove = pets.get(input);
            pets.remove(input);
            System.out.println(petRemove + " is removed");
        }
        catch(InputMismatchException e) {
            System.out.println(e);
            scnr.next();
        }
        catch(IndexOutOfBoundsException e) {
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
        while (input != 7) {
            System.out.println("""
                           Pet Database Program
                           1) View all pets
                           2) Add more Pet
                           3) Update existing pet
                           4) Remove existing pet
                           5) Search pets by name
                           6) Search pets by age
                           7) Exit
                           """);
            try {
                input = scnr.nextInt();
                switch(input) {
                    case(1) -> printPets(pets);
                    case(2) -> addPets(pets, scnr);
                    case(3) -> updatePet(pets, scnr);
                    case(4) -> removePet(pets, scnr);
                    case(5) -> searchName(pets, scnr);
                    case(6) -> searchAge(pets, scnr);
                    
                }
            }
            catch(InputMismatchException e) {
                System.out.println(e);
                scnr.nextInt();
            }
        }
        
    }
    
}
