package lab_6.DatabaseManagment;

import lab_6.Models.Letter;
import lab_6.Models.User;

import java.util.List;

public interface QueryExecutor {
    User getMinLetterLengthUser();
    void getUsersLetterInfo();
    List<User> getUsersByReceivedLetterSubject(String subject);
    List<User> getUsersByNotReceivedLetterSubject(String subject);
}
