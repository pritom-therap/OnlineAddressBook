package net.therap.dao;

import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/4/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

    public User getUserbyId(int id);

    public List<User> getUsers();

    public void saveUser(User user);
}
