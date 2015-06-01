package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Huiyi on 2015/5/30.
 */
@Controller
@RequestMapping(value = Constants.REST + "/validation")
public class ValidationController {

    private final ValidationService validationService;

    @Autowired
    public ValidationController(final ValidationService validationService) {
        this.validationService = validationService;
    }

    @RequestMapping(value = "relation", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String validateRelation(@RequestBody Map<String, Integer> params) {
        return validationService.validateRelation(params);
    }
}
