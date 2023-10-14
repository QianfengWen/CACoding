package use_case.clear_users;

// TODO Complete me

import entity.User;
import entity.UserFactory;
import use_case.GetAllUsersInterface;

import java.util.Map;

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccess;
    final ClearOutputBoundary outputBoundary;
    final UserFactory userFactory;
    final GetAllUsersInterface getAllUsersInterface;


    public ClearInteractor(ClearUserDataAccessInterface userDataAccess,
                           ClearOutputBoundary outputBoundary,
                           UserFactory userFactory,
                           GetAllUsersInterface getAllUsersInterface) {
        this.userFactory = userFactory;
        this.outputBoundary = outputBoundary;
        this.userDataAccess = userDataAccess;
        this.getAllUsersInterface = getAllUsersInterface;
    }

    @Override
    public void execute(ClearInputData inputData) {
        userDataAccess.deleteAllUsers();
        outputBoundary.prepareSuccessView(new ClearOutputData());
    }

    public String getAccounts() {
        Map<String, User> accounts = getAllUsersInterface.getAccounts();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, User> entry : accounts.entrySet()) {
            result.append(entry.getKey()).append("\n");
        }
        return result.toString();
    }
}
