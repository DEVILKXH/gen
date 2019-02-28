package com.midea.iapps.${application}.sys;

public final class Configuration extends
		com.midea.iapps.common.sys.BasicConfiguration {

	// 通过Spring signleton bean实例化
	public Configuration(String configFile) {
		super(configFile);
	}

}
