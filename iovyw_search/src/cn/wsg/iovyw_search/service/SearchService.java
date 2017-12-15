package cn.wsg.iovyw_search.service;

import cn.wsg.iovyw_search.dao.SearchDao;

/**
 * 业务逻辑层
 * @author zhuzhijie
 *
 */
public class SearchService {

	private SearchDao searchDao = new SearchDao();
	
	/**
	 * 根据sn查询dn
	 * @param sn
	 * @return
	 */
	public String findDnBySn(String sn) {
		String dn = searchDao.findDnBySn(sn);
		return dn;
	}
	
	/**
	 * 根据imsi查询dn
	 * @param imsi
	 * @return
	 */
	public String findDnByIMSI(String imsi) {
		String dn = searchDao.findDnByIMSI(imsi);
		return dn;
	}
	
}
