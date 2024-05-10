//package haos.demo.wx;
//
//import cn.hutool.json.JSONObject;
//
//public class AuthUtil {
//	public static final String APPID = "换成自己的APPID ";
//	public static final String APPSECRET = "换成自己的APPSECRET ";
//
//	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
//		JSONObject jsonObject = null;
//		DefaultHttpClient client = new DefaultHttpClient();
//		HttpGet httpGet = new HttpGet(url);
//		HttpResponse response = client.execute(httpGet);
//		HttpEntity entity = response.getEntity();
//		if (entity != null) {
//			String result = EntityUtils.toString(entity, "UTF-8");
//			jsonObject = JSONObject.fromObject(result);
//		}
//		httpGet.releaseConnection();
//		return jsonObject;
//	}
//}