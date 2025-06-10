package com.project.demo.controller;

import com.project.demo.entity.CompetitionInformation;
import com.project.demo.service.CompetitionInformationService;
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
 * 比赛信息：(CompetitionInformation)表控制层
 *
 */
@RestController
@RequestMapping("/competition_information")
public class CompetitionInformationController extends BaseController<CompetitionInformation, CompetitionInformationService> {

    /**
     * 比赛信息对象
     */
    @Autowired
    public CompetitionInformationController(CompetitionInformationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
