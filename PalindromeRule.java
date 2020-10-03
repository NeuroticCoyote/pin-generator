import java.util.*;

public class PalindromeRule {

    public PalindromeRule() {}

    public boolean ruleCheck(String paddedPin, boolean isRuleCheckOK) {
        String[] paddedPinArray = paddedPin.split("");
        String[] beforeReversingPin = paddedPin.split("");
    
        Collections.reverse(Arrays.asList(paddedPinArray));
    
        if (Arrays.equals(paddedPinArray, beforeReversingPin)) {
            isRuleCheckOK = false;
        }
        
        return isRuleCheckOK;
    }
}
