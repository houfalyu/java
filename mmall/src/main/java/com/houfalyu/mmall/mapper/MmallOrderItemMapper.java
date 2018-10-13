package com.houfalyu.mmall.mapper;

import com.houfalyu.mmall.entity.MmallOrderItem;
import com.houfalyu.mmall.entity.MmallOrderItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MmallOrderItemMapper {
    long countByExample(MmallOrderItemExample example);

    int deleteByExample(MmallOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmallOrderItem record);

    int insertSelective(MmallOrderItem record);

    List<MmallOrderItem> selectByExample(MmallOrderItemExample example);

    MmallOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmallOrderItem record, @Param("example") MmallOrderItemExample example);

    int updateByExample(@Param("record") MmallOrderItem record, @Param("example") MmallOrderItemExample example);

    int updateByPrimaryKeySelective(MmallOrderItem record);

    int updateByPrimaryKey(MmallOrderItem record);
}