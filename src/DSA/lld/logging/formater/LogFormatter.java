package DSA.lld.logging.formater;

import DSA.lld.logging.LogMessage;

//format the logMessage into plaintext and json
//this is basically the strategy pattern
public interface LogFormatter {
    String format(LogMessage logMessage);
}
