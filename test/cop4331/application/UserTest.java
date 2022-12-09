package cop4331.application;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rabih
 */
public class UserTest {
    /**
     * Test of checkNewUser method, of class User.
     */
    @Test
    public void testCheckNewUser() {
        System.out.println("checkNewUser");
        String name = "Tester";
        boolean expResult = true;
        boolean result = User.getInstance().checkNewUser(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserLogin method, of class User.
     */
    @Test
    public void testValidateUserLogin() {
        System.out.println("validateUserLogin");
        String name = "Rabih";
        String pwd = "Khatib";
        boolean expResult = true;
        boolean result = User.getInstance().validateUserLogin(name, pwd);
        assertEquals(expResult, result);
    }
    
}
