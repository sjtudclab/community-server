package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.LivingCard;
import cn.edu.sjtu.se.dclab.server.entity.NetCard;
import cn.edu.sjtu.se.dclab.server.entity.PartyCard;
import cn.edu.sjtu.se.dclab.server.service.LivingCardService;
import cn.edu.sjtu.se.dclab.server.service.NetCardService;
import cn.edu.sjtu.se.dclab.server.service.PartyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kevin on 15-8-13.
 */
@Controller
@RequestMapping(value = Constants.REST + "/infocard/")
public class InfoCardController {
    @Autowired
    private NetCardService netCardService;
    @Autowired
    private LivingCardService livingCardService;
    @Autowired
    private PartyCardService partyCardService;

    @RequestMapping(value = "netcard/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NetCard getNetCard(@PathVariable(value = "id") long id) {
        return netCardService.getNetCardByUserId(id);
    }

    @RequestMapping(value = "livingcard/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LivingCard getLivingCard(@PathVariable(value = "id") long id) {
        return livingCardService.getLivingCardByUserId(id);
    }

    @RequestMapping(value = "partycard/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PartyCard getPartyCard(@PathVariable(value = "id")long userId) {
        return partyCardService.getPartyCardByUserId(userId);
    }
}
