package com.example.DtoVo;

import lombok.Data;

import java.util.List;

/**
 * Created by daile on 2017/6/28.
 */
@Data
public class InputBody {

    private List<String> sessionKey;
    private String deviceKind;
    private String userOpenId;
    private String deviceId;
    private String controlKey;
}
