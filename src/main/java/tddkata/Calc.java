package tddkata;

public class Calc {
    public int sum(String expression) {
        int result = 0;
        if (expression == null) {
            return -1;
        }

        if (expression.equals("")) {
            return result;
        }
        if (expression.startsWith("//")) {
            char customDelimiter = expression.charAt(2);
            String targetString = expression.substring(expression.indexOf("\n") + 1);
            String[] valuesWithCustomDelimiter = separateString(targetString, Character.toString(customDelimiter));
            return countValuesSum(valuesWithCustomDelimiter);

        } else {
            String[] valuesWithDefaultDelimiter = expression.split("[,\\n]");
            return countValuesSum(valuesWithDefaultDelimiter);
        }
    }

    private String[] separateString(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    private int countValuesSum(String[] values) {
        int result = 0;
        for (String value : values) {
            try {
                int intValue = Integer.parseInt(value);
                result = result + intValue;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return result;
    }
}
