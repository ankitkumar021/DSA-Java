package DSA.lld.logging.formater;

import DSA.lld.logging.LogMessage;

import java.util.Date;

public class PlainTextFormatter implements LogFormatter {
    @Override
    public String format(LogMessage logMessage) {
                return String.format(" %s [%s]: %s",
                new Date(logMessage.getTimestamp()),
                        logMessage.getLevel(),
                        logMessage.getMessage());
    }
//    private static final DateTimeFormatter FORMATTER =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    @Override
//    public String format(LogMessage message) {
//        String formattedTime = LocalDateTime.ofInstant(
//                Instant.ofEpochMilli(message.getTimestamp()),
//                ZoneId.systemDefault()
//        ).format(FORMATTER);
//
//        return String.format("%s [%s] - %s", formattedTime, message.getLevel(),
//                message.getMessage());
//    }
}
