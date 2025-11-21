package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String current; 
    private final List<String> history = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextString(final String string) {
        if (Objects.isNull(string)) {
            throw new IllegalArgumentException("error string unset");
        }
        this.current = string;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextStringToPrint() {
        return this.current;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHistoryPrintedString() {
        return Collections.unmodifiableList(history);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printsCurrentString() {
        if (Objects.isNull(getNextStringToPrint())) {
            throw new IllegalStateException("current string is unset");
        }
        System.out.println(getNextStringToPrint()); //NOPMD the exercises require to consider only standard output.
        history.addLast(getNextStringToPrint());
    }
}
