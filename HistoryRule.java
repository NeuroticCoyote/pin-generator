import java.util.*;

public class HistoryRule {

    public static String[] initHistory = {"5683", "8932", "8934", "0121", "6784"}; // assumed history for Joe G
    public static ArrayList<String> pinHistory = new ArrayList<String>(Arrays.asList(initHistory));
    public static Map<String, ArrayList<String>> historyMap = new HashMap<>();

    public HistoryRule() {}

    public void put(String name) {
        historyMap.put(name, pinHistory); // initial history for application
    }

    public ArrayList<String> get(String name) {
        return historyMap.get(name);
    }

    public boolean ruleCheck(String name, String paddedPin, boolean isRuleCheckOK) {
        try {
            ArrayList<String> h = historyMap.get(name);

            for (int i = h.size() - 3; i < h.size(); i ++) { // only check latest 3 pins in history
                if (paddedPin == h.get(i)) {
                    isRuleCheckOK = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Found name " + name + " for the first time, creating user history...");
            ArrayList<String> newArrayList = new ArrayList<String>();
            historyMap.put(name, newArrayList);
        }
        return isRuleCheckOK;
    }
}
