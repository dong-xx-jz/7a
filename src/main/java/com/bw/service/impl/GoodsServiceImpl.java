package com.bw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.GoodsKind;
import com.bw.mapper.GoodsDao;
import com.bw.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Resource
	private GoodsDao dao;

	public List<Goods> queryAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryAll(map);
	}

	public List<Brand> queryBrandList(Brand brand) {
		// TODO Auto-generated method stub
		return dao.queryBrandList(brand);
	}

	public List<GoodsKind> queryKindList(GoodsKind kind) {
		// TODO Auto-generated method stub
		return dao.queryKindList(kind);
	}

	public Integer insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.insertGoods(goods);
	}

	public Integer deleteGoods(String gids) {
		// TODO Auto-generated method stub
		return dao.deleteGoods(gids);
	}

	public Goods queryGoodsById(Integer gid) {
		// TODO Auto-generated method stub
		return dao.queryGoodsById(gid);
	}

	public Integer updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.updateGoods(goods);
	}

}
