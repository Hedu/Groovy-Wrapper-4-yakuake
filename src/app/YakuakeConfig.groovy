package app

/**
 * Created by hedu on 20/03/17.
 */
def tabsManager = TabsManager.getInstance();
def tab1 = tabsManager.getDefaultTab()
tab1.setName("FIRST")
def firstTerm = tab1.getDefaultTerminal()
def secondTerm = firstTerm.splitUpDown()

firstTerm.executeCommand("ls")
secondTerm.executeCommand("top")

def tab2 = TabsManager.getInstance().createTab()
tab2.setName("SECOND")
def t2t1 = tab2.getDefaultTerminal()
t2t1.executeCommand("cd /tmp")


tabsManager.tabs.each {tab ->
    println "Tab -> ${tab.tabId}"
    tab.terminals.each { terminal ->
        println "Terminal -> ${terminal.terminalId}"
    }
}
