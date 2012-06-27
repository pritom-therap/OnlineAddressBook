package net.therap.service.user;

import junit.framework.Assert;
import net.therap.command.LoginCmd;
import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceTest extends UnitilsTestNG {

    @TestedObject
    private UserServiceImpl userService;

    @InjectIntoByType
    private Mock<UserDao> mockUserDao;

    protected List<User> userList;

    User user1, user2;
    LoginCmd loginCmd;

    @BeforeMethod
    public void setUp() {
        loginCmd = new LoginCmd();
        user1 = new User();

        user1.setUserName("Tahmid");
        user1.setEmail("sinetob@gmail.com");
        user1.setPassword("123");

        user2 = new User();
        user2.setEmail("pritom.11@gmail.com");
        user2.setPassword("123");
        user2.setUserName("Pritom");

        userList = Arrays.asList(user1, user2);
    }


    @Test
    public void testAuthenticationAccept() throws Exception {

        loginCmd.setEmail("sinetob@gmail.com");
        loginCmd.setPassword("123");
        mockUserDao.returns(userList).getUsers();

        Assert.assertEquals(user1,userService.authenticate(loginCmd));
    }

    @Test
    public void testAuthenticationFail() throws Exception{

        loginCmd.setEmail("simetob@gmail.com");
        loginCmd.setPassword("123");
        mockUserDao.returns(userList).getUsers();

        Assert.assertEquals(null,userService.authenticate(loginCmd));
    }
}