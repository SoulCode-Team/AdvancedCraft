package JohnTheAwsome123.mods.AdvancedCraft.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;

import cpw.mods.fml.common.FMLLog;

/**ACLog
 * @mod AdvancedCraft
 * 
 * @author JohnTheAwsome123
 */
public class ACLogger {
	public static final Logger logger = Logger.getLogger("AdvancedCraft");

	public static void initLog() {
		logger.setParent(FMLLog.getLogger());
		logger.info("Starting BuildCraft " + Reference.VERSION_NUMBER);
		logger.info("Copyright (c) JohnTheAwsome, 2014");
	}

	public static void logErrorAPI(String mod, Throwable error, Class classFile) {
		StringBuilder msg = new StringBuilder(mod);
		msg.append(" API error, please update your mods. Error: ").append(error);
		StackTraceElement[] stackTrace = error.getStackTrace();
		if (stackTrace.length > 0)
			msg.append(", ").append(stackTrace[0]);
		logger.log(Level.SEVERE, msg.toString());

		if (classFile != null) {
			msg = new StringBuilder(mod);
			msg.append(" API error: ").append(classFile.getSimpleName()).append(" is loaded from ").append(classFile.getProtectionDomain().getCodeSource().getLocation());
			logger.log(Level.SEVERE, msg.toString());
		}
	}
	
	/**
	 * 
	 * @param level (SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, OFF, ALL)
	 * @param msg
	 */
	public static void Log(Level level, String msg)
	{
		logger.log(level, msg.toString());
	}
	
	/**
	 * 
	 * @param level auto INFO
	 * @param msg
	 */
	public static void Log(String msg)
	{
		logger.info(msg.toString());
	}
}
