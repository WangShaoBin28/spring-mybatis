package com.app.service;

import com.app.entity.Company;
import com.app.entity.QueryVo;
import com.app.utils.Page;
import org.springframework.stereotype.Service;


public interface CompanyService {

    public Page<Company> selectPageByQueryVo(QueryVo vo);

    public void deleteByPrimaryKey(Integer id);

    public Company selectByPrimaryKey(Integer id);

    public int insert(Company company);
}

