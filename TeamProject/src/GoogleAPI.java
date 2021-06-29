import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleAPI {

	String API_KEY = "AIzaSyBrdwWp9OfD6EYEr8-2t8dvB8-oEme8tD4";
	public int InputCount = 0;
	Float lat = 0f;
	Float lng = 0f;
	float[] lat_array = new float[20];
	float[] lng_array = new float[20];
	public String Address = "주소를 입력해 주세요.";

	public void downloadmap(String location, boolean toggle, int num) {
		try {
			// marker component ����
			// String imageURL = "http://maps.googleapis.com/maps/api/staticmap?" +
			// "&center="
			// + URLEncoder.encode(location, "UTF-8") + "&zoom=12" +
			// "&markers="+URLEncoder.encode(location, "UTF-8")
			// + "&size=512x512" + "&key=" + API_KEY;

			String imageURL;
			if (toggle == true) {
				imageURL = "http://maps.googleapis.com/maps/api/staticmap?key=" + API_KEY + "&center="
						+ URLEncoder.encode(location, "UTF-8") + "&markers=" + URLEncoder.encode(location, "UTF-8")
						+ "&size=800x800&scale=2&zoom=12" + "&maptype=satellite";
			} else {
				imageURL = "http://maps.googleapis.com/maps/api/staticmap?key=" + API_KEY + "&center="
						+ URLEncoder.encode(location, "UTF-8") + "&markers=" + URLEncoder.encode(location, "UTF-8")
						+ "&size=800x800&scale=2&zoom=12";
			}

			if (num == 10) {
				for (int i = 0; i < 9; i++) {
					if (lat_array[i] == 0.0 || lng_array[i] == 0.0)
						continue;
					imageURL += "&markers=" + "color:blue|" + Float.toString(lat_array[i]) + ","
							+ Float.toString(lng_array[i]);
				}
			}

//			String imageURL = "http://maps.googleapis.com/maps/api/staticmap?key=" + API_KEY + "&center="
//					+ URLEncoder.encode(location, "UTF-8") + "&markers=" + URLEncoder.encode(location, "UTF-8")
//					+ "&size=512x512&scale=2&zoom=10";
			URL url = new URL(imageURL);
			// System.out.println(url);URLEncoder.encode(location, "UTF-8");
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(location);
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ImageIcon getMap(String location) {
		return new ImageIcon(
				(new ImageIcon(location)).getImage().getScaledInstance(800, 800, java.awt.Image.SCALE_SMOOTH));
	}

	public void fileDelete(String fileName) {
		File f = new File(fileName);
		f.delete();
	}

	private static String jsonReadAll(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();

		int cp;
		while ((cp = reader.read()) != -1) {
			sb.append((char) cp);
		}

		return sb.toString();
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = jsonReadAll(br);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public void GetLocation(String location, int num) throws JSONException, IOException {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(location, "UTF-8")
				+ "&markers=" + URLEncoder.encode(location, "UTF-8") + "&regeion=ko" + "&size=800x800"
				+ "&key=AIzaSyDsHw1m1dL3X8skt85HIotfoq5DjOA24BE";
		JSONObject json = readJsonFromUrl(url);
		// System.out.println(json.toString());
		JSONArray jArray = json.getJSONArray("results");
		JSONObject json_inside = jArray.getJSONObject(0);
		JSONObject jGeometry = json_inside.getJSONObject("geometry");
		JSONObject jbounds = jGeometry.getJSONObject("location");
		Address = json_inside.getString("formatted_address");

		lat += jbounds.getFloat("lat");
		lng += jbounds.getFloat("lng");
		lat_array[num] = jbounds.getFloat("lat");
		lng_array[num] = jbounds.getFloat("lng");
		InputCount++;
		// System.out.println(jbounds.getFloat("lat") + " " + jbounds.getFloat("lng"));
	}
}
