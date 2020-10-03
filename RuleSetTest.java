import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class RuleSetTest {

    @Test
    public void testConsecutiveNumbersRule() {
        RuleSet test1 = new RuleSet();
        
        assertEquals(true, test1.getRuleCheckOK()); // before pin validation
        ConsecutiveNumbersRule rule1 = new ConsecutiveNumbersRule();
        boolean isRuleCheckOK = rule1.ruleCheck("1112", true);
        assertEquals(false, isRuleCheckOK); // after pin validation

        RuleSet test2 = new RuleSet();
        assertEquals(true, test2.getRuleCheckOK()); // before pin validation
        isRuleCheckOK = rule1.ruleCheck("3444", true);
        assertEquals(false, isRuleCheckOK); // after pin validation

        RuleSet test3 = new RuleSet();
        assertEquals(true, test3.getRuleCheckOK()); // before pin validation
        isRuleCheckOK = rule1.ruleCheck("1122", true);
        assertEquals(true, isRuleCheckOK); // after pin validation
    }

    @Test
    public void testConsecutiveSequenceRule() {
        RuleSet test1 = new RuleSet();
        assertEquals(true, test1.getRuleCheckOK()); 
        ConsecutiveSequenceRule rule2 = new ConsecutiveSequenceRule();
        boolean isRuleCheckOK = rule2.ruleCheck("1234", true);
        assertEquals(false, isRuleCheckOK); 

        RuleSet test2 = new RuleSet();
        assertEquals(true, test2.getRuleCheckOK()); 
        isRuleCheckOK = rule2.ruleCheck("3456", true);
        assertEquals(false, isRuleCheckOK); 

        RuleSet test3 = new RuleSet();
        assertEquals(true, test3.getRuleCheckOK()); 
        isRuleCheckOK = rule2.ruleCheck("5431", true);
        assertEquals(true, isRuleCheckOK); 
    }

    @Test
    public void testHistoryRule() {
        String joe = "Joe G";
        String bob = "Bob A";
        RuleSet test1 = new RuleSet();
        HistoryRule rule3 = new HistoryRule();
        assertEquals(true, test1.getRuleCheckOK()); 
        boolean isRuleCheckOK = rule3.ruleCheck(joe, "5683", true);
        assertEquals(true, isRuleCheckOK);

        RuleSet test2 = new RuleSet();
        assertEquals(true, test2.getRuleCheckOK());
        isRuleCheckOK = rule3.ruleCheck(joe, "8932", true);
        assertEquals(true,isRuleCheckOK); 

        RuleSet test3 = new RuleSet();
        assertEquals(true, test3.getRuleCheckOK()); 
        isRuleCheckOK = rule3.ruleCheck(joe, "8934", true);
        assertEquals(false, isRuleCheckOK);

        RuleSet test4 = new RuleSet();
        assertEquals(true, test4.getRuleCheckOK()); 
        isRuleCheckOK = rule3.ruleCheck(bob, "8934", true); // bob has no history, so this should be true
        assertEquals(true, isRuleCheckOK);
    }

    @Test
    public void testAccountNumberSortCodeRule() {
        RuleSet test1 = new RuleSet();
        AccountNumberSortCodeRule rule4 = new AccountNumberSortCodeRule();
        assertEquals(true, test1.getRuleCheckOK()); 
        boolean isRuleCheckOK = rule4.ruleCheck("5683", 711313, 13561342, true);
        assertEquals(true, isRuleCheckOK);

        RuleSet test2 = new RuleSet();
        assertEquals(true, test2.getRuleCheckOK());
        isRuleCheckOK = rule4.ruleCheck("1313", 711313, 13561342, true); // shared sort code number
        assertEquals(false, isRuleCheckOK); 

        RuleSet test3 = new RuleSet();
        assertEquals(true, test3.getRuleCheckOK()); 
        isRuleCheckOK = rule4.ruleCheck("6134", 711313, 13561342, true); // shared account number 
        assertEquals(false, isRuleCheckOK);
    }

    @Test
    public void testPalindromeRule() {
        RuleSet test1 = new RuleSet();
        PalindromeRule rule5 = new PalindromeRule();
        assertEquals(true, test1.getRuleCheckOK()); 
        boolean isRuleCheckOK = rule5.ruleCheck("1122", true);
        assertEquals(true, isRuleCheckOK);

        RuleSet test2 = new RuleSet();
        assertEquals(true, test2.getRuleCheckOK());
        isRuleCheckOK = rule5.ruleCheck("2112", true);
        assertEquals(false, isRuleCheckOK); 
    }
}
