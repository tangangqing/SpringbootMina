package com.example.DtoVo;

import lombok.Data;

/**
 * Created by daile on 2017/6/28.
 */
@Data
public class ControlDto {
    private String deviceKind;
    private String userOpenId;
    private String deviceId;
    private String controlKey;
    private String sessionId;
    private String msgId;
}
