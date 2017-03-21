package app

import models.Tab
import models.Terminal
import utils.YakuakeEngine

/**
 * Created by hedu on 19/03/17.
 */

class TabsManager {
    public static TabsManager getInstance() {
        if (instance == null) {
            instance = new TabsManager()
        }
        return instance
    }

    public static Tab getDefaultTab() {
        return tabs.get(0)
    }

    public static Tab createTab() {
        Tab tab = new Tab()
        tabs.add(tab);
        return tab;
    }

    public static void addTerminalOnTab(Terminal terminal,int  tabId) {
        for (Tab tab: tabs) {
            if (tab.tabId == tabId) {
                tab.addTerminal(terminal)
            }
        }
    }

    private TabsManager() {
        String yakuakeCommand = "which yakuake".execute().text
        yakuakeCommand.execute();
        tabs = new ArrayList<>();
        for (int tabId: YakuakeEngine.getTabList()) {
            Tab defTab = new Tab(true, tabId);
            tabs.add(defTab)
        }
    }

    private static List<Tab> tabs
    private static TabsManager instance = null
}