import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Paths;

public class Parser {
    private List<Command> vm;
    private String file;

    public Parser(String file){
        this.file = file;
        this.vm = new ArrayList<>();
    }

    public List<Command> getVM(){
        return this.vm;
    }

    //CREATE the VM commands available without empty lines and comments
    public void create(){
        try(Scanner scanner = new Scanner(Paths.get(this.file))){
            int line = 0;

            while(scanner.hasNextLine()){
                String row = scanner.nextLine().trim();
                if(row.startsWith("//") || row.isEmpty()){
                    continue;
                }
                row = row.replaceAll("\\s\\s|//.+(?)", "");
                row = row.trim();
                if(!(row.contains(" "))){
                    vm.add(new Command(line, row,CommandType.C_ARITHMETIC));
                }else if(row.contains("push")){
                    vm.add(new Command(line, row,CommandType.C_PUSH));
                }else if(row.contains("pop")){
                    vm.add(new Command(line, row,CommandType.C_POP));
                }else if(row.contains("label")){
                    vm.add(new Command(line, row,CommandType.C_LABEL));
                    continue;
                }
                else if(row.contains("if-goto")){
                    vm.add(new Command(line, row,CommandType.C_IF));
                }else if(row.contains("goto")){
                    vm.add(new Command(line ,row,CommandType.C_GOTO));
                }
                // vm.add(row);
                line++;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        String toReturn = "/n/n   VM codes starts here \n\n";
        for(int i = 0; i < this.vm.size(); i++){
            toReturn = toReturn + this.vm.get(i).getCommmandLine() + "\t" + this.vm.get(i).getCommand() + "\n";
        }
        return toReturn;
    }
}
