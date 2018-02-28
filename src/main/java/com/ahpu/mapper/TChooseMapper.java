package com.ahpu.mapper;

import com.ahpu.entity.TChoose;
import com.ahpu.entity.TChooseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChooseMapper {
    int countByExample(TChooseExample example);

    int deleteByExample(TChooseExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TChoose record);

    int insertSelective(TChoose record);

    List<TChoose> selectByExample(TChooseExample example);

    TChoose selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TChoose record, @Param("example") TChooseExample example);

    int updateByExample(@Param("record") TChoose record, @Param("example") TChooseExample example);

    int updateByPrimaryKeySelective(TChoose record);

    int updateByPrimaryKey(TChoose record);
    
    List<TChoose> getChooseByQid(int qId);
    
    int deleteChooseByQid(Integer qid);
    
    int selectCountByQid(Integer qid);
    
}