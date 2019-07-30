/**  
 *
 */
package com.maxh.sloa.util;

import java.util.List;

public class EasyUIDataGridResult<T> {
	/** 总记录数 */
	private long total;

	/** 获得分页内容 */
	private List<T> rows;
	private List<T> footer;
	public EasyUIDataGridResult() {

	}

	public EasyUIDataGridResult(int total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
	public EasyUIDataGridResult(int total, List<T> rows,List<T> footer) {
		this.total = total;
		this.rows = rows;
		this.footer=footer;
	}


	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<T> getFooter() {
		return footer;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}

	@Override
	public String toString() {
		return "ResultPager [total=" + total + ", rows=" + rows + "]";
	}

}
