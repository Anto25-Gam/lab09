package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Set the next string  to print.
     * 
     * @param string the new string
     */
    void setNextString(String string);

    /**
     * Get the current string.
     * 
     * @return current set string
     */
    String getNextStringToPrint();

    /**
     * Return the history printed strings.
     * 
     * @return list of printed string.
     */
    List<String> getHistoryPrintedString();

    /**
     * Print the string.
     */
    void printsCurrentString();
}
