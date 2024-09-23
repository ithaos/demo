package haos.demo.heat.channel.third.adapter;

import com.alibaba.fastjson.JSONObject;
import haos.demo.heat.channel.HeatThirdPartyService;
import haos.demo.heat.channel.third.client.client.Demo1Client;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.TreeMap;

@RequiredArgsConstructor
public class Demo1Adapter implements HeatThirdPartyService {

    private final Demo1Client demo1Client;

    /**
     * 唯一商户号（区分三方）
     * @return
     */
    @Override
    public String commercialNumber() {
        return null;
    }

    @Override
    public String getChannelName() {
        return null;
    }

    @Override
    public String channelOrderNumber() {
        return null;
    }

    @Override
    public JSONObject getBills(String commercialNumber, String searchId) {
        TreeMap<String, String> 查账 = demo1Client.查账(new TreeMap<>());
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
    public JSONObject crossOffAccount(JSONObject crossOffAccountReq) {
        return null;
    }

}
