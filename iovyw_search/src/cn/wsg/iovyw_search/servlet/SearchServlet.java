package cn.wsg.iovyw_search.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.wsg.iovyw_search.service.SearchService;

/**
 * 控制层
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	
	private SearchService searchService = new SearchService();

	/**
	 * 处理doPost请求
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到传递过来的ismi或sn
		String ismi_or_sn = request.getParameter("ISMI_or_SN");
		String dn = null;
		//判断输入框是否为空
		if(ismi_or_sn==null || ismi_or_sn.equals("")) {
			request.setAttribute("msg", "输入框不能为空！！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//判断长度是否正确
		if((ismi_or_sn.length()!=6) && (ismi_or_sn.length()!=15)) {
			request.setAttribute("msg", "输入的长度不正确！！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//判断格式是否正确
		if(!ismi_or_sn.matches("[A-Za-z0-9]+")) {
			request.setAttribute("msg", "输入的格式不正确，只能包含数字和字母!!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//如果字符串长度为6则为sn,否则为imsi
		if(ismi_or_sn.length() == 6) {
			dn = this.dnToCompany(searchService.findDnBySn(ismi_or_sn));
			request.setAttribute("msg", dn);
			request.setAttribute("SN", ismi_or_sn);
			if(dn.equals("您查找的数据不存在！")) {
				request.setAttribute("code", 0);
			} else {
				request.setAttribute("code", 1);
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		} else {
			dn = this.dnToCompany(searchService.findDnByIMSI(ismi_or_sn));
			request.setAttribute("msg", dn);
			request.setAttribute("ISMI", ismi_or_sn);
			if(dn.equals("您查找的数据不存在！")) {
				request.setAttribute("code", 0);
			} else {
				request.setAttribute("code", 1);
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
	}
	
	/**
	 * 将域名转换成公司名
	 * @return
	 */
	private String dnToCompany(String dn) {
		if(dn==null) {
			return "您查找的数据不存在！";
		} else if(dn.equals("mt.iovyw.com")) {
			return "咪咕音乐";
		} else if(dn.equals("yx.iovyw.com")) {
			return "货车帮";
		} else if(dn.equals("jfei.iovyw.com")) {
			return "云AC管理平台";
		} else if(dn.equals("hs.iovyw.com")) {
			return "慧商";
		} else if(dn.equals("test.iovyw.com")) {
			return "微思格";
		} else if(dn.equals("wc.iovyw.com")) {
			return "文骋";
		} else if(dn.equals("30kt.iovyw.com")) {
			return "三零凯天";
		} else if(dn.equals("hooenergy.iovyw.com")) {
			return "汇能";
		} else if(dn.equals("xjhb.iovyw.com")) {
			return "新疆浩博";
		} else if(dn.equals("gem.iovyw.com")){
			return "格尔木盐湖";
		}
		return "";
	}

}






