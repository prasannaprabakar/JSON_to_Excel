import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSON2Excel {
    public static void main(String[] args) throws IOException, ParseException, JSONException
    {

        BufferedReader br= new BufferedReader( new FileReader("C:\\Users\\prasanna.prabakaran\\IdeaProjects\\Read JSON data and conver to excel\\src\\JSONfile.json"));
        String line;
        StringBuilder data= new StringBuilder();
        while ((line=br.readLine())!=null){
            data.append(line);
            // System.out.println(str);
        }
        JSONObject jsonObject =new JSONObject(data.toString());
        JSONArray array = jsonObject.getJSONArray("students");
        String students[][] = new String[20][3];
        //Map<JSONObject, JSONObject> qaMap = new LinkedHashMap<>();
        for (int row=0;row<array.length();row++){
            for (int column=0;column<=2;column++){
                if(column==0)
                {
                    students[row][column] = array.getJSONObject(row).getString("Name");

                    //System.out.println(students[i][j]);
                }
                else if(column==1){
                    students[row][column] = array.getJSONObject(row).getString("Age");
                    // System.out.println(students[i][j]);
                }
                else if(column==2){
                    students[row][column] = array.getJSONObject(row).getString("Total Marks");
                    //System.out.println(students[i][j]);
                }
                // System.out.println(qaMap);
            }

            /* name.add(array.getJSONObject(i).getString("Name"));
             age.add(array.getJSONObject(i).getString("Age"));
             total_marks.add(array.getJSONObject(i).getString("Total Marks"));
             createInvoice createInvoice=new createInvoice(name,age,total_marks);
          */
        }
        /*int age1= Integer.parseInt(students[0][1]);
        int age2= Integer.parseInt(students[1][1]);
        System.out.println(age1+age2);*/

        createInvoice createInvoice=new createInvoice(students);
    }
}