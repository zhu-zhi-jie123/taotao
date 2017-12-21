package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品服务Controller
 * @author zhuzhijie
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 根据id查询商品
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
}
