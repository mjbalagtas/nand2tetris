import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

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
    private String[] memory;
    private Map<String, Integer> labels;
    private Logical logical;
    private Access access;

    public CodeWriter(String fileName) throws FileNotFoundException{
        this.writer = new PrintWriter(fileName);
        this.sp = 256; this.lcl = 300; this.arg = 400; this.thismem = 3000; this.thatmem = 3010; this.tempmem = 5; this.staticmem = 16;
        this.memory = new String[]{ "LCL", "ARG", "THIS", "THAT", "5", "16"};
        this.spArr = new int[44];
        this.lclArr = new int[100];
        this.argArr = new int[2600];
        this.thisArr = new int[10];
        this.thatArr = new int[10];
        this.tempArr = new int[8];
        this.staticArr = new int[239];
        this.labels = new HashMap<>();
        this.logical = new Logical(this.writer, spArr, sp);
        this.access = new Access(this.writer, spArr, sp);

        //new Init(this.writer);
        this.argArr[0] = 3;
    }

    public void writeArithmetic(String command){
        if(command.equals("add")){
            this.logical.add();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();

        }else if(command.contains("sub")){
            this.writer.println("//sub command");
            this.logical.subtract();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("neg")){
            this.writer.println("//neg command");
            this.logical.neg();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("eq")){
            this.writer.println("//eq command");
            this.logical.eq();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("gt")){
            this.writer.println("//gt command");
            this.logical.get();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("lt")){
            this.writer.println("//lt command");
            this.logical.lt();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("and")){
            this.writer.println("//and command");
            this.logical.and();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("or")){
            this.writer.println("//or command");
            this.logical.or();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }else if(command.contains("not")){
            this.writer.println("//not command");
            this.logical.not();
            this.sp = this.logical.getSp();
            this.spArr = this.logical.getSpArr();
        }
    }

    public void writePushPop(CommandType commandType, String segment, int index){

        if(commandType == CommandType.C_PUSH && segment.equals("constant")){

            this.access.pusher(index);
        }else if(commandType == CommandType.C_PUSH){
            if(segment.contains("local")){
                this.access.pusher(this.lclArr, this.memory[0], index);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("arg")){
                this.access.pusher(this.argArr, this.memory[1], index);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("this")){
                this.access.pusher(this.thisArr, this.memory[2], index);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("that")){
                this.access.pusher(this.thatArr, this.memory[3], index);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("temp")){
                this.access.pusher(this.tempArr, this.memory[4], index);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("static")){
                this.access.pusher(this.staticArr, this.memory[5], index);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("pointer")){
                if(index == 0){
                    this.access.pusher(this.memory[1], this.thismem);
                    this.sp = this.access.getSp();
                    this.spArr = this.access.getSpArr();
                }else if(index == 1){
                    this.access.pusher(this.memory[2], this.thatmem);
                    this.sp = this.access.getSp();
                    this.spArr = this.access.getSpArr();
                }
            }
        }
        else if (commandType == CommandType.C_POP){
            if(segment.contains("local")){
                this.lclArr = this.access.popper(this.lclArr, index, this.lcl);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("arg")){
                this.argArr = this.access.popper(this.argArr, index, this.arg);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("this")){
                this.thisArr = this.access.popper(this.thisArr, index, this.thismem);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("that")){
                this.thatArr = this.access.popper(this.thatArr, index, this.thatmem);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("temp")){
                this.tempArr = this.access.popper(this.tempArr, index, this.tempmem);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("static")){
                this.staticArr = this.access.popper(this.staticArr, index, this.staticmem);
                this.sp = this.access.getSp();
                this.spArr = this.access.getSpArr();
            }else if(segment.contains("pointer")){
                if(index == 0){
                    this.thismem = this.access.popper(this.thismem, memory[1]);
                    this.sp = this.access.getSp();
                    this.spArr = this.access.getSpArr();
                }else if(index == 1){
                    this.thatmem = this.access.popper(this.thatmem, memory[2]);
                    this.sp = this.access.getSp();
                    this.spArr = this.access.getSpArr();
                }
            }
        }
    }

    public void writeLabel(int commandLine, String labelName){
        this.writer.println("//writeLabel command starts here");

        this.labels.put(labelName.trim(), commandLine);
        this.writer.print("(");
        this.writer.print(labelName);
        this.writer.println(")");

        this.writer.println("//writeLabel command ends here");
    }

    public void writeIf(String labelName){
        this.writer.println("//writeIf command starts here");

        // this.writer.print("@");
        // this.writer.println(String.valueOf(argArr[0]));
        // this.writer.println("D=A");
        this.writer.print("@");
        this.writer.println(String.valueOf(this.arg));
        this.writer.println("D=M");

        this.writer.print("@");
        this.writer.println(labelName);
        this.writer.println("D;JNE");

        // this.writer.println("//writeIf command ends here");
        // if(this.argArr[0] == 0){
        //     return true;
        // }else{
        //     return false;
        // }
    }

    public void writeGoto(String labelName){
        this.writer.println("//writeGoto command starts here");

        this.writer.print("@");
        this.writer.println(String.valueOf(this.labels.get(labelName.trim())));
        this.writer.print("\t");
        this.writer.println("0;JMP");

        this.writer.println("//writeGoto command ends here");
    }



    // public void popper(int[] memStack, int index, int partition){
    //     this.writer.println("//pop command");

    //     this.sp--;
    //     memStack[index] = this.spArr[this.sp - 256];

    //     if(this.spArr[this.sp - 256] < 0 ){
    //         this.writer.println("D=-1");
    //     }else{
    //         this.writer.print("@");
    //         this.writer.println(String.valueOf(this.spArr[this.sp - 256]));
    //         this.writer.println("D=A");
    //     }

    //     int location = partition + index;
    //     this.writer.print("@");
    //     this.writer.println(String.valueOf(location));
    //     this.writer.println("M=D");

    //     this.writer.println("@0");
    //     this.writer.println("M=M-1");

    //     this.spArr[this.sp - 256] = 0;

    //     this.writer.println("//pop command ends here");
    // }

    // public void pushConstant( int index){
    //     this.writer.println("//push constant");
    //     this.spArr[this.sp - 256] = index;

    //     this.writer.print("@");
    //     this.writer.println(String.valueOf(index));
    //     this.writer.println("\nD=A");

    //     this.writer.println("@0");
    //     this.writer.println("A=M");
    //     this.writer.println("M=D");

    //     this.writer.println("@0");
    //     this.writer.println("M=M+1");

    //     this.sp++;

    //     this.writer.println("//push constant ends here");
    // }

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