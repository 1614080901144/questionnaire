package com.ahpu.mapper;

import com.ahpu.entity.TitleSubmit;
import com.ahpu.entity.TitleSubmitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleSubmitMapper {
    int countByExample(TitleSubmitExample example);

    int deleteByExample(TitleSubmitExample example);

    int deleteByPrimaryKey(Integer titleid);

    int insert(TitleSubmit record);

    int insertSelective(TitleSubmit record);

    List<TitleSubmit> selectByExample(TitleSubmitExample example);

    TitleSubmit selectByPrimaryKey(Integer titleid);

    int updateByExampleSelective(@Param("record") TitleSubmit record, @Param("example") TitleSubmitExample example);

    int updateByExample(@Param("record") TitleSubmit record, @Param("example") TitleSubmitExample example);

    int updateByPrimaryKeySelective(TitleSubmit record);

    int updateByPrimaryKey(TitleSubmit record);
    
    int updateClickPlusOne(Integer titleid);
}