package org.one2team.highcharts.server;

import org.one2team.highcharts.shared.Credits;

public class JSMCredits extends JSMBaseObject implements Credits {

	@Override
	public JSMCredits setEnabled(boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public boolean istEnabled() {
		return enabled;
	}
	
	private Boolean enabled;

}
