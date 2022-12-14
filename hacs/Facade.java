package hacs;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Jave 8
 *
 * @author Manan Patel
 * @version 3.0
 */

public class Facade {
	public int userType;
	ClassCourseList theCourseList;
	Person thePerson;
	private Course theSelecteCourse = null;
	private int nCourseLevel = 0;

	public Facade() {
	}

	static public boolean login(UserInfoItem userInfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userInfoItem.stringUserName = login.getUserName();
		userInfoItem.userType = login.getUserType();
		return login.isExit();
	}

	/*
	 * When click the add button of the CourseMenu ,
	 *  call this function this
	 * function will new an assignment fill the required infomation
	 * this function will call InstructorAssignmentMenu
	 * or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu.
	 * The coursemenu need to
	 * refreshed outside the function
	 */

	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0) {
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * When click the view button of the CourseMenu ,
	 * call this function and pass
	 * the pointer of the Assignment and
	 * the person pointer to this function this
	 * function will new an assignment fill
	 * the required infomation this function
	 * will call InstructorAssignmentMenu or
	 * StudentAssignmentMenu according to the type of the user
	 */
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0) {
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	/*
	 * This function will grade the give Solution:
	 * theSolution this function calls
	 */

	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.showMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		Solution theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(UserInfoItem userInfoItem) {
		if (userInfoItem.userType == 0) {
			thePerson = new Student();
		} else {
			thePerson = new Instructor();
		}
		thePerson.userName = userInfoItem.stringUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user
	 * Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(
						new FileReader("UserCourse.txt")
					);
			String aLine, stringUserName, stringCourseName;
			while ((aLine = file.readLine()) != null) // not the EOF
			{
				stringUserName = getUserName(aLine);
				stringCourseName = getCourseName(aLine);
				/// the UserName matches
				if (stringUserName.compareTo(thePerson.userName) == 0)
				{
					theSelecteCourse = findCourseByCourseName(
											stringCourseName
										);
					/// Find the Course in the CourseList--->attach
					if (theSelecteCourse != null)
					{
						thePerson.addCourse(theSelecteCourse);
					}
				}
			}
		} catch (Exception ee) {
			System.out.println(ee);
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String getUserName(String aline) {
		int index = aline.lastIndexOf(':');
		return aline.substring(0, index);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int index = aline.lastIndexOf(':');
		return aline.substring(index + 1);
	}

	/*
	 * show the course selection dlg,
	 * show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelecteCourse = theDlg.showDlg(thePerson.courseList);
		thePerson.currentCourse = theSelecteCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu
	 * according to the really object(student or
	 * instructor) and the nCourseLevel it will call
	 * different menu creater and show the menu;
	 */

	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelecteCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches
	 * strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with
	 * the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String stringCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(stringCourseName);
	}

}
