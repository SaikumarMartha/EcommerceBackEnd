package com.Dao;
import java.util.List;

import com.model.*;
public interface UserDao
{


public boolean saveUser(User user);
public List<User> list();
public User getUserById(int user_id);
public void removeUserById(int user_id);

public User get(String email);

}
