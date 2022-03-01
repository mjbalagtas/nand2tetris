import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter {
    private PrintWriter writer;
    private int sp, lcl, arg, thismem, thatmem, tempmem, staticmem;
    private int[] spArr;
    private int[] lclArr;
    private int[] argArr;
    private int[] thisArr;
    private int[] thatArr;
    private int[] tempArr;
    private int[] staticArr;

    public CodeWriter(String fileName) throws FileNotFoundException{
        this.writer = new PrintWriter(fileName);
        this.sp = 256; this.lcl = 300; this.arg = 400; this.thismem = 3000; this.thatmem = 3010; this.tempmem = 5; this.staticmem = 16;
        this.spArr = new int[44];
        this.lclArr = new int[100];
        this.argArr = new int[2600];
        this.thisArr = new int[10];
        this.thatArr = new int[10];
        this.tempArr = new int[8];
        this.staticArr = new int[239];

        new Init(this.writer);
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
            this.eq();
        }else if(command.contains("gt")){
            this.writer.println("//gt command");
            this.get();
        }else if(command.contains("lt")){
            this.writer.println("//lt command");
            this.lt();
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

        if(commandType == CommandType.C_PUSH && segment.equals("constant")){

            this.pushConstant(index);
        }else if(commandType == CommandType.C_PUSH){
            if(segment.contains("local")){
                this.pusher(this.lclArr, index);
            }else if(segment.contains("arg")){
                this.pusher(this.argArr, index);
            }else if(segment.contains("this")){
                this.pusher(this.thisArr, index);
            }else if(segment.contains("that")){
                this.pusher(this.thatArr, index);
            }else if(segment.contains("temp")){
                this.pusher(this.tempArr, index);
            }else if(segment.contains("static")){
                this.pusher(this.staticArr, index);
            }else if(segment.contains("pointer")){
                if(index == 0){
                    this.pushConstant(this.thismem);
                }else if(index == 1){
                    this.pushConstant(this.thatmem);
                }
            }
        }
        else if (commandType == CommandType.C_POP){
            if(segment.contains("local")){
                this.popper(this.lclArr, index, this.lcl);
            }else if(segment.contains("arg")){
                this.popper(this.argArr, index, this.arg);
            }else if(segment.contains("this")){
                this.popper(this.thisArr, index, this.thismem);
            }else if(segment.contains("that")){
                this.popper(this.thatArr, index, this.thatmem);
            }else if(segment.contains("temp")){
                this.popper(this.tempArr, index, this.tempmem);
            }else if(segment.contains("static")){
                this.popper(this.staticArr, index, this.staticmem);
            }else if(segment.contains("pointer")){
                    this.popper(index);
            }
        }
    }

    public void add(){
        this.writer.println("//add command");
        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        int secondNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D+M");

        this.spArr[this.sp - 256] = secondNum + firstNum;
        this.writer.println("@0");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@0");
        this.writer.println("M=M+1");
        this.sp++;
    }

    public void subtract(){
        this.writer.println("//sub command");

        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        int secondNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=D-M");
        this.writer.println("D=-D");


        this.spArr[this.sp - 256] = secondNum - firstNum;
        this.writer.println("@0");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@0");
        this.writer.println("M=M+1");
        this.sp++;
    }

    public void neg(){
        this.sp--;
        this.spArr[this.sp - 256] = -this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=-M");

        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void eq(){

        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        int secondNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");

        if(firstNum == secondNum){
            this.writer.println("M=-1");
            this.spArr[this.sp - 256] = -1;
        }else{
            this.writer.println("M=0");
            this.spArr[this.sp - 256] = 0;
        }

        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void get(){

        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        int secondNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");

        if(firstNum < secondNum){
            this.writer.println("M=-1");
            this.spArr[this.sp - 256] = -1;
        }else{
            this.writer.println("M=0");
            this.spArr[this.sp - 256] = 0;
        }

        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void lt(){

        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        int secondNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");

        if(firstNum > secondNum){
            this.writer.println("M=-1");
            this.spArr[this.sp - 256] = -1;
        }else{
            this.writer.println("M=0");
            this.spArr[this.sp - 256] = 0;
        }

        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void and(){

        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        this.spArr[this.sp - 256] = this.spArr[this.sp - 256]&firstNum;
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=D&M");
        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void or(){

        this.sp--;
        int firstNum = this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.sp--;
        this.spArr[this.sp - 256] = this.spArr[this.sp - 256]|firstNum;
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=D|M");
        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void not(){

        this.sp--;
        this.spArr[this.sp - 256] = -(this.spArr[this.sp - 256]+1);

        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=!M");
        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void popper(int[] memStack, int index, int partition){

        this.sp--;
        memStack[index] = this.spArr[this.sp - 256];

        this.writer.print("@");
        this.writer.println(String.valueOf(this.spArr[this.sp - 256]));
        this.writer.println("D=A");

        int location = partition + index;
        this.writer.print("@");
        this.writer.println(String.valueOf(location));
        this.writer.println("M=D");

        this.writer.println("@0");
        this.writer.println("M=M-1");

        this.spArr[this.sp - 256] = 0;
    }

    public void popper(int index){

        this.sp--;
        int location = -1;
        if(index == 0){
            this.thismem = this.spArr[this.sp - 256];
            location = 3;
        }else if(index == 1){
            this.thatmem = this.spArr[this.sp - 256];
            location = 4;
        }

        this.writer.print("@");
        this.writer.println(String.valueOf(this.spArr[this.sp - 256]));
        this.writer.println("D=A");

        this.writer.print("@");
        this.writer.println(String.valueOf(location));
        this.writer.println("M=D");

        this.writer.println("@0");
        this.writer.println("M=M-1");

        this.spArr[this.sp - 256] = 0;
    }

    public void pusher(int[] memStack, int index){
        this.spArr[this.sp - 256] = memStack[index];

        this.writer.print("@");
        this.writer.println(String.valueOf(memStack[index]));
        this.writer.println("D=A");

        this.writer.println("@0");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@0");
        this.writer.println("M=M+1");

        //memStack[index] = 0;
        this.sp++;
    }

    public void pushConstant( int index){
        this.writer.println("//push constant");
        this.spArr[this.sp - 256] = index;

        this.writer.print("@");
        this.writer.println(String.valueOf(index));
        this.writer.println("\nD=A");

        this.writer.println("@0");
        this.writer.println("A=M");
        this.writer.println("M=D");

        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;
    }

    public void close(){
        this.writer.close();
    }

    public void test(){
        this.writer.println("\nnot translated\n");
    }

    public void printArr(){

        System.out.println("\n\nSP:RAM[256]");
        for(int i = 0; i < 15; i++){
            System.out.print(spArr[i] + "\t");
        }
        System.out.println("\n\nLCL:RAM[300]");
        for(int i = 0; i < 15; i++){
            System.out.print(lclArr[i] + "\t");
        }
        System.out.println("\n\nARG:RAM[400]");
        for(int i = 0; i < 15; i++){
            System.out.print(argArr[i] + "\t");
        }
        System.out.println("\n\nTHIS:RAM[3000]");
        for(int i = 0; i < 10; i++){
            System.out.print(thisArr[i] + "\t");
        }
        System.out.println("\n\nTHAT:RAM[3010]");
        for(int i = 0; i < 10; i++){
            System.out.print(thatArr[i] + "\t");
        }
        System.out.println("\n\nTEMP:RAM[5..12]");
        for(int i = 0; i < 8; i++){
            System.out.print(tempArr[i] + "\t");
        }
        System.out.println("\n\nSTATIC:RAM[16..255]");
        for(int i = 0; i < 20; i++){
            System.out.print(staticArr[i] + "\t");
        }
        System.out.println("\n\nSTACK POINTER: " + this.sp + "\tTHIS: " + this.thismem + "\tTHAT: " + this.thatmem + "\n\n");
    }
}