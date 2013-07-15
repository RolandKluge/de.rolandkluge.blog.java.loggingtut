package de.rolandkluge.blog.java.loggingtut;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Example code for using standard Java logging library.
 *
 * @author Roland Kluge
 *
 */
public class LoggingTutorial
{
    private Logger log;

    public static void main(final String[] args)
    {
        final LoggingTutorial app = new LoggingTutorial();
        app.run();
    }

    public LoggingTutorial()
    {
        try {
            // This may even be used when the application is packaged as a Jar
            final InputStream propertiesInputStream = this.getClass().getClassLoader()
                    .getResourceAsStream("logging.properties");
            LogManager.getLogManager().readConfiguration(propertiesInputStream);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }

        // Class name is conventional name of the logger
        this.log = Logger.getLogger(this.getClass().getName());
    }

    private void run()
    {
        this.log.log(Level.INFO, "This message goes to standard error and to the logfile");
        this.log.log(Level.FINE, "This message only goes to the logfile");
    }

}
