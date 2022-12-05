package cop4331.application;

import cop4331.controller.UserController;

/**
 * Main Class for JAVA Shopping App
 * @author Rabih, Gerrell, Zachary, Solan
 */
public class Main {

    public static void main(String[] args) {
        new Data().init();
        User.getInstance().userDataInit();
        new UserController().initLogin();
   }
}
