package com.ahpu.mapper;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.TQuestion;
import com.ahpu.entity.TQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TQuestionMapper {
	
    int countByExample(TQuestionExample example);

    int deleteByExample(TQuestionExample example);

    int deleteByPrimaryKey(Integer qid);

    int insert(TQuestion record);

    int insertSelective(TQuestion record);

    List<TQuestion> selectByExample(TQuestionExample example);

    TQuestion selectByPrimaryKey(Integer qid);

    int updateByExampleSelective(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByExample(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByPrimaryKeySelective(TQuestion record);

    int updateByPrimaryKey(TQuestion record);
    
    List<TQuestion> selectByQuestion(TQuestion question);
    
    List<TQuestion> selectAll(PageBean pageBean);
    
    int getCount();
    
    
}