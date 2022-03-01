import java.io.PrintWriter;

public class Init {
    public Init(PrintWriter writer){
        writer.println("//INITIALIZE");

        writer.println("@256");
        writer.println("D=A");
        writer.println("@0");
        writer.println("M=D");

        writer.println("@300");
        writer.println("\nD=A");
        writer.println("@1");
        writer.println("M=D");

        writer.println("@400");
        writer.println("\nD=A");
        writer.println("@2");
        writer.println("M=D");

        writer.println("@3000");
        writer.println("\nD=A");
        writer.println("@3");
        writer.println("M=D");

        writer.println("@3010");
        writer.println("\nD=A");
        writer.println("@4");
        writer.println("M=D");

        writer.println("D=0");

        writer.println("// END OF INITIALIZER");
        writer.println("");
    }
}
