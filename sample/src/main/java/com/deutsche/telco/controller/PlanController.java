package com.deutsche.telco.controller;

import com.deutsche.telco.model.DevicePlan;
import com.deutsche.telco.model.RechargePlan;
import com.deutsche.telco.model.User;
import com.deutsche.telco.repository.DevicePlanRespository;
import com.deutsche.telco.repository.RechargePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private DevicePlanRespository devicePlanRespository;

    @Autowired
    private RechargePlanRepository rechargePlanRepository;

    @PostMapping("/add-device-plan")
    @PermitAll
    public List<DevicePlan> addDevicePlan(@RequestBody List<DevicePlan> devicePlanList){
        return devicePlanRespository.saveAll(devicePlanList);
    }

    @PostMapping("/add-recharge-plan")
    @PermitAll
    public List<RechargePlan> addRechargePlan(@RequestBody List<RechargePlan> rechargePlanList){
        return rechargePlanRepository.saveAll(rechargePlanList);
    }

    @GetMapping("/get-device-plans")
    @PermitAll
    public List<DevicePlan> getAllDevicePlans(){
        List<DevicePlan> plans = devicePlanRespository.findAll();
        return plans;
    }

    @GetMapping("/get-recharge-plans")
    @PermitAll
    public List<RechargePlan> getAllRechargePlans(){
        List<RechargePlan> plans = rechargePlanRepository.findAll();
        return plans;
    }
}
