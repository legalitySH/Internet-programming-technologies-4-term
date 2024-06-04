package lab_6.DatabaseManagment;

import lab_6.DatabaseManagment.ConnectionManager;
import lab_6.DatabaseManagment.DataModifier;
import lab_6.DatabaseManagment.QueryExecutor;
import lab_6.Models.Letter;
import lab_6.Models.User;

import java.util.Date;
import java.util.List;

public interface DAO extends ConnectionManager, QueryExecutor, DataModifier {
}
