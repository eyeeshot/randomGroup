package com.eyeeshot.randomgroup.library;

import com.eyeeshot.randomgroup.RandomGroupApplication;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ParserJson {

    public static JSONObject getJson(String path) {

        try {
            InputStream inputStream = RandomGroupApplication.class.getClassLoader()
                    .getResourceAsStream(path);

            if (inputStream != null) {
                BufferedReader streamReader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null)
                    responseStrBuilder.append(inputStr);

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(responseStrBuilder.toString());
                return jsonObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getResouceLists(String path) {
        ArrayList result = new ArrayList();

        ClassLoader loader = RandomGroupApplication.class.getClassLoader();

        URL url = loader.getResource(path);
        String resourcePath = url.getPath();
        File[] files = new File(resourcePath).listFiles();

        for (File f : files) {
            if (f.isFile()) {
                result.add(f.getName());
            }
        }

        return result;

    }

    public Object getResouceJsonData(String path) {

        ArrayList resouceList = this.getResouceLists(path);

        for (Object rl : resouceList) {
            System.out.println(resouceList);
        }
        return null;
    }
}