package beans;

import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@Dependent
public class Logging {

    @Inject
    InjectionPoint point;
    
    @Produces
    public Logger getLogger() {
        String className = point.getMember().getDeclaringClass().getName();
        final Logger logger = Logger.getLogger(className);
        return logger;
    }
}