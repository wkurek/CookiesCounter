package util.argument;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;

public class GenerationArguments extends ModeArguments {
    @Parameter(names = "-n", description = "Problem size", required = true,
            validateWith = PositiveInteger.class)
    public Integer problemSize;
}
