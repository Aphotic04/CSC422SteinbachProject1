
package csc422steinbachproject1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CSC422SteinbachProject1 {
    static ArrayList<Pet> pets = new ArrayList<>();

    static void addPets(Scanner scnr) {
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
    
    static void printPets() {
        String line = "+----------------------+";
        System.out.println(line + "\n| ID | NAME      | AGE |\n" + line);
        int i = 0;
        for (i = 0; i < pets.size(); i++) {
            System.out.printf("|%3d |%10s |%4d |\n", i, pets.get(i).getName(), pets.get(i).getAge());
        }
        System.out.println(line + "\n" + i + " rows in set.");
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int input = 0;
        while (input != 3) {
            System.out.println("""
                           Pet Database Program
                           1) View all pets
                           2) Add more Pet
                           3) Exit
                           """);
            try {
                input = scnr.nextInt();
                switch(input) {
                    case(1) -> printPets();
                    case(2) -> addPets(scnr);
                }
            }
            catch(InputMismatchException e) {
                System.out.println(e);
                scnr.nextInt();
            }
        }
        
    }
    
}
