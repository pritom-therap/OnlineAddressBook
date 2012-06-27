package net.therap.controller.authentication;

import net.therap.command.LoginCmd;
import net.therap.domain.User;
import net.therap.service.user.UserService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginControllerTest extends UnitilsTestNG{


    @TestedObject
    private LoginController loginController;

    @InjectIntoByType
    private Mock<UserService> mockUserService;


    @Test
    public void testAuthenticate() throws Exception {
        LoginCmd loginCmd = new LoginCmd();

        loginController.setCommandClass(loginCmd.getClass());

        String formView = "Login";
        String successView = "VCard/Success";

        loginController.setFormView(formView);
        loginController.setSuccessView(successView);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

        mockHttpServletRequest.setMethod("POST");
        mockHttpServletRequest.setRequestURI("/Login.htm");

        User user = new User();

        mockUserService.returns(user).authenticate(loginCmd);

        ModelAndView modelAndView = loginController.handleRequest(mockHttpServletRequest,mockHttpServletResponse);

        Assert.assertEquals(successView,modelAndView.getViewName());
    }
}

