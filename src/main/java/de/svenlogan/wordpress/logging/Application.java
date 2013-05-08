package de.svenlogan.wordpress.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Application
{
    private Logger log;

    public Application()
    {
        try {
            LogManager.getLogManager().readConfiguration(
                    this.getClass().getClassLoader().getResourceAsStream("logging.properties"));
        }
        catch (final Exception e) {
            e.printStackTrace();
        }

        this.log = Logger.getLogger(this.getClass().getName());
    }

    private void run()
    {
        this.log.log(Level.INFO, "This message goes to standard error and to the logfile");
        this.log.log(Level.FINE, "This message only goes to the logfile");
    }

    public static void main(final String[] args)
    {
        final Application app = new Application();
        app.run();
    }

}
