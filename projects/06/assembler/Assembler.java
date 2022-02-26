import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class Assembler {
    
    public static void main(String[] args) throws FileNotFoundException{
        String file = args[0];
        String hackFormat = file.replaceAll(".asm", ".hack");

        Parser parser = new Parser(file);
        ArrayList<String> instructions = parser.getInstructions();      //instructions with unedited symbols
        
        Symbol symbols = new Symbol(instructions);          //producing symbols
        symbols.mapLabel();                                 //label symbols                   
        symbols.mapVariable();                              //variable symbols

        ArrayList<String> symbolLessInstructions = symbols.getInstructions();      //instructions with edited symbols

        Map<String, String> testing = symbols.getSymbols();             //all symbols

        // System.out.println(testing);        
        // PrintWriter keys = new PrintWriter("keys.log");
        // for(String address: testing.keySet()){
        //     keys.println(address + "\t\t: " + testing.get(address));
        // }
        // keys.close();
        // System.out.println(instructions);
        // System.out.println("symbol less\n\n" + symbolLessInstructions);

        Code code = new Code(symbolLessInstructions, testing);
        code.produce();

        // System.out.print(code);
        ArrayList<String> codes = code.getCodes();
        PrintWriter writer = new PrintWriter(hackFormat);
        for(int i = 0; i < codes.size(); i++){
            writer.println(codes.get(i));
        }
        writer.close();

    }

}
