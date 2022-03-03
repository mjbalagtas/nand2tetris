public class Command {
    private String command;
    private CommandType commandType;
    private int commandLine;

    public Command(int commandLine,String command, CommandType commandType){
        this.commandLine = commandLine;
        this.command = command;
        this.commandType = commandType;
    }

    public int getCommmandLine(){
        return commandLine;
    }

    public String getCommand(){
        return this.command;
    }

    public CommandType getCommandType(){
        return this.commandType;
    }

    public String getArgument1(){
        if(this.commandType == CommandType.C_RETURN){
            return "";
        }else if(this.commandType == CommandType.C_ARITHMETIC){
            return this.command;
        }
        String[] args = command.split(" ");
        return args[1];
        // return command.trim().replaceAll(".+(?)\\s|[0-9]", "");
    }

    public int getArgument2(){
        if(this.commandType == CommandType.C_PUSH || this.commandType == CommandType.C_POP
        || this.commandType == CommandType.C_FUNCTION || this.commandType == CommandType.C_CALL){
            String temp = this.command.replaceAll("\\s|[^0-9]", "");
            return Integer.valueOf(temp);
        }
        return -1;
    }
}
