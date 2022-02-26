//  1. READ .asm file
//  2. IGNORE WHITESPACE
//  3. 


import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Parser{
    private String file;
    private ArrayList<String> instructions;

    public Parser(String file){
        this.file = file;
        this.instructions = new ArrayList<>();
    }

    private void clean(){
        try (Scanner scanner = new Scanner(Paths.get(file))) {

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if(row.isEmpty() || row.startsWith("//")){
                    continue;
                }
                row = row.replaceAll("\\s+", "");
                row = row.replaceAll("[//].*(?)", "");
                this.instructions.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean aInstruction(String line){
        return line.startsWith("@");
    }

    public ArrayList<String> getInstructions(){
        clean();
        return this.instructions;
    }
}