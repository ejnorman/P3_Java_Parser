package all.TreePackage;
/**
 A class of runtime exceptions thrown by methods to
 indicate that a tree is empty.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class EmptyTreeException extends RuntimeException
{
    public EmptyTreeException()
    {
        this(null);
    } // end default constructor

    public EmptyTreeException(String message)
    {
        super(message);
    } // end constructor
} // end EmptyTreeException
