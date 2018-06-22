package com.example.anilreddy.rxjava.utils;

import com.example.anilreddy.rxjava.model.ApiUser;
import com.example.anilreddy.rxjava.model.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public Utils() {

    }

    public static List<ApiUser> getApiUserList() {
        List<ApiUser> apiUserList = new ArrayList<>();
        ApiUser apiUserOne = new ApiUser();
        apiUserOne.firstName = "Amit";
        apiUserOne.lastName = "Shekhar";
        apiUserList.add(apiUserOne);

        ApiUser apiUserTwo = new ApiUser();
        apiUserTwo.firstName = "Manish";
        apiUserTwo.lastName = "Kumar";
        apiUserList.add(apiUserTwo);

        ApiUser apiUserThree = new ApiUser();
        apiUserThree.firstName = "Sumit";
        apiUserThree.lastName = "Kumar";
        apiUserList.add(apiUserThree);

        return apiUserList;
    }

    public static List<User> convertApiUserListToUserList(List<ApiUser> apiUserList) {
        List<User> userList = new ArrayList<>();

        for (ApiUser apiUser : apiUserList) {
            User user = new User();
            user.firstName = apiUser.firstName;
            user.lastName = apiUser.lastName;
            userList.add(user);
        }
        return userList;
    }
}
