package com.ahpu.mapper;

import com.ahpu.entity.TitleUrl;
import com.ahpu.entity.TitleUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleUrlMapper {
    int countByExample(TitleUrlExample example);

    int deleteByExample(TitleUrlExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(TitleUrl record);

    int insertSelective(TitleUrl record);

    List<TitleUrl> selectByExample(TitleUrlExample example);

    TitleUrl selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") TitleUrl record, @Param("example") TitleUrlExample example);

    int updateByExample(@Param("record") TitleUrl record, @Param("example") TitleUrlExample example);

    int updateByPrimaryKeySelective(TitleUrl record);

    int updateByPrimaryKey(TitleUrl record);
    
    int updateUstateByTid(Integer tid);
    
    TitleUrl selectAllByTid(Integer tid);
    
    TitleUrl selectAllByUrl(TitleUrl titleUrl);
    
    int deleteByTid(Integer tid);
}