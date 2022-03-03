import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class VMTranslator{

    public static void main(String[] args) throws FileNotFoundException{

        String file = args[0];
        Parser vm = new Parser(file);

        String codeFile = file.replaceAll(".vm", ".asm");

        vm.create();
        List<Command> vmCodes = vm.getVM();
        // System.out.println(vmCodes);
        CodeWriter writer = new CodeWriter(codeFile);
        for(Command command: vmCodes){
            if(command.getCommandType() == CommandType.C_ARITHMETIC){
                writer.writeArithmetic(command.getArgument1());
            }else{
                writer.writePushPop(command.getCommandType(), command.getArgument1(), command.getArgument2());
            }
            System.out.println(command.getCommand());
            // System.out.println("argument1: " + command.getArgument1() + ": argument2: " + command.getArgument2());
            // System.out.println("--ARRAY--");
            writer.printArr();
            System.out.println("");
        }
        writer.close();

    }
}