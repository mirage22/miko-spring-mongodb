package com.miko.demo.mongo.controller;

import com.miko.demo.mongo.dto.EntityADTO;
import com.miko.demo.mongo.dto.EntityAListResponseDTO;
import com.miko.demo.mongo.service.EntityAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/5/14
 */
@Controller
@RequestMapping("/api")
public class JSONController {

    @Autowired
    EntityAService entityAService;

    private Logger logger = LoggerFactory.getLogger(JSONController.class);

    @RequestMapping(value = "/entityAList", method = RequestMethod.GET)
    public @ResponseBody
    List<EntityADTO> getEntityAList(Principal principal, HttpServletRequest request,
                                         HttpServletResponse response){


        List<EntityADTO> result = entityAService.findAllDTO();

        logger.debug("getEntityAList = " + result);

        return result;
    }

    @RequestMapping(value = "/entityAListDTO", method = RequestMethod.GET)
    public @ResponseBody
    EntityAListResponseDTO getEntityAListDTO(Principal principal, HttpServletRequest request,
                                          HttpServletResponse response){



        EntityAListResponseDTO result = new EntityAListResponseDTO();
        result.name = "mirage";
        result.status = true;
        result.list = entityAService.findAllDTO();

        logger.debug("getEntityAList = " + result);

        return result;
    }

}
