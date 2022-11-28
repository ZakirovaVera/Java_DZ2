// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки. 
// Если значение null, то параметр не должен попадать в запрос. 
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” and "city"="Moscow"

import org.json.simple.JSONObject;

public class task1 {
    public static void main(String[] args) {
        String text = "select * from students where ";
        JSONObject jo = new JSONObject();
        jo.put("name", "Ivanov");
        jo.put("country", "Russia");
        jo.put("city", "Moscow");
        jo.put("age", null);


        System.out.println(jo.toJSONString());
        name(jo, text);
    }
    public static void name(JSONObject jo, String sql) {
        StringBuilder a = new StringBuilder(sql);
        AddKey(jo, a, "name", false);
        AddKey(jo, a, "country", true);
        AddKey(jo, a, "city", true);
        AddKey(jo, a, "age", true);
        System.out.println(a);
    }
    public static void AddKey(JSONObject jo, StringBuilder sb, String key, Boolean isAddAnd) {
        var keyValue = jo.get(key);
        if(keyValue == null) return;
        if(isAddAnd) sb.append(" and ");
        sb.append(String.format("\"%s\" = \"%s\"", key, keyValue));
    }
}
