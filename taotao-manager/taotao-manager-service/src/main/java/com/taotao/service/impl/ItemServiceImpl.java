package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品服务实现类
 * @author zhuzhijie
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	/**
	 * 根据商品id查询
	 */
	@Override
	public TbItem getItemById(long itemId) {
		TbItem TbItem = itemMapper.selectByPrimaryKey(itemId);
		return TbItem;
	}

}
