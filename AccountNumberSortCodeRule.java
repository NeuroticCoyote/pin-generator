public class AccountNumberSortCodeRule {

    public AccountNumberSortCodeRule() {}

    public boolean ruleCheck(String paddedPin, int accountNumber, int sortCode, boolean isRuleCheckOK) {
        String accountNumberString = Integer.toString(accountNumber);
        String sortCodeString = Integer.toString(sortCode);
    
        if (accountNumberString.contains(paddedPin)) {
            isRuleCheckOK = false;
        } 
        else if (sortCodeString.contains(paddedPin)) {
            isRuleCheckOK = false;
        }

        return isRuleCheckOK;
    }

}
