package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        getListOperators().add(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        getListOperators().add(value -> ((HashMap<?, ?>) value).size() >= size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        getListOperators()
                .add(checkedMap -> ((HashMap<?, ?>) checkedMap)
                        .keySet() //get keySet of checked Map
                        .stream()
                        .allMatch(checkedMapKey -> schemas // check every key
                                .get(checkedMapKey) // get Schema of a key
                                .isValid(((HashMap) checkedMap)
                                        .get(checkedMapKey)))); // check if value of a key is valid
        return this;
    }
}
