package com.houfalyu.mmall.mapper;

import com.houfalyu.mmall.entity.MmallOrder;
import com.houfalyu.mmall.entity.MmallOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MmallOrderMapper {
    long countByExample(MmallOrderExample example);

    int deleteByExample(MmallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmallOrder record);

    int insertSelective(MmallOrder record);

    List<MmallOrder> selectByExample(MmallOrderExample example);

    MmallOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmallOrder record, @Param("example") MmallOrderExample example);

    int updateByExample(@Param("record") MmallOrder record, @Param("example") MmallOrderExample example);

    int updateByPrimaryKeySelective(MmallOrder record);

    int updateByPrimaryKey(MmallOrder record);
}