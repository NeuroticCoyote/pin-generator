public class ConsecutiveNumbersRule {

    public ConsecutiveNumbersRule() {}

    public boolean ruleCheck(String paddedPin, boolean isRuleCheckOK) {
        String[] paddedPinArray = paddedPin.split("");
        try {
            for (int i = 0; i < paddedPinArray.length; i++) {
                if (paddedPinArray[i].equals(paddedPinArray[i+1]) && paddedPinArray[i].equals(paddedPinArray[i+2])) {
                    isRuleCheckOK = false;
                    break;
                }
            }
        }
        catch (Exception e) {}
        return isRuleCheckOK;
    }
}
