package com.app.service.impl;

import com.app.dao.CompanyDao;
import com.app.entity.Company;
import com.app.entity.QueryVo;
import com.app.service.CompanyService;
import com.app.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CompanyImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;


    //根据四个条件 当前页  返回分页对象
    public Page<Company> selectPageByQueryVo(QueryVo vo) {
        //创建分页对象
        Page<Company> page = new Page<Company>();
        //当前页
        page.setPage(vo.getPage());
        //每页显示条数
        page.setSize(8);
        vo.setSize(8);

        if (null != vo) {
            if (null != vo.getName()) {
                if ("".equals(vo.getName().trim())) {
                    vo.setName(null);
                } else {
                    vo.setName(vo.getName().trim());
                }
            }

            if (null != vo.getAddress()) {
                if ("".equals(vo.getAddress().trim())) {
                    vo.setAddress(null);
                } else {
                    vo.setAddress(vo.getAddress().trim());
                }
            }
            if (null != vo.getType()) {
                if ("".equals(vo.getType().trim())) {
                    vo.setType(null);
                } else {
                    vo.setType(vo.getType().trim());
                }
            }

        }
        //总条数
        page.setTotal(companyDao.queryCountByQueryVo(vo));

        //结果集
        //计算开始行
        vo.setStartRow((vo.getPage() - 1) * vo.getSize());
        List<Company> companyList = companyDao.selectCompanyListByQueryVo(vo);
        page.setRows(companyList);

        return page;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Company selectByPrimaryKey(Integer id) {

        return companyDao.selectByPrimaryKey(id);
    }

    /**
     * 添加
     *
     * @param company
     * @return
     */
    public int insert(Company company) {
        return companyDao.insert(company);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteByPrimaryKey(Integer id) {
        companyDao.deleteByPrimaryKey(id);
    }


}
