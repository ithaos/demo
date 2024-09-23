package haos.demo.heat.channel.third.client.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import retrofit2.http.*;

import java.util.TreeMap;

@RetrofitClient(baseUrl = "${xxx}")
public interface Demo1Client {

    @FormUrlEncoded
    @POST("/apiweb/tranx/query")
    TreeMap<String, String> 查账(@FieldMap TreeMap<String, String> params);

    @FormUrlEncoded
    @POST("/apiweb/unitorder/pay")
    TreeMap<String, String> 销账(@FieldMap TreeMap<String, String> params);

    @FormUrlEncoded
    @POST("/cusapi/merchantapi/addterm")
    TreeMap<String, String> operateTerm(@FieldMap TreeMap<String, String> params);

    @FormUrlEncoded
    @POST("/apiweb/unitorder/scanqrpay")
    TreeMap<String, String> bscPay(@FieldMap TreeMap<String, String> params);

    @FormUrlEncoded
    @POST("/apiweb/tranx/cancel")
    TreeMap<String, String> cancel(@FieldMap TreeMap<String, String> params);

    @FormUrlEncoded
    @POST("/apiweb/tranx/refund")
    TreeMap<String, String> refund(@FieldMap TreeMap<String, String> params);

    @FormUrlEncoded
    @POST("/cusapi/trxfile/get")
    TreeMap<String, String> statement(@FieldMap TreeMap<String, String> params);
}
