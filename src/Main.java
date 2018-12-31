import com.beust.jcommander.JCommander;
import util.Arguments;

public class Main {
    Main() {}

    public static void main(String[] args) {
        Arguments arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        System.out.print(arguments.mode);
    }

    
}
