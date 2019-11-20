package pl.sda.model;


import java.util.*;

public class EmailHistoryDatabase {

    private static Map<User, List<EmailHistory>> emailHistoryMap = new HashMap<>();


    public void add(User sender, EmailHistory emailHistory) {
        if (emailHistoryMap.containsKey(sender)) {
            List<EmailHistory> userEmailHistory = emailHistoryMap.get(sender);
            userEmailHistory.add(emailHistory);
        } else {
            List<EmailHistory> emailHistories = new ArrayList<>();
            emailHistories.add(emailHistory);
            emailHistoryMap.put(sender, emailHistories);
        }
        System.out.println(emailHistoryMap); //FIXME
    }

    public static Map<User, List<EmailHistory>> getEmailHistoryMap() {
        return emailHistoryMap;
    }
}
