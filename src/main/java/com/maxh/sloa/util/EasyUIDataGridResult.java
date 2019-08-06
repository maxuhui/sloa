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
}
