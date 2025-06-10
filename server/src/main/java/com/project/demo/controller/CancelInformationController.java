package com.project.demo.controller;

import com.project.demo.entity.CancelInformation;
import com.project.demo.service.CancelInformationService;
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
 * 取消信息：(CancelInformation)表控制层
 *
 */
@RestController
@RequestMapping("/cancel_information")
public class CancelInformationController extends BaseController<CancelInformation, CancelInformationService> {

    /**
     * 取消信息对象
     */
    @Autowired
    public CancelInformationController(CancelInformationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(cancel_information_id) AS max FROM "+"`cancel_information`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `competition_information` INNER JOIN `cancel_information` ON competition_information.project_number=cancel_information.project_number SET competition_information.reportable_number_of_people= competition_information.reportable_number_of_people + cancel_information.number_of_cancellations WHERE cancel_information.cancel_information_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
