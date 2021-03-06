package com.dms.dao;

import java.util.List;

import com.dms.entity.Part;

public interface PartDao {
	//配件操作
	public Integer addPart(Part part);	 		//添加材料
	public void delPart(Integer id); 			//删除材料
	public void updatePart(Part part);		//修改材料
	public List<Part> getPart(Part part);	//根据配件号和配件名、车型查询材料
	public Part getPartById(Integer partId);
}
