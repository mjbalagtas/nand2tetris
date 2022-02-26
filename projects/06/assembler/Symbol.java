import java.util.Map;

import java.util.HashMap;
import java.util.ArrayList;

public class Symbol {
    private Map <String, String> symbols;
    private ArrayList<String> symbolic;
    private ArrayList<String> symbolLess;

    public Symbol(ArrayList<String> symbolic){
        this.symbols = new HashMap<>();
        this.symbolic = symbolic;
        this.symbolLess = new ArrayList<>();

        //BUILT-IN SYMBOLS
        symbols.put("@R0", "@0");
        symbols.put("@R1", "@1");
        symbols.put("@R2", "@2");
        symbols.put("@R3", "@3");
        symbols.put("@R4", "@4");
        symbols.put("@R5", "@5");
        symbols.put("@R6", "@6");
        symbols.put("@R7", "@7");
        symbols.put("@R8", "@8");
        symbols.put("@R9", "@9");
        symbols.put("@R10", "@10");
        symbols.put("@R11", "@11");
        symbols.put("@R12", "@12");
        symbols.put("@R13", "@13");
        symbols.put("@R14", "@14");
        symbols.put("@R15", "@15");
        symbols.put("@SCREEN", "@16384");
        symbols.put("@KBD", "@24576");
        symbols.put("@SP", "@0");
        symbols.put("@LCL", "@1");
        symbols.put("@ARG", "@2");
        symbols.put("@THIS", "@3");
        symbols.put("@THAT", "@4");
    }

    // 1.FINDS LABEL. THE LABEL IS SAVED TO A NEW STRING DATA TYPE.
    // 2.THE LABEL IS REMOVED INSIDE THE ARRAYLIST(symbolic).
    // 3. THE NEW STRING FOR LABEL IS FORMATTED AND PUT INSIDE A HASHMAP(symbols)
    public void mapLabel(){
        int i = 0;
        while(i < symbolic.size()){
            String line = symbolic.get(i).trim();
            if(line.startsWith("(") && line.endsWith(")")){
                System.out.println("LABEL: " + line);
                symbolic.remove(line);
                line = line.replaceAll("[()]", "");
                line = "@" + line;
                System.out.println("LABEL edited: " + line);
                System.out.println("address: " + i);
                String value = "@" + String.valueOf(i);
                symbols.put(line,value);
                continue;
            }
            i++;
        }
    }


    // 1. LINES THAT START WITH @ AND DOESN'T CONTAIN A NUMBER IS ADDED TO THE HASHMAP(symbols)
    public void mapVariable(){
        int n = 16;
        for(int i = 0; i < symbolic.size(); i++){
            String line = symbolic.get(i).trim();
            if(!(symbols.containsKey(line)) && line.matches("@[^0-9].+")){
                String value = "@" + String.valueOf(n);
                symbols.put(line,value);
                n++;
            }
        }
    }

    public Map<String, String> getSymbols(){
        return this.symbols;
    }

    public ArrayList<String> getInstructions(){
        ArrayList<String> instructions = new ArrayList<>();
        for(int i = 0; i < symbolic.size(); i++){
            if(this.symbols.containsKey(symbolic.get(i).trim())){
                instructions.add(this.symbols.get(symbolic.get(i)));
            }else{
                instructions.add(symbolic.get(i));
            }    
        }
        return instructions;
    }

    public String toString(){
        
        String print = "symbol\t|\tvalue\n";
        for(String symbol: getSymbols().keySet()){
            print = symbol + "\t|\t" + getSymbols().get(symbol) + "\n";
        }
        return print;
    }
}
