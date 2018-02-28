package com.ahpu.mapper;

import com.ahpu.entity.TGetquestion;
import com.ahpu.entity.TGetquestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGetquestionMapper {
    int countByExample(TGetquestionExample example);

    int deleteByExample(TGetquestionExample example);

    int deleteByPrimaryKey(Integer getid);
    
    int deleteBytitleId(Integer titleId);

    int insert(TGetquestion record);

    int insertSelective(TGetquestion record);

    List<TGetquestion> selectByExample(TGetquestionExample example);

    TGetquestion selectByPrimaryKey(Integer getid);

    int updateByExampleSelective(@Param("record") TGetquestion record, @Param("example") TGetquestionExample example);

    int updateByExample(@Param("record") TGetquestion record, @Param("example") TGetquestionExample example);

    int updateByPrimaryKeySelective(TGetquestion record);

    int updateByPrimaryKey(TGetquestion record);

	List<TGetquestion> selectSubmitUserByTid(Integer id);

	List<TGetquestion> selectBySubmitUser(TGetquestion getQuestion);
}