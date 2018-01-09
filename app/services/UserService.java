package services;

import DataAccessObject.Repository;
import models.User;

public enum  UserService {
    USER_SERVICE;
    private static Repository repository = Repository.REPOSITORY;

    public User createUser(User user){
            return repository.addUser(user);
    }

    public User changeUser(User newUser) {
            return repository.changeUserInfo(newUser);
    }

    public User getUser(String username) {
        User user = repository.getUser(username);
        user.setPassword("");
        return user;
    }
}
