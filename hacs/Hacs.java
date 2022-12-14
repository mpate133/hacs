package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Java 8
 *
 * @author Manan Patel
 * @version 3.0
 */

public class Hacs {

    static Facade theFacade = new Facade();

    public Hacs() {
    }

    public static void main(String[] args) {
//		String stringUsername;
//		String stringUserType = null;
        UserInfoItem userInfoItem = new UserInfoItem();
        theFacade.createCourseList();
        while (true) {
            boolean bExit = false;
            bExit = theFacade.login(userInfoItem);
            if (bExit) {
                break;
            }
            // userInfoItem.stringUserName = "Inst1";
            // userInfoItem.userType = 1;
            theFacade.createUser(userInfoItem);
            theFacade.attachCourseToUser();
            // if is a student remind him of the due date
            if (userInfoItem.userType == 0) {
                theFacade.remind();
            }
            boolean bLogout = false;
            while (!bLogout) {
                bLogout = theFacade.selectCourse();
                if (bLogout) {
                    break;
                }
                bLogout = theFacade.courseOperation();
            }
        }
    }
}
