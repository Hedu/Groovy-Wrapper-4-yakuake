package models

import utils.YakuakeEngine

/**
 * Created by hedu on 19/03/17.
 */

class Tab {
    int tabId

    protected Tab(boolean defaultTab = false, int defaultTabId = 0) {
        if (defaultTab) {
            tabId = defaultTabId
        }
        else {
            tabId = YakuakeEngine.addSession();
        }

        for (int termialId: YakuakeEngine.getTerminalsInSession(tabId)) {
            System.out.println(termialId)
            Terminal terminal =  new Terminal(termialId)
            terminals.add(terminal)
        }

    }

    public Terminal getDefaultTerminal() {
        return terminals?.get(0)
    }

    public List<Terminal> getTerminals() {
        return terminals
    }

    public void setName(String name) {
        YakuakeEngine.setTitle(this, name)
        this.name = name
    }

    public void addTerminal(Terminal terminal) {
        terminals.add(terminal)
    }

    List<Terminal> terminals = new ArrayList<>()

    String name
}