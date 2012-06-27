package net.therap.service.vcard;

import net.therap.dao.UserDao;
import net.therap.dao.VCardDao;
import net.therap.domain.User;
import net.therap.domain.VCard;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardServiceTest  extends UnitilsTestNG {

    @TestedObject
    private VCardServiceImpl vCardServiceImpl;

    @InjectIntoByType
    private Mock<VCardDao> mockvCardDao;
    @InjectIntoByType
    private Mock<UserDao> mockUserDao;
    @InjectIntoByType
    private Mock<VCardExport> mockVCardExport;

    User user;
    VCard vCard;

    @BeforeMethod
    public void setUp() {
        vCard = new VCard();
        vCard.setvCardId(1);
        user = new User();
    }

    @Test
    public void testGetVCardById() throws Exception{
        mockvCardDao.returns(vCard).getVCardById(1);

        Assert.assertEquals(1,vCard.getvCardId());
    }



}