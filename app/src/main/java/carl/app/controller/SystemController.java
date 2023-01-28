package carl.app.controller;

import carl.app.dto.UserEditDTO;
import carl.app.dto.UserLoginDTO;
import carl.app.dto.UserRegisterDTO;
import carl.app.service.AnimalApplicationService;
import carl.app.service.CommunicationApplicationService;
import carl.app.service.UserApplicationService;

import carl.app.vo.UserInfoVO;
import carl.common.enums.ActionEnum;
import carl.domain.user.aggregate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @className: SystemController
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/1 20:41
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    CommunicationApplicationService communicationApplicationService;

    @Autowired
    AnimalApplicationService animalApplicationService;

    @Autowired
    UserApplicationService userApplicationService;

    @PostMapping("/register")
    @ResponseBody
    public ActionEnum register(@RequestBody UserRegisterDTO userRegisterDTO) {
        userApplicationService.registerUser(userRegisterDTO);
        return ActionEnum.SUCCESS;
    }

    @PostMapping("/login")
    @ResponseBody
    public Long login(@RequestBody UserLoginDTO userLoginDTO) {
        return userApplicationService.login(userLoginDTO).getId();
    }

    @GetMapping("/info")
    public UserInfoVO getUserInfo(@RequestParam Long userId) {
        return userApplicationService.getUserInfo(userId);
    }

    @GetMapping("/info/edit/phone")
    public ActionEnum editPhone(@RequestParam String phone) {
        userApplicationService.validPhone(phone);
        return ActionEnum.SUCCESS;
    }

    @GetMapping("/info/edit/email")
    public ActionEnum editEmail(@RequestParam String email) {
        userApplicationService.validEmail(email);
        return ActionEnum.SUCCESS;
    }

    @PostMapping("/info/edit")
    @ResponseBody
    public ActionEnum editInfo(@RequestBody UserEditDTO userEditDTO) {
        userApplicationService.editInfo(userEditDTO);
        return ActionEnum.SUCCESS;
    }
}
