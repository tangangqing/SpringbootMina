package com.example.DtoVo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daile on 2017/6/28.
 */
@Slf4j
@Data
public class SessionCache {

    private static SessionCache session = null;
    private Map<String, List<IoSession>> sessions = new HashMap<>();

    public static SessionCache getInstance() {
        if (session == null) {
            session = new SessionCache();
        }
        return session;
    }

    public List<IoSession> isExists(String key) {
        List<IoSession> list = sessions.get(key);
        return list;
    }

    public void save(String macOpenId, IoSession session) {
        List<IoSession> list = sessions.get(macOpenId);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(session);
        sessions.put(macOpenId, list);
    }

    public void remove(String key, IoSession session) {
        List<IoSession> list = sessions.get(key);
        list.remove(session);
    }
}
