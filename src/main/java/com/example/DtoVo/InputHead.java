package com.example.DtoVo;

import lombok.Data;

/**
 * Created by daile on 2017/6/28.
 */
@Data
public class InputHead {

    private String msgType;
    private String src;
    private String appKey;
    private String protocolVersion;
    private String SDKVersion;
    private String sessionId;
    private String msgId;
}
