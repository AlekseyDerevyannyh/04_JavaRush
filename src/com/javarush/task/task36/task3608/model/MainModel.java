package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(getAllUsers());
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userService.deleteUser(id);
        modelData.setActiveUser(user);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        User user = userService.createOrUpdateUser(name, id, level);
        modelData.setActiveUser(user);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
    }
}
