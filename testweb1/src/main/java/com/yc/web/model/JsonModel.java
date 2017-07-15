package com.yc.web.model;

import java.io.Serializable;
import java.util.List;

public class JsonModel<T> implements Serializable {
	private static final long serialVersionUID = 5945879745143254857L;
	
	private Integer code;	//操作状态码：1表示成功  2表示失败
	private String msg;		//信息
	private Object obj;		//对象
	private String url;		//下一步要去的页面
	
	private Integer total;		//总记录数
	private Integer	pages;		//：当前为第几页
	private Integer	pageSize;	//：每页多少条
	private List<T>	rows;		//记录集合
	
	
	public JsonModel(Integer code, String msg, Object obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}
	public JsonModel() {
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", msg=" + msg + ", obj=" + obj + ", url=" + url + ", total=" + total
				+ ", pages=" + pages + ", pagesize=" + pageSize + ", rows=" + rows + "]";
	}
	

}
