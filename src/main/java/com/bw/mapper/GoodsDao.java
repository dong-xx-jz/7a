package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.GoodsKind;

public interface GoodsDao {
	
	List<Goods> queryAll(Map<String, Object> map);

	List<Brand> queryBrandList(Brand brand);

	List<GoodsKind> queryKindList(GoodsKind kind);

	Integer insertGoods(Goods goods);

	Integer deleteGoods(String gids);

	Goods queryGoodsById(Integer gid);

	Integer updateGoods(Goods goods);

}
