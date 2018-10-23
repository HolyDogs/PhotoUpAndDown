package com.me.mapper;

import com.me.pojo.Lover;
import com.me.pojo.LoverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoverMapper {
    long countByExample(LoverExample example);

    int deleteByExample(LoverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lover record);

    int insertSelective(Lover record);

    List<Lover> selectByExampleWithBLOBs(LoverExample example);

    List<Lover> selectByExample(LoverExample example);

    Lover selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lover record, @Param("example") LoverExample example);

    int updateByExampleWithBLOBs(@Param("record") Lover record, @Param("example") LoverExample example);

    int updateByExample(@Param("record") Lover record, @Param("example") LoverExample example);

    int updateByPrimaryKeySelective(Lover record);

    int updateByPrimaryKeyWithBLOBs(Lover record);

    int updateByPrimaryKey(Lover record);
}