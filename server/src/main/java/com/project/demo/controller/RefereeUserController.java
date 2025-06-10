package com.project.demo.controller;

import com.project.demo.entity.RefereeUser;
import com.project.demo.service.RefereeUserService;
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
 * 裁判员用户：(RefereeUser)表控制层
 *
 */
@RestController
@RequestMapping("/referee_user")
public class RefereeUserController extends BaseController<RefereeUser, RefereeUserService> {

    /**
     * 裁判员用户对象
     */
    @Autowired
    public RefereeUserController(RefereeUserService service) {
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
