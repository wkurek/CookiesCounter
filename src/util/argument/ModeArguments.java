package util.argument;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class ModeArguments {
    public static class ModeInteger implements IParameterValidator {

        @Override
        public void validate(String name, String value) throws ParameterException {
            int n = Integer.parseInt(value);
            if (n < 1 || n > 3) {
                String errorMessage = String.format("Parameter %s should be equal 1, 2 or 3 (found %s)",
                        name, value);

                throw new ParameterException(errorMessage);
            }
        }
    }

    @Parameter(names = "-m", description = "Execution mode (1 - problem from file, 2 - generate problem, 3 - test)",
            required = true, validateWith = ModeInteger.class)
    public Integer executionMode;

    @Parameter(names = { "-h", "-help" }, help = true)
    public boolean help;
}
