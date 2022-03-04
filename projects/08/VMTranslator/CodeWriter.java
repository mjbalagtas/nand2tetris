import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter {
    private PrintWriter writer;
    private int eq;
    private int gt;
    private int lt;

    public CodeWriter(String fileName) throws FileNotFoundException{
        this.writer = new PrintWriter(fileName);
        this.eq = 0;
        this.gt = 0;
        this.lt = 0;
    }

    public void writeArithmetic(String command){
        if(command.equals("add")){
            this.add();
        }else if(command.contains("sub")){
            this.writer.println("//sub command");
            this.subtract();
        }else if(command.contains("neg")){
            this.writer.println("//neg command");
            this.neg();
        }else if(command.contains("eq")){
            this.writer.println("//eq command");
            this.eq(this.eq);
            this.eq++;
        }else if(command.contains("gt")){
            this.writer.println("//gt command");
            this.get(this.gt);
            this.gt++;
        }else if(command.contains("lt")){
            this.writer.println("//lt command");
            this.lt(this.lt);
            this.lt++;
        }else if(command.contains("and")){
            this.writer.println("//and command");
            this.and();
        }else if(command.contains("or")){
            this.writer.println("//or command");
            this.or();
        }else if(command.contains("not")){
            this.writer.println("//not command");
            this.not();
        }
    }

    public void writePushPop(CommandType commandType, String segment, int index){

        if(commandType == CommandType.C_PUSH){
            if(segment.contains("local")){
                this.pusher( "LCL", index);
            }else if(segment.contains("arg")){
                this.pusher( "ARG", index);
            }else if(segment.contains("this")){
                this.pusher( "THIS", index);
            }else if(segment.contains("that")){
                this.pusher( "THAT", index);
            }else if(segment.contains("temp")){
                this.pushTempStatic(5 + index);
            }else if(segment.contains("static")){
                this.pushTempStatic( 16 + index);
            }else if(segment.contains("pointer")){
                this.pushPointer(index);
            }else if(segment.contains("constant")){
                this.pushConstant(index);
            }
        }
        else if (commandType == CommandType.C_POP){
            if(segment.contains("local")){
                this.popper( "LCL", index);
            }else if(segment.contains("arg")){
                this.popper( "ARG", index);
            }else if(segment.contains("this")){
                this.popper( "THIS", index);
            }else if(segment.contains("that")){
                this.popper( "THAT", index);
            }else if(segment.contains("temp")){
                this.popTempStatic(5 + index);
            }else if(segment.contains("static")){
                this.popTempStatic(16 + index);
            }else if(segment.contains("pointer")){
                this.popPointer(index);
            }
        }
    }

    public void writeLabel(String label){
        this.writer.println("(" + label + ")");
    }


    public void writeGoto(String label){
        this.writer.println("@" + label);
        this.writer.println("0;JMP");
    }

    public void WriteIf(String label){
        this.popper("ARG", 0);
        this.writer.println("@" + label);
        this.writer.println("D;JNE");
    }

    public void add(){
        this.writer.println("//add command");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D+M");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@SP");
        this.writer.println("M=M+1");
    }

    public void subtract(){
        this.writer.println("//sub command");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D-M");
        this.writer.println("D=-D");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@SP");
        this.writer.println("M=M+1");

    }

    public void neg(){

        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=-M");

        this.writer.println("@0");
        this.writer.println("M=M+1");

    }

    public void eq(int eq){

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D-M");

        this.writer.println("@EQUAL$" + eq);
        this.writer.println("D;JEQ");
        this.writer.println("D=0");
        this.writer.println("(SET_EQUAL$" + eq +")");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");
        this.writer.println("@SP");
        this.writer.println("M=M+1");

    }

    public void get(int gt){

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D-M");

        this.writer.println("@GREATER$" + gt);
        this.writer.println("D;JLT");
        this.writer.println("D=0");
        this.writer.println("(SET_GREATER$" + gt +")");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");
        this.writer.println("@SP");
        this.writer.println("M=M+1");
    }

    public void lt(int lt){

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");


        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D-M");

        this.writer.println("@LESSER$" + lt);
        this.writer.println("D;JGT");
        this.writer.println("D=0");
        this.writer.println("(SET_LESSER$" + lt +")");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");
        this.writer.println("@SP");
        this.writer.println("M=M+1");
    }

    public void and(){
        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=D&M");
        this.writer.println("@SP");
        this.writer.println("M=M+1");

    }

    public void or(){


        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=D|M");
        this.writer.println("@SP");
        this.writer.println("M=M+1");

    }

    public void not(){
        this.writer.println("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=!M");
        this.writer.println("@SP");
        this.writer.println("M=M+1");
    }

    public void popper(String memory, int index){
        setAddr(memory, index);
        this.writer.println("@13");
        this.writer.println("M=D");

        this.writer.println("@SP");
        this.writer.println("AM=M-1");
        this.writer.println("D=M");

        this.writer.println("@13");
        this.writer.println("A=M");
        this.writer.println("M=D");
    }

    public void popTempStatic(int location){

        this.writer.println("@SP");
        this.writer.println("AM=M-1");
        this.writer.println("D=M");

        this.writer.println("@" + location);
        this.writer.println("M=D");
    }

    public void setAddr(String memory, int index){
        this.writer.println("@" + memory);
        this.writer.println("D=M");
        this.writer.println("@" + index);
        this.writer.println("AD=D+A");
    }


    public void pusher(String memory, int index){
        //this.writer.println("@" + (this.memory.get(memory) + index));
        setAddr(memory, index);
        this.writer.println("A=D");
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@SP");
        this.writer.println("M=M+1");
    }

    public void pushTempStatic(int location){
        this.writer.println("@" + location);
        
        
        this.writer.println("D=M");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@SP");
        this.writer.println("M=M+1");
    }

    public void pushPointer(int index){
        if(index == 0){
            this.writer.println("@THIS");
            this.writer.println("D=M");
            this.writer.println("@SP");
            this.writer.println("A=M");
            this.writer.println("M=D");
            this.writer.println("@SP");
            this.writer.println("M=M+1");
        }else if(index == 1){
            this.writer.println("@THAT");
            this.writer.println("D=M");
            this.writer.println("@SP");
            this.writer.println("A=M");
            this.writer.println("M=D");
            this.writer.println("@SP");
            this.writer.println("M=M+1");
        }
    }

    public void popPointer(int index){

        if(index == 0){
            this.writer.println("@SP");
            this.writer.println("AM=M-1");
            this.writer.println("D=M");
            this.writer.println("@THIS");
            this.writer.println("M=D");
        }else if(index == 1){
            this.writer.println("@SP");
            this.writer.println("AM=M-1");
            this.writer.println("D=M");
            this.writer.println("@THAT");
            this.writer.println("M=D");
        }
    }

    public void pushConstant( int index){
        this.writer.println("//push constant");
        this.writer.println("@" + String.valueOf(index));
        this.writer.println("D=A");

        this.writer.println("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@SP");
        this.writer.println("M=M+1");

    }

    public void close(int eq){
        this.writer.println("(END)");
        this.writer.println("@END");
        this.writer.println("0;JMP");
        for(int i = 0; i < this.eq; i++){
            this.conditional("EQUAL", "SET_EQUAL",i);
        }
        for(int i = 0; i < this.gt; i++){
            this.conditional("GREATER", "SET_GREATER",i);
        }
        for(int i = 0; i < this.lt; i++){
            this.conditional("LESSER", "SET_LESSER",i);
        }
        this.writer.close();
    }

    public void conditional(String label, String goTo,int eq){

        //if equal
        this.writer.println("(" + label +"$" + eq + ")");
        this.writer.println("D=-1");
        this.writer.println("@"+ goTo +"$" + eq);
        this.writer.println("0;JMP");
    }



}