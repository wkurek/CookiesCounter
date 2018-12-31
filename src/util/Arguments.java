package util;

import com.beust.jcommander.Parameter;

public class Arguments {
    @Parameter(names = "-m", required = true)
    public Integer mode;
}
