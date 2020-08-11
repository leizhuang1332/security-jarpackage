//package com.lz.controller;
//
//import com.youzidata.security.Bootstrapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MainController {
//    @Autowired
//    Bootstrapper bootstrapper;
//
//    @GetMapping("vip/{id}")
//    public Object vip(@PathVariable("id") String id) {
//        return "vip" + id;
//    }
//
//    @GetMapping("RefreshPermissions")
//    public Object refreshPermissions(){
//        bootstrapper.loadAuthority();
//        return "Refresh success";
//    }
//}
