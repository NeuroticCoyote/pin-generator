public class ConsecutiveSequenceRule {

    public ConsecutiveSequenceRule() {}

    public boolean ruleCheck(String paddedPin, boolean isRuleCheckOK) {
        int consecutiveCount = 1;

        String[] paddedPinArray = paddedPin.split("");
        for (int i = 1; i < paddedPinArray.length; i++) {
            int pinNumberFirst = Integer.parseInt(paddedPinArray[i]);
            int pinNumberSecond = Integer.parseInt(paddedPinArray[i-1]);

            if (pinNumberFirst - pinNumberSecond == 1) {
                consecutiveCount++; // we have a consecutive number, since the difference is 1
            }
        }
        if (consecutiveCount == 4) {
            isRuleCheckOK = false;
        }
        return isRuleCheckOK;
    }
}
