import java.util.ArrayList;
import java.util.Map;

public class Code {
    ArrayList<String> codes;
    ArrayList<String> symbolic;
    Map<String,String> symbols;

    public Code(ArrayList<String> symbolic){
        this.symbolic = symbolic;
        codes = new ArrayList<>();
    }

    public Code(ArrayList<String> symbolic, Map<String,String> symbols){
        this.symbolic = symbolic;
        codes = new ArrayList<>();
        this.symbols = symbols;
    }

    public ArrayList<String> getCodes(){
        return codes;
    }

    public void produce(){
        System.out.println("symbols: " + symbols);
        for(int i = 0; i < symbolic.size(); i ++){
            String line = symbolic.get(i);
            String bin = "";
            System.out.println("key: " +  line);
            if(line.startsWith("@")){
                if(symbols.containsKey(line.trim())){
                    String value = symbols.get(line);
                    value = value.replace("@","");
                    System.out.println("value: " + value);
                    int dec = Integer.valueOf(value);
                    bin = address(dec);
                }else{
                    String value = line.replace("@","");
                    System.out.println("value: " + value);
                    int dec = Integer.valueOf(value);
                    bin = address(dec);
                }
            }else{
                String comp = line;
                String dest = "";
                String jump = "";

                if(line.contains("=")){
                    dest = line.replaceAll("=.*(?)", "");
                    comp = comp.replaceAll(".*(?)=", "");
                }
                if(line.contains(";")){
                    jump = line.replaceAll(".*(?);","");
                    comp = comp.replaceAll(";.*(?)", "");
                }
                
                // System.out.println(line+ ":" + comp + ": " + dest + ": " + jump);
                String compBin = comp(comp);
                String destBin = dest(dest);
                String jumpBin = jump(jump);

                bin = "111" + compBin + destBin + jumpBin;
            }
            // System.out.println(bin);
            codes.add(bin);
        }
    }


    public String address(int address){
        String bin = Integer.toBinaryString(address);
        String zeroes = "";
        for(int i = 0;i < (16 - bin.length()); i++){
            zeroes += "0";
        }
        return zeroes + bin;
    }

    public String comp(String comp){
        String main = "";
        if(comp.contains("M")){
            main = "1";
        }else if(comp.contains("A")){
            main = "0";
        }
        if(comp.matches("D\\|[MA]") || comp.matches("[MA]\\|D")){
            main += "010101";
        }else if(comp.matches("D&[MA]") || comp.matches("[MA]&D")){
            main += "000000";
        }else if(comp.matches("[MA]-D")){
            main += "000111";
        }else if(comp.matches("D-[MA]")){
            main += "010011";
        }else if(comp.matches("D\\+[MA]") || comp.matches("[MA]\\+D")){
            main += "000010";
        }else if(comp.matches("[MA]-1")){
            main += "110010";
        }
        else if(comp.matches("D-1")){
            main = "0001110";
        }else if(comp.matches("[MA]\\+1") || comp.matches("1\\+[MA]")){
            main += "110111";
        }else if(comp.matches("D\\+1") || comp.matches("1\\+D")){
            main = "0011111";
        }else if(comp.matches("-[MA]")){
            main += "110011";
        }else if(comp.matches("-D")){
            main = "0001111";
        }else if(comp.matches("![MA]")){
            main += "110001";
        }else if(comp.matches("!D")){
            main = "0001101";
        }else if(comp.matches("[MA]")){
            main += "110000";
        }else if(comp.matches("D")){
            main = "0001100";
        }else if(comp.matches("-1")){
            main = "0111010";
        }else if(comp.matches("1")){
            main = "0111111";
        }else if(comp.matches("0")){
            main = "0101010";
        }
        return main;
    }

    public String dest(String dest){
        StringBuilder destBin = new StringBuilder("000");
        if(dest.contains("M")){
            destBin.setCharAt(2, '1');
        }
        if(dest.contains("D")){
            destBin.setCharAt(1, '1');
        }
        if(dest.contains("A")){
            destBin.setCharAt(0, '1');
        }
        return destBin.toString();
    }

    public String jump(String jump){
        if(jump.equals("JGT")){
            return "001";
        }else if(jump.equals("JEQ")){
            return "010";
        }else if(jump.equals("JGE")){
            return "011";
        }else if(jump.equals("JLT")){
            return "100";
        }else if(jump.equals("JNE")){
            return "101";
        }else if(jump.equals("JLE")){
            return "110";
        }else if(jump.equals("JMP")){
            return "111";
        }
        return "000";
    }

    public String toString(){
        String print = "symbolic\t|machine code\n";
        for(int i = 0; i < getCodes().size(); i++){
            print += symbolic.get(i) + "\t:\t" + getCodes().get(i) + "\n";
        }
        return print;
    }
}
