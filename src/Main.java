import algorithm.GradesArray;
import algorithm.LinearCookiesCounter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import util.Generator;
import util.Parser;
import util.Tester;
import util.argument.GenerationArguments;
import util.argument.ModeArguments;
import util.argument.TestingArguments;

import java.util.Arrays;

public class Main {
    Main() {}

    public static void main(String[] args) {
        try {
            ModeArguments modeArguments = new ModeArguments();
            JCommander commander = JCommander.newBuilder()
                    .addObject(modeArguments)
                    .build();

            if(args.length < 2) {
                commander.parse(args);
            } else {
                commander.parse(Arrays.copyOfRange(args, 0, 2));
            }

            if(modeArguments.help) {
                commander.usage();
                return;
            }

            if(modeArguments.executionMode == 1) {
                try {
                    GradesArray gradesArray = Parser.parse(System.in);
                    int cookiesNumber = new LinearCookiesCounter().countCookies(gradesArray);
                    System.out.print(cookiesNumber);

                } catch (Exception e) {
                    System.err.println("Problem data must be in format: 1, 2, 5, 3");
                }
            } else if (modeArguments.executionMode == 2) {
                GenerationArguments generationArguments = new GenerationArguments();
                JCommander.newBuilder()
                        .addObject(generationArguments)
                        .build()
                        .parse(args);

                GradesArray gradesArray = Generator.getInstance().generate(generationArguments.problemSize);
                int cookiesNumber = new LinearCookiesCounter().countCookies(gradesArray);

                System.out.println(gradesArray);
                System.out.print(cookiesNumber);

            }  else if (modeArguments.executionMode == 3) {
                TestingArguments testingArguments = new TestingArguments();
                JCommander.newBuilder()
                        .addObject(testingArguments)
                        .build()
                        .parse(args);

                Tester tester = new Tester(testingArguments.problemSize, testingArguments.problemSizeStep,
                        testingArguments.testsNumber, testingArguments.instanceTestsNumber);

                tester.test(new LinearCookiesCounter());

            }

        } catch(ParameterException parameterException) {
            System.err.println(parameterException.getMessage());
            parameterException.getJCommander().usage();
        }



    }

    
}
