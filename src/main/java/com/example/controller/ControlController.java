package com.example.controller;

import com.example.DtoVo.*;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.session.IoSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daile on 2017/6/28.
 */
@RestController
@Slf4j
public class ControlController {

    private static final String CONTROL_RESPONSE = "controlResponse";

    @RequestMapping("/device/control")
    public String conrolResult(@RequestBody ControlResultDto controlResultDto){
        if (log.isDebugEnabled()){
            log.debug(controlResultDto.toString());
        }
        Map<String, String> result = new HashMap<String, String>();
        Gson gson = new Gson();
        Result controlResult = new Result();
        String toAppResult = "1";
        OutputBody body = new OutputBody();
        OutputHead head = new OutputHead();
        try {

            String userOpenId = controlResultDto.getUserOpenId();
            String msgId = controlResultDto.getMsgId();
            head.setMsgId(msgId);
            head.setMsgType(CONTROL_RESPONSE);
            body.setCode(controlResultDto.getResult().get("code"));
            body.setInfo(controlResultDto.getResult().get("info"));
            controlResult.setBody(body);
            controlResult.setHead(head);
            String json = gson.toJson(controlResult);
            toAppResult = toAPP(json, userOpenId);
            result.put("result", toAppResult);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return gson.toJson(result);
    }

    private String toAPP(String response, String target) {
        List<IoSession> sessions = SessionCache.getInstance().isExists(target);
        String result = "1";
        log.info("是否存在session==》" + sessions);
        if (sessions != null) {
            try {
                for (IoSession session : sessions) {
                    session.write(response);
                    result = "0";
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return result;
    }
}
