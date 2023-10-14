package use_case;

import entity.User;

import java.util.Map;

public interface GetAllUsersInterface {
    Map<String, User> getAccounts();
}
