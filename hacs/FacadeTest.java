package hacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {

    Course courseForTest = new Course("SER501", 0);
    Assignment assignmentForTest = new Assignment();
    Solution solutionForTest = new Solution();

    Facade facadeForTest = new Facade();
    UserInfoItem userinfoitemfortest = new UserInfoItem();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void submitSolution() {
        facadeForTest.submitSolution(assignmentForTest, solutionForTest);
        facadeForTest.submitSolution(assignmentForTest, solutionForTest);
        Assertions.assertEquals(2, assignmentForTest.theSolutionList.size());
    }

    @Test
    void createUser() {
        userinfoitemfortest.userType = 0;
        facadeForTest.createUser(userinfoitemfortest);
        Assertions.assertEquals(true, facadeForTest.thePerson instanceof Student);

    }

    @Test
    void createCourseList() {
        facadeForTest.createCourseList();
        Assertions.assertEquals(3, facadeForTest.theCourseList.size());
    }

    @Test
    void attachCourseToUser() {
        userinfoitemfortest.userType = 0;
        userinfoitemfortest.stringUserName = "std1";
        facadeForTest.createUser(userinfoitemfortest);
        facadeForTest.createCourseList();
        facadeForTest.attachCourseToUser();
        Assertions.assertEquals(3, facadeForTest.thePerson.courseList.size());
    }

}