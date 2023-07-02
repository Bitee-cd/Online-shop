package com.bitee.services;

import com.bitee.entities.User;

public interface UserManagementService {
    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);
}
