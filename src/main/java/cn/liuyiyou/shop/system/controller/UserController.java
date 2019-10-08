package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.shop.support.http.ResultEntity;
import cn.liuyiyou.shop.support.http.rest.errors.BadRequestAlertException;
import cn.liuyiyou.shop.system.dto.UserDTO;
import cn.liuyiyou.shop.system.security.AuthoritiesConstants;
import cn.liuyiyou.shop.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@Api(value = "UserController", tags = "用户管理")
@RestController
@RequestMapping("/api")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @ApiOperation(value = "根据ID获取#User#", notes = "根据ID获取#User#", response = UserDTO.class)
    @GetMapping("/user/{id:.+}")
    public ResultEntity<UserDTO> find(@PathVariable Long id) {
        return ResultEntity.wrapOrNotFound(userService.find(id).map(UserDTO::new));

    }

    @PostMapping("/user")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    @ApiOperation(value = "新建#User#", notes = "新建#User#", response = UserDTO.class)
    public ResultEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        if (userDTO.getId() != null) {
            throw new BadRequestAlertException("A new User cannot already have an ID", "User", "idexists");
        } else {
            UserDTO newUser = new UserDTO(userService.createUser(userDTO));
            return ResultEntity.ok(newUser);
        }
    }


    @PutMapping("/user")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    @ApiOperation(value = "更新#User#", notes = "更新#User#", response = UserDTO.class)
    public ResultEntity<UserDTO> update(@Valid @RequestBody UserDTO userDTO) {
        Optional<UserDTO> updatedUser = userService.updateUser(userDTO);
        return ResultEntity.wrapOrNotFound(updatedUser);
    }


    @ApiOperation(value = "刪除#User#", notes = "刪除#User#")
    @DeleteMapping("/user/{id:.+}")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResultEntity<String> delete(@PathVariable Long id) {
        log.debug("REST request to delete Menu: {}", id);
        userService.delete(id);
        return ResultEntity.success();
    }


    @ApiOperation(value = "获取#User#列表", notes = "获取#User#列表", response = UserDTO.class)
    @GetMapping("/user/list")
    public ResultEntity<Page<UserDTO>> list(Pageable pageable) {
        return ResultEntity.ok(userService.list(pageable));

    }

    @GetMapping("/user")
    public ResultEntity<UserDTO> getAccountInfo() {
        UserDTO userDTO = userService.getUserWithAuthorities()
                .map(UserDTO::new)
                .orElseThrow(() -> new BadRequestAlertException("User could not be found", "User", "notExists"));
        return ResultEntity.ok(userDTO);
    }

}
