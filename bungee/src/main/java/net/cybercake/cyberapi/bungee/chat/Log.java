package net.cybercake.cyberapi.bungee.chat;

import net.cybercake.cyberapi.bungee.CyberAPI;
import net.cybercake.cyberapi.bungee.Validators;
import net.md_5.bungee.api.ProxyServer;

import java.util.logging.Level;

public class Log {

    /**
     * Logs an "[INFO]" message to the console, typically in the default color
     * @param message the message to log
     * @since 15
     */
    public static void info(String message) { log(Level.INFO, message); }

    /**
     * Logs a "[WARN]" message to the console, typically in yellow
     * @param message the message to log
     * @since 15
     */
    public static void warn(String message) { log(Level.WARNING, message); }

    /**
     * Logs a "[ERROR]" message to the console, typically in red, also known as "SEVERE"
     * @param message the message to log
     * @since 15
     */
    public static void error(String message) { log(Level.SEVERE, message); }

    /**
     * Log at whatever level you want to the console
     * @param level the level at which to log
     * @param message the message to log
     * @since 15
     */
    public static void log(Level level, String message) {
        try {
            CyberLogEvent logEvent = new CyberLogEvent(Class.forName(Validators.getCaller()), level, (Boolean.TRUE.equals(CyberAPI.getInstance().getSettings().shouldShowPrefixInLogs()) ? "[" + CyberAPI.getInstance().getPrefix() + "] " : null), message);
            ProxyServer.getInstance().getPluginManager().callEvent(logEvent);
            if (logEvent.isCancelled()) return;
            CyberAPI.getInstance().getLogger().log(logEvent.getLevel(), UChat.chat((logEvent.getPrefix() == null ? "" : logEvent.getPrefix()) + logEvent.getMessage()));
        } catch (Exception exception) {
            throw new IllegalStateException("Error occurred whilst logging in " + Log.class.getCanonicalName() + " (potential caller: " + Validators.getCaller() + ")", exception);
        }
    }
}