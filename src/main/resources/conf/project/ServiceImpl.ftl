package com.midea.iapps.${application}.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.midea.iapps.common.service.impl.CommonServiceImpl;

public class ${formatApplication}ServiceImpl extends CommonServiceImpl {

	protected static final String ${upperApplication}_TXN_MANAGER = "txn_${application}";
	@Resource(name = "txn_${application}")
	protected DataSourceTransactionManager txn_${application};
	@Resource(name = "st_${application}")
	protected SqlSessionTemplate st_${application};

}
