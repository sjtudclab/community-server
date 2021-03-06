package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.service.ApartmentService;
import cn.edu.sjtu.se.dclab.server.transfer.ApartmentTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Controller
@RequestMapping(Constants.REST + "/apartment")
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

    @RequestMapping(value = "{id}/citizen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<ResidentCitizen> findUserByApartmentId(@PathVariable(value = "id") long id) {
        return apartmentService.findAllCitizenByApartmentId(id);
    }
}
