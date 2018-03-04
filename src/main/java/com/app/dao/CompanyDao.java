package com.app.dao;

import com.app.entity.Company;
import com.app.entity.CompanyExample;
import com.app.entity.QueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao {

    /**
     * 根据queryVo分页查询数据
     *
     * @param queryVo
     * @return
     */
    List<Company> selectCompanyListByQueryVo(QueryVo queryVo);

    /**
     * 根据queryVo查询数据条数
     *
     * @param queryVo
     * @return
     */
    int queryCountByQueryVo(QueryVo queryVo);


    int countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}