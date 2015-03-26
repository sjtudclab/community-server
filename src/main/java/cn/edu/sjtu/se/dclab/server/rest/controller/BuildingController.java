package cn.edu.sjtu.se.dclab.server.rest.controller;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.Building;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.service.ApartmentService;
import cn.edu.sjtu.se.dclab.server.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/16.
 */
@Controller
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private ApartmentService apartmentService;

    public BuildingService getBuildingService() {
        return buildingService;
    }

    public void setBuildingService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Building> findAll() {
        return getBuildingService().findAll();
    }

    @RequestMapping(value = "{id}/apartments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Apartment> findApartmentsByBuildingId(@PathVariable(value = "id") long buildingId) {
        return apartmentService.findAllByBuildingId(buildingId);
    }

    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    public void setApartmentService(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }
}
