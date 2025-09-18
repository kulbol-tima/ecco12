package kg.mlsp.common.controller;

import kg.mlsp.common.model.ModuleInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommonInfoController {

    @GetMapping("/info")
    public ModuleInfo getInfo() {

        var moduleInfo = new ModuleInfo();
        //moduleInfo.setName("Common Module");
        //moduleInfo.setVersion("1.0.0");
        //moduleInfo.setDescription("This module provides common functionalities for the application.");

        return moduleInfo;
    }

}