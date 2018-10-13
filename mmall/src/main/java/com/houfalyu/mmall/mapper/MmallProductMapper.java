package com.houfalyu.mmall.mapper;

import com.houfalyu.mmall.entity.MmallProduct;
import com.houfalyu.mmall.entity.MmallProductExample;
import com.houfalyu.mmall.entity.MmallProductWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MmallProductMapper {
    long countByExample(MmallProductExample example);

    int deleteByExample(MmallProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmallProductWithBLOBs record);

    int insertSelective(MmallProductWithBLOBs record);

    List<MmallProductWithBLOBs> selectByExampleWithBLOBs(MmallProductExample example);

    List<MmallProduct> selectByExample(MmallProductExample example);

    MmallProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmallProductWithBLOBs record, @Param("example") MmallProductExample example);

    int updateByExampleWithBLOBs(@Param("record") MmallProductWithBLOBs record, @Param("example") MmallProductExample example);

    int updateByExample(@Param("record") MmallProduct record, @Param("example") MmallProductExample example);

    int updateByPrimaryKeySelective(MmallProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MmallProductWithBLOBs record);

    int updateByPrimaryKey(MmallProduct record);
}