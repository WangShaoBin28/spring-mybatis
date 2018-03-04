package com.app.controller;


import com.app.entity.Company;
import com.app.entity.QueryVo;
import com.app.service.CompanyService;
import com.app.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company/*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(QueryVo vo, ModelMap modelMap) {
        Page<Company> companyPage = companyService.selectPageByQueryVo(vo);

        modelMap.addAttribute(companyPage);

        modelMap.addAttribute("name", vo.getName());
        modelMap.addAttribute("address", vo.getAddress());
        modelMap.addAttribute("type", vo.getType());
        return "/company/list";
    }

    /**
     * 列表
     */
    @RequestMapping("form")
    public String form(Integer id, ModelMap modelMap) {

        Company company = companyService.selectByPrimaryKey(id);
        if (company == null) {
            company = new Company();
        }
        modelMap.addAttribute(company);

        return "/company/form";
    }

    /**
     * 保存
     */
    @RequestMapping("save")
    public String save(Company company, ModelMap modelMap) {

        int count = companyService.insert(company);

        return "redirect:/company/list";
    }

    //删除
    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id) {
        companyService.deleteByPrimaryKey(id);
        return "OK";
    }
}
