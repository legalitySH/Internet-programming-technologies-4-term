package lab_6.DatabaseManagment;

import lab_6.Models.User;

public interface DataModifier {
    void sendLetterToAllRecipients(User sender, String subject, String body);
}
