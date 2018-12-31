package util.argument;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;

public class TestingArguments extends ModeArguments {
    @Parameter(names = "-n", description = "Initial problem size", required = true,
            validateWith = PositiveInteger.class)
    public Integer problemSize;

    @Parameter(names = "-step", description = "Problem size testing step", required = true,
            validateWith = PositiveInteger.class)
    public Integer problemSizeStep;

    @Parameter(names = "-k", description = "Number of testing problem sizes", required = true,
            validateWith = PositiveInteger.class)
    public Integer testsNumber;

    @Parameter(names = "-r", description = "Number of tests per one problem size", required = true,
            validateWith = PositiveInteger.class)
    public Integer instanceTestsNumber;
}
