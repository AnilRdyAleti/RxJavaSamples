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

    public static List<User> getUserListWhoLovesCricket() {
        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.id = 1;
        userOne.firstName = "Amit";
        userOne.lastName = "Shekhar";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.id = 2;
        userTwo.firstName = "Manish";
        userTwo.lastName = "Kumar";
        userList.add(userTwo);

        return userList;
    }

    public static List<User> getUserListWhoLovesFootball() {
        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.id = 1;
        userOne.firstName = "Amit";
        userOne.lastName = "Shekhar";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.id = 3;
        userTwo.firstName = "Sumit";
        userTwo.lastName = "Kumar";
        userList.add(userTwo);

        return userList;
    }

    public static List<User> filterUserWhoLovesBoth(List<User> cricketFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<User>();
        for (User cricketFan : cricketFans) {
            for (User footballFan : footballFans) {
                if (cricketFan.id == footballFan.id) {
                    userWhoLovesBoth.add(cricketFan);
                }
            }
        }
        return userWhoLovesBoth;
    }
}