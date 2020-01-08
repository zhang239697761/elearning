package com.elearning.framework.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页请求
 * @author Louis
 * @date Jan 12, 2019
 */
public class PageRequest {
	/**
	 * 当前页码
	 */
	private int pageNum = 1;
	/**
	 * 每页数量
	 */
	private int pageSize = 10;
	/**
	 * 查询参数
	 */
	private List<pageParam> params = new ArrayList<>();
	
	public void setParams(List<pageParam> params) {
		this.params = params;
	}
	/**
	 * 查询参数对象
	 * @param name 参数名称
	 * @return
	 */
	public pageParam getParam(String name) {
		for(pageParam param:this.params) {
			if(name != null && name.equals(param.getName())) {
				return param;
			}
		}
		return null;
	}
	/**
	 * 查询参数值
	 * @param name 参数名称
	 * @return
	 */
	public String getParamValue(String name) {
		pageParam param = getParam(name);
		if(param != null) {
			return param.getValue();
		}
		return null;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<pageParam> getParams() {
		return params;
	}

}
