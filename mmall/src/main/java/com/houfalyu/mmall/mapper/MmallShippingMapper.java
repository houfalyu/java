package com.houfalyu.mmall.mapper;

import com.houfalyu.mmall.entity.MmallShipping;
import com.houfalyu.mmall.entity.MmallShippingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MmallShippingMapper {
    long countByExample(MmallShippingExample example);

    int deleteByExample(MmallShippingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmallShipping record);

    int insertSelective(MmallShipping record);

    List<MmallShipping> selectByExample(MmallShippingExample example);

    MmallShipping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmallShipping record, @Param("example") MmallShippingExample example);

    int updateByExample(@Param("record") MmallShipping record, @Param("example") MmallShippingExample example);

    int updateByPrimaryKeySelective(MmallShipping record);

    int updateByPrimaryKey(MmallShipping record);
}