package onetaptakeaway.spinno.com.volleyjsonobjectlearning;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new LongOperation().execute("http://www.muntumi.net:8083/socal/services/adduser.json");
    }





    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {


            InputStream inputStream = null;
            String result = "";
            try {

                // 1. create HttpClient
                HttpClient httpclient = new DefaultHttpClient();

                // 2. make POST request to the given URL
                HttpPost httpPost = new HttpPost(params[0]);

                String json = "";

                // 3. build jsonObject
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("userhandle", "unknown");
                jsonObject.accumulate("firstname", "samir");
                jsonObject.accumulate("lastname", "goel");
                jsonObject.accumulate("preferredname", "sam");
                jsonObject.accumulate("email", "samirgoel3@gmail.com");
                jsonObject.accumulate("suburbid", "54");
                jsonObject.accumulate("dob", "1990-08-07");

                jsonObject.accumulate("userpass", "1234567A8");
                jsonObject.accumulate("telephone", "1234567896");

                // 4. convert JSONObject to JSON to String
                json = jsonObject.toString();
                Log.d("######################## String json", json);


                // ** Alternative way to convert Person object to JSON string usin Jackson Lib
                // ObjectMapper mapper = new ObjectMapper();
                // json = mapper.writeValueAsString(person);

                // 5. set json to StringEntity
                StringEntity se = new StringEntity(json);

                // 6. set httpPost Entity
                // httpPost.setEntity(se);
                httpPost.setEntity(new StringEntity(json , "UTF8"));


                // 7. Set some headers to inform server about the type of the content
                httpPost.setHeader("Content-type", "application/json");

                // 8. Execute POST request to the given URL
                HttpResponse httpResponse = httpclient.execute(httpPost);
                Log.d("######################## httpResponse", ""+httpResponse );


                // 9. receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                // 10. convert inputstream to string
                if(inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "Did not work!";

            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return  result;
        }

        @Override
        protected void onPostExecute(String s) {


            Log.d("String ::::" , ""+s);





            Toast.makeText(Main2Activity.this, "result is " + s, Toast.LENGTH_SHORT).show();


        }

        @Override
        protected void onPreExecute() {

        }


    }


    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
