package com.project.demo.controller;

import com.project.demo.entity.RegistrationInformation;
import com.project.demo.service.RegistrationInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


/**
 * 报名信息：(RegistrationInformation)表控制层
 *
 */
@RestController
@RequestMapping("/registration_information")
public class RegistrationInformationController extends BaseController<RegistrationInformation, RegistrationInformationService> {

    /**
     * 报名信息对象
     */
    @Autowired
    public RegistrationInformationController(RegistrationInformationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(registration_information_id) AS max FROM "+"`registration_information`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `competition_information` INNER JOIN `registration_information` ON competition_information.project_number=registration_information.project_number WHERE competition_information.reportable_number_of_people < registration_information.number_of_applicants AND registration_information.registration_information_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"registration_information"+" WHERE "+"registration_information_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"剩余可报人数不足!");
        }
        sql = "UPDATE `competition_information` INNER JOIN `registration_information` ON competition_information.project_number=registration_information.project_number SET competition_information.reportable_number_of_people= competition_information.reportable_number_of_people - registration_information.number_of_applicants WHERE registration_information.registration_information_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
