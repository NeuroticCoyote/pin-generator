public class CheckRuleSet extends RuleSet {
    
    public boolean checkRules(String name, String paddedPin, int accountNumber, int sortCode) {
        ConsecutiveNumbersRule rule1 = new ConsecutiveNumbersRule();
        isRuleCheckOK = rule1.ruleCheck(paddedPin, isRuleCheckOK);

        ConsecutiveSequenceRule rule2 = new ConsecutiveSequenceRule();
        isRuleCheckOK = rule2.ruleCheck(paddedPin, isRuleCheckOK);

        HistoryRule rule3 = new HistoryRule();
        isRuleCheckOK = rule3.ruleCheck(name, paddedPin, isRuleCheckOK);

        AccountNumberSortCodeRule rule4 = new AccountNumberSortCodeRule();
        isRuleCheckOK = rule4.ruleCheck(paddedPin, accountNumber, sortCode, isRuleCheckOK);

        PalindromeRule rule5 = new PalindromeRule();
        isRuleCheckOK = rule5.ruleCheck(paddedPin, isRuleCheckOK);

        return isRuleCheckOK;
    }
}
