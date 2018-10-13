package com.houfalyu.mmall.mapper;

import com.houfalyu.mmall.entity.MmallCategory;
import com.houfalyu.mmall.entity.MmallCategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MmallCategoryMapper {
    long countByExample(MmallCategoryExample example);

    int deleteByExample(MmallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmallCategory record);

    int insertSelective(MmallCategory record);

    List<MmallCategory> selectByExample(MmallCategoryExample example);

    MmallCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmallCategory record, @Param("example") MmallCategoryExample example);

    int updateByExample(@Param("record") MmallCategory record, @Param("example") MmallCategoryExample example);

    int updateByPrimaryKeySelective(MmallCategory record);

    int updateByPrimaryKey(MmallCategory record);
}