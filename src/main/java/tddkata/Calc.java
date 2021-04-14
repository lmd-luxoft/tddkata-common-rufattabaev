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
        String[] values = expression.split("[,\\n]");

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
