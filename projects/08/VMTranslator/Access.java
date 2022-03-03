import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Access {
    private PrintWriter writer;
    private int[] spArr;
    private int sp;

    public Access(PrintWriter writer, int[] spArr, int sp){
        this.writer = writer;
        this.spArr = spArr;

        this.sp = sp;
    }

    public int getSp(){
        return this.sp;
    }

    public int[] getSpArr(){
        return this.spArr;
    }

    public void pusher(int[] memStack, String memory, int index){
        this.writer.println("//push command");

        this.writer.println("@" + String.valueOf(index));
        this.writer.println("D=A");
        this.writer.println("@" + memory);
        this.writer.println("A=D+A");
        this.writer.println("D=M");                     //GET memStack[index]

        this.writer.print("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");                     // *SP = memStack[index]

        this.writer.println("@0");
        this.writer.println("M=M+1");                   //sp++

        this.spArr[this.sp - 256] = memStack[index];
        this.sp++;

        this.writer.println("//push command ends here");
    }

    public void pusher(String index, int value){
        this.writer.println("//push constant command");

        this.writer.println("@" + index);
        this.writer.println("D=A");                     // GET index

        this.writer.print("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");                     // *SP = index

        this.writer.println("@0");
        this.writer.println("M=M+1");                   //sp++

        this.spArr[this.sp - 256] = value;
        this.sp++;

        this.writer.println("//push constant command ends here");
    }

    public void pusher(int index){
        this.writer.println("//push constant command");

        this.writer.println("@" + String.valueOf(index));
        this.writer.println("D=A");                     // GET index

        this.writer.print("@SP");
        this.writer.println("A=M");
        this.writer.println("M=D");                     // *SP = index

        this.writer.println("@0");
        this.writer.println("M=M+1");                   //sp++

        this.spArr[this.sp - 256] = index;
        this.sp++;

        this.writer.println("//push constant command ends here");
    }

    public int[] popper(int[] memStack, int index, int memory){
        this.writer.println("//pop command");

        this.writer.print("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        int location = memory + index;
        this.writer.println( "@" + location);
        this.writer.println("M=D");

        this.sp--;
        memStack[index] = this.spArr[this.sp - 256];
        this.spArr[this.sp - 256] = 0;

        this.writer.println("//pop command ends here");
        return memStack;
    }

    public int popper(int memStack, String memory){
        this.writer.println("//pop command");

        this.writer.print("@SP");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("D=M");

        this.writer.println( "@" + memory);
        this.writer.println("M=D");

        this.sp--;
        memStack = this.spArr[this.sp - 256];
        this.spArr[this.sp - 256] = 0;

        this.writer.println("//pop command ends here");
        return memStack;
    }

}
