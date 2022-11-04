package hacs;

import java.util.Iterator;

/**
 * Title: HACS
 * Description:
 * Copyright: Copyright (c) 2002
 * Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 *
 * @author Manan Patel
 * @version 2.0
 */

public class SolutionIterator implements Iterator {
    SolutionList solutionlist;

    /// CurrentSolutionNumber: point to the location before the first element
    int currentSolutionNumber = -1;

    public SolutionIterator() {
    }

    public SolutionIterator(SolutionList thesolutionlist) {
        solutionlist = thesolutionlist;
        moveToHead();
    }

    public void moveToHead() {
        /// CurrentSolutionNumber: point to the location before the first element
        currentSolutionNumber = -1;
    }

    public boolean hasNext() {
        /** @todo: Implement this java.util.Iterator method */
        if (currentSolutionNumber >= solutionlist.size() - 1) {
            return false;
        }
        else {
            return true;
        }
        // throw new java.lang.UnsupportedOperationException("Method hasNext() not yet
        // implemented.");
    }

    public Object next() {
        /** @todo: Implement this java.util.Iterator method */
        if (hasNext() == true) {
            currentSolutionNumber++;
            return solutionlist.get(currentSolutionNumber);
        } else {
            return null;
        }
        // throw new java.lang.UnsupportedOperationException("Method next() not yet
        // implemented.");
    }

    /// get the next Solution that fits the Username;
    public Object next(String UserName) {
        Solution theSolution;
        theSolution = (Solution) next();
        while (theSolution != null) {
            if (UserName.compareTo(theSolution.theAuthor) == 0) {
                return theSolution;
            }
            theSolution = (Solution) next();
        }
        return null;
    }

    public void remove() {
        /** @todo: Implement this java.util.Iterator method */
        solutionlist.remove(currentSolutionNumber);
        // throw new java.lang.UnsupportedOperationException("Method remove() not yet
        // implemented.");
    }

}
