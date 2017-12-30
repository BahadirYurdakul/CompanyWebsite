//package services;
//
//import DAO.Repository;
//import models.User;
//
//public enum  UserService {
//    USER_SERVICE;
//    private static Repository repository = Repository.REPOSITORY;
//
//    public User createUser(User user){
//        if(isUserAlreadyExist(user.getUsername())) {
//            // FIXME: 23.11.2017 add alreadyExistException
//           return null;
//        } else {
//            return repository.addUser(user);
//        }
//    }
//
//    public User changeUser(User newUser) {
//        if(isUserAlreadyExist(newUser.getUsername())) {
//            return repository.changeUserInfo(newUser);
//        } else {
//            // FIXME: 23.11.2017 add notFoundException
//            return null;
//        }
//    }
//
//
//    private boolean isUserAlreadyExist(String userName) {
//        return repository.isUserExist(userName);
//    }
//}
