package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/*
    Input:
        {
        "Jon": "Smith",
        "Adam": ["Jake", null, "Nancy"],
        "Alex": {
        "Muller": [null, "Sam"],
        "Phil": null,
        "Xav": ["Mike", "Tom"]
        }
        "Lex": null,
        }
        Output: ["Adam.1", "Alex.Muller.0", "Alex.Phil", "Lex"]
*/
public class FindNull {
    public List<String> parseExpression(Map<String, Object> map) {

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String[]) {
                String[] value = (String[]) entry.getValue();
                for (int i = 0; i < value.length; i++) {
                    if (value[i] == null) result.add(entry.getKey() + "." + i);
                }
            } else if (entry.getValue() == null) {
                result.add(entry.getKey());
            } else if (entry.getValue() instanceof Map) {
                List<String> list = parseExpression((Map<String, Object>) entry.getValue());
                for (String str : list) {
                    result.add(entry.getKey() + "." + str);
                }
            }
        }
        return result;
    }
}
