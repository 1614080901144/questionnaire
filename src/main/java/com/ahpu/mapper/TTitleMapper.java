package com.ahpu.mapper;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.TTitle;
import com.ahpu.entity.TTitleExample;
import com.ahpu.entity.TidAndState;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTitleMapper {
	
    int countByExample(TTitleExample example);

    int deleteByExample(TTitleExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TTitle record);

    int insertSelective(TTitle record);

    List<TTitle> selectByExample(TTitleExample example);

    TTitle selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TTitle record, @Param("example") TTitleExample example);

    int updateByExample(@Param("record") TTitle record, @Param("example") TTitleExample example);

    int updateByPrimaryKeySelective(TTitle record);

    int updateByPrimaryKey(TTitle record);
    
    List<TTitle> selectAll(PageBean pageBean);
    
    int getCount(PageBean pageBean);
    
    int updateStateByTid(TTitle title);
    
    
    
}