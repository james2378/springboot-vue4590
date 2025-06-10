package com.project.demo.controller;

import com.project.demo.entity.AthleteUsers;
import com.project.demo.service.AthleteUsersService;
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
 * 运动员用户：(AthleteUsers)表控制层
 *
 */
@RestController
@RequestMapping("/athlete_users")
public class AthleteUsersController extends BaseController<AthleteUsers, AthleteUsersService> {

    /**
     * 运动员用户对象
     */
    @Autowired
    public AthleteUsersController(AthleteUsersService service) {
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
