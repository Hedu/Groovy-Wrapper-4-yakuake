package utils

import models.Tab
import models.Terminal

/**
 * Created by hedu on 19/03/17.
 */

class YakuakeEngine {
    private static String busInstruction = "qdbus org.kde.yakuake "
    private static String sessionMessage = "/yakuake/sessions "
    private static String tabMessage = "/yakuake/tabs "

    private static String addSession = "org.kde.yakuake.addSession"
    private static String sessionList = "org.kde.yakuake.sessionIdList"
    private static String terminalsInSession = "org.kde.yakuake.terminalIdsForSessionId "
    private static String sessionForTerminal = "org.kde.yakuake.sessionIdForTerminalId "
    private static String runCommand = "runCommandInTerminal "
    private static String topDown = "org.kde.yakuake.splitTerminalTopBottom "
    private static String leftRight = "org.kde.yakuake.splitTerminalLeftRight "
    private static String tabTitle = "setTabTitle "

    private static String executeCommand(String command) {
        System.out.println((busInstruction + command))
        return ["/bin/bash", "-c", busInstruction + command].execute().text
    }

    public static int addSession() {
        return executeCommand(sessionMessage + addSession).trim().toInteger()
    }

    public static int[] getTabList() {
        return executeCommand(sessionMessage + sessionList).trim().split(",")*.toInteger()
    }

    public static int[] getTerminalsInSession(int sessionId) {
        return executeCommand(sessionMessage + terminalsInSession + sessionId).trim().split(",")*.toInteger()
    }

    public static int getTabForTerminal(int terminalId) {
        return executeCommand(sessionMessage + sessionForTerminal + terminalId).trim().toInteger()
    }

    public static void runCommand(Terminal terminal, String command) {
        executeCommand(sessionMessage + runCommand + terminal.terminalId + " \"$command\"")
    }

    public static int splitTopDown(Terminal terminal) {
        return executeCommand(sessionMessage + topDown + terminal.terminalId).trim().toInteger()
    }

    public static int splitLeftRight(Terminal terminal) {
        return executeCommand(sessionMessage + leftRight + terminal.terminalId).trim().toInteger()
    }

    public static void setTitle(Tab tab, String title) {
        executeCommand(tabMessage + tabTitle + tab.tabId +  " $title")
    }
}