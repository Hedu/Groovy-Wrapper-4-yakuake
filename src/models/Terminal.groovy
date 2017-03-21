package models

import app.TabsManager
import utils.YakuakeEngine

class Terminal {
	int terminalId


	Terminal(int terminalId) {
		this.terminalId = terminalId;
	}

	public void executeCommand(String command) {
		YakuakeEngine.runCommand(this, command)
	}

	public Terminal splitUpDown() {
		Terminal terminal = new Terminal(YakuakeEngine.splitTopDown(this))
		int tabId = YakuakeEngine.getTabForTerminal(terminal.terminalId)
		TabsManager.getInstance().addTerminalOnTab(terminal, tabId)
		return terminal
	}

	public Terminal splitLeftRight() {
		Terminal terminal = new Terminal(YakuakeEngine.splitLeftRight(this))
		int tabId = YakuakeEngine.getTabForTerminal(terminal.terminalId)
		TabsManager.getInstance().addTerminalOnTab(terminal, tabId)
		return terminal
	}
}
