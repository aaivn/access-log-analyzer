package alexander.ivanov.util;

import org.apache.commons.cli.*;

public class CliHelper {
    private static final Options options = new Options();
    private static CommandLine cli;

    static {
        buildOptions();
    }

    private static void buildOptions() {
        options.addOption(buildOption("t", "time", Integer.class, ""))
                .addOption(buildOption("a", "accessibility", Float.class, ""));
    }

    private static Option buildOption(String shortName, String longName, Class<?> type, String desc) {
        return Option.builder(shortName)
                .argName(shortName)
                .longOpt(longName)
                .hasArg(true)
                .numberOfArgs(1)
                .type(type)
                //.required(true)
                .desc(desc)
                .build();
    }

    private static String getValueAsString(String name) {
        return cli.getOptionValue(name, "");
    }

    private static int parseInt(String value, Number defaultValue) {
        int numValue = defaultValue.intValue();
        try {
            if (!value.isEmpty()) {
                numValue = Integer.parseInt(value);
            }
        } catch (Exception e) {
            ErrorHandler.printStackTrace(e.getStackTrace());
        }
        return numValue;
    }

    private static float parseFloat(String value, Number defaultValue) {
        float numValue = defaultValue.floatValue();
        try {
            if (!value.isEmpty()) {
                numValue = Float.parseFloat(value);
            }
        } catch (Exception e) {
            ErrorHandler.printStackTrace(e.getStackTrace());
        }
        return numValue;
    }

    public static CommandLine parseArgs(String[] args) {
        if (cli != null) {
            return cli;
        }
        try {
            cli = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            ErrorHandler.printStackTrace(e.getStackTrace());
            throw new RuntimeException(e.getMessage());
        }
        return cli;
    }

    public static int getTimeValue() {
        String valueAsString = getValueAsString("t");
        return parseInt(valueAsString, 45);
    }

    public static Float getAccessibilityValue() {
        String valueAsString = getValueAsString("a");
        return parseFloat(valueAsString, 99.9F);
    }
}