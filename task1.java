// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки. 
// Если значение null, то параметр не должен попадать в запрос. 
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” and "city"="Moscow"

import org.json.simple.JSONObject;

public class task1 {
    public static void main(String[] args) {
        String requestText = "select * from students where ";
        JSONObject stringJsonData = new JSONObject();
        stringJsonData.put("name", "Ivanov");
        stringJsonData.put("country", "Russia");
        stringJsonData.put("city", "Moscow");
        stringJsonData.put("age", null);

        System.out.println(stringJsonData.toJSONString());
        WhereRequest(stringJsonData, requestText);
    }
    public static void WhereRequest(JSONObject jo, String sql) {
        StringBuilder filterOptions = new StringBuilder(sql);
        AddKey(jo, filterOptions, "name", false);
        AddKey(jo, filterOptions, "country", true);
        AddKey(jo, filterOptions, "city", true);
        AddKey(jo, filterOptions, "age", true);
        System.out.println(filterOptions);
    }
    public static void AddKey(JSONObject jo, StringBuilder sb, String key, Boolean isAddAnd) {
        var keyValue = jo.get(key);
        if(keyValue == null) return;
        if(isAddAnd) sb.append(" and ");
        sb.append(String.format("\"%s\" = \"%s\"", key, keyValue));
    }
}
