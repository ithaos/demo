package haos.demo.heat.channel.impl;


import com.alibaba.fastjson.JSONObject;
import haos.demo.heat.channel.ChannelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeatTLService implements ChannelService {

    @Override
    public String getChannelName() {
        return null;
    }

    @Override
    public String channelOrderNumber() {
        return null;
    }

    @Override
    public List<JSONObject> queryAddress(JSONObject addressReq) {
        return null;
    }

    @Override
    public List<JSONObject> fuzzyQueryCustomer(JSONObject fuzzyQueryReq) {
        return null;
    }

    @Override
    public JSONObject queryCustomerByAddress(JSONObject queryUserByAddressReq) {
        return null;
    }

    @Override
    public List<JSONObject> queryCustomerByPhone(JSONObject customerQueryReq) {
        return null;
    }

    @Override
    public JSONObject queryCustomerByCustomerNumber(JSONObject customerQueryReq) {
        return null;
    }

    @Override
    public JSONObject getBills(String commercialNumber, String searchId) {
        return null;
    }

    @Override
    public JSONObject crossOffAccount(JSONObject crossOffAccountReq) {
        return null;
    }
}
