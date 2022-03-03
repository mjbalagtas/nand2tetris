import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Logical {
    private PrintWriter writer;
    private int[] spArr;
    private int sp;

    public Logical(PrintWriter writer, int[] spArr, int sp){
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

        this.writer.println("//sub command ends here");
    }

    public void neg(){
        this.writer.println("//neg command");

        this.sp--;
        this.spArr[this.sp - 256] = -this.spArr[this.sp - 256];
        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=-M");

        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;

        this.writer.println("//neg command ends here");
    }

    public void eq(){
        this.writer.println("//eq command");

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

        this.writer.println("//eq command ends here");
    }

    public void get(){
        this.writer.println("//gt command");

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

        this.writer.println("//gt command ends here");
    }

    public void lt(){
        this.writer.println("//lt command");

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

        this.writer.println("//lt command ends here");
    }

    public void and(){
        this.writer.println("//and command");

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

        this.writer.println("//and command ends here");
    }

    public void or(){
        this.writer.println("//or command");

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

        this.writer.println("//or command ends here");
    }

    public void not(){
        this.writer.println("//not command");

        this.sp--;
        this.spArr[this.sp - 256] = -(this.spArr[this.sp - 256]+1);

        this.writer.println("@0");
        this.writer.println("M=M-1");
        this.writer.println("A=M");
        this.writer.println("M=!M");
        this.writer.println("@0");
        this.writer.println("M=M+1");

        this.sp++;

        this.writer.println("//not command ends here");
    }
}
