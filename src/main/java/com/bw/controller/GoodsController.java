package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.GoodsKind;
import com.bw.service.GoodsService;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {
	
	@Resource
	private GoodsService goodsService;
	
	
	@RequestMapping("/list")
	public ModelAndView queryAll(@RequestParam(defaultValue="1")Integer pageNum) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		
		PageHelper.startPage(pageNum, 3);
		List<Goods> list = goodsService.queryAll(map);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		
		mv.setViewName("list");
		mv.getModel().put("page", page);
		return mv;
	}
	
	
	@RequestMapping("queryBrandList")
	@ResponseBody
	public List<Brand> queryBrandList(Brand brand) {
		List<Brand> brandList = goodsService.queryBrandList(brand);
		return brandList;
	}
	
	
	@RequestMapping("queryKindList")
	@ResponseBody
	public List<GoodsKind> queryKindList(GoodsKind kind) {
		List<GoodsKind> kindList = goodsService.queryKindList(kind);
		return kindList;
	}
	
	
	@RequestMapping("insertGoods")
	public String insertGoods(Goods goods, MultipartFile photo) throws Exception {
		String upload = FileUtils.upload(photo);
		goods.setPicurl(upload);
		Integer add = goodsService.insertGoods(goods);
		if (add > 0) {
			return "redirect:/list";
		} else {
			return "add";
		}
	}
	
	
	@RequestMapping("lookingImg")
	public void lookingImg(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileUtils.download(path, request, response);
	}
	
	
	@RequestMapping("deleteGoods")
	@ResponseBody
	public Integer deleteGoods(String gids) {
		Integer del = goodsService.deleteGoods(gids);
		return del;
	}
	
	
	@RequestMapping("queryGoodsById")
	@ResponseBody
	public Goods queryGoodsById(Integer gid) {
		Goods goods = goodsService.queryGoodsById(gid);
		return goods;
	}
	
	
	@RequestMapping("updateGoods")
	public String updateGoods(Goods goods, MultipartFile photo) throws Exception {
		String upload = FileUtils.upload(photo);
		goods.setPicurl(upload);
		Integer update = goodsService.updateGoods(goods);
		if (update > 0) {
			return "redirect:/list";
		} else {
			return "update";
		}
	}
	
	
	
	
	
	
	
	

}
