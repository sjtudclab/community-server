package cn.edu.sjtu.se.dclab.server.controller;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    public void setApartmentService(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Apartment> findAll() {
        return apartmentService.findAll();
    }
}
