package com.houfalyu.mmall.mapper;

import com.houfalyu.mmall.entity.MmallUser;
import com.houfalyu.mmall.entity.MmallUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MmallUserMapper {
    long countByExample(MmallUserExample example);

    int deleteByExample(MmallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmallUser record);

    int insertSelective(MmallUser record);

    List<MmallUser> selectByExample(MmallUserExample example);

    MmallUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmallUser record, @Param("example") MmallUserExample example);

    int updateByExample(@Param("record") MmallUser record, @Param("example") MmallUserExample example);

    int updateByPrimaryKeySelective(MmallUser record);

    int updateByPrimaryKey(MmallUser record);

    MmallUser validateByCondition(@Param("params") Map<String,String> paramsMap);

    MmallUser validateByUsername(String username);

    MmallUser validateByPhone(String phone);

    String selectQuestionByUsername(String username);
}