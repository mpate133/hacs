package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Java 8
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
            if (userInfoItem.userType == 0) { // if is a student remind him of the due date
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
//    System.out.println(userInfoItem.strUserName + userInfoItem.UserType );
    }
}
