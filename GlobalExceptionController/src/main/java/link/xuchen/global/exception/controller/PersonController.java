package link.xuchen.global.exception.controller;

import link.xuchen.global.exception.common.MessageDTO;
import link.xuchen.global.exception.entity.Person;
import link.xuchen.global.exception.service.PersonService;
import link.xuchen.global.exception.validator.BeanValidator;
import link.xuchen.global.exception.validator.validates.Add;
import link.xuchen.global.exception.validator.validates.Update;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/16 1:55 PM
 */
@RestController
@RequestMapping(value = "/person", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class PersonController {


    @Autowired
    private PersonService personService;

    @PostMapping(value = "/save")
    public MessageDTO save( @RequestBody Person person) {
        //数据校验
        String validator = BeanValidator.validator(person, Add.class);
        if (StringUtils.isNoneBlank(validator)) {
            return MessageDTO.build().error(404, validator);
        }

        //业务逻辑
        Person person1 = personService.save(person);

        //返回结果
        return MessageDTO.build().success("ok", person1);
    }

    @GetMapping(value = "/update")
    public MessageDTO update( @RequestBody Person person) {
        //数据校验
        String validator = BeanValidator.validator(person, Update.class);
        if (StringUtils.isNoneBlank(validator)) {
            return MessageDTO.build().error(404, validator);
        }
        //业务逻辑
        Person update = personService.update(person);

        return MessageDTO.build().success("ok",  update);

    }


}
