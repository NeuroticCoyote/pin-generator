import java.util.*;

public class RuleSet {
    public static boolean isRuleCheckOK;
    public HistoryRule newHistory = new HistoryRule();

    public RuleSet() {
        isRuleCheckOK = true;
        newHistory.put("Joe G");
    }

    public boolean getRuleCheckOK() {
        return isRuleCheckOK;
    }

    public void updatePinHistory(String name, String newPin) {
        ArrayList<String> h = newHistory.get(name);
        h.add(newPin);
    }

    // It should be 4 digits long
    public static int lengthRule() {
        int upperLimit = 9999; // random int from 0 - 9999, so length = 4
                               // add additional 9's to increase length. i.e. 99999 = length of 5
        return upperLimit;
    }

}
