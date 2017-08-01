package com.dms.dao;

import java.util.List;

import com.dms.entity.Part;

public interface DmsDao {
	
	public void addPart(Part part);	 								//添加材料
	public void delPart(int id); 									//删除材料
	public void updatePart(Part part);								//修改材料
	public List<Part> getPart(String keyword,int modelId);			//根据配件号和配件名、车型查询材料
}
