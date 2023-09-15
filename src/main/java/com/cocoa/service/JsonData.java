package com.cocoa.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.cocoa.dto.JsonField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonData {

    public final ArrayList<JsonField> list() {
        ArrayList<JsonField> list = new ArrayList<>();



        String result = "";

        try {
            String text = URLEncoder.encode("", "UTF-8");

            URL url = null;


            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            System.out.println(result);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject jsonObject2 = (JSONObject) jsonObject.get("jobs");
            JSONArray jsonArray = (JSONArray) jsonObject2.get("job");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jobObject = (JSONObject) jsonArray.get(i);

                JSONObject jsonObject4 = (JSONObject) jobObject.get("company");
                JSONObject jsonObject5 = (JSONObject) jsonObject4.get("detail");
                String companyUrl = (String) jobObject.get("url");
                System.out.println("companyUrl : " + companyUrl);
                String companyName = (String) jsonObject5.get("name");
                System.out.println("companyName : " + companyName);

                JSONObject jsonObjectnew = (JSONObject) jobObject.get("position");
                String recruitTitle = (String) jsonObjectnew.get("title");
                System.out.println("recruitTitle : " + recruitTitle);

                JsonField jsf = new JsonField(companyUrl, companyName, recruitTitle);
//                System.out.println("jsf:" + jsf);

                list.add(jsf);
//                System.out.println("list:"+list);

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return list;
    }
}
