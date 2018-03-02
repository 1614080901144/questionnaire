package com.ahpu.mapper;

import com.ahpu.entity.TitleQuestionExample;
import com.ahpu.entity.TitleQuestionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleQuestionMapper {
	
    int countByExample(TitleQuestionExample example);

    int deleteByExample(TitleQuestionExample example);

    int deleteByPrimaryKey(TitleQuestionKey key);

    int insert(TitleQuestionKey record);

    int insertSelective(TitleQuestionKey record);

    List<TitleQuestionKey> selectByExample(TitleQuestionExample example);

    int updateByExampleSelective(@Param("record") TitleQuestionKey record, @Param("example") TitleQuestionExample example);

    int updateByExample(@Param("record") TitleQuestionKey record, @Param("example") TitleQuestionExample example);
    
    List<TitleQuestionKey> selectByPrimaryKey(int id);
}