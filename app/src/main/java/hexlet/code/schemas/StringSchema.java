package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema required() {
        addToListOperators(sentence -> sentence instanceof String && ((String) sentence).length() > 0);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addToListOperators(sentence -> sentence == null
                || sentence instanceof String && ((String) sentence).length() >= minLength);
        return this;
    }

    public StringSchema contains(String value) {
        addToListOperators(sentence -> sentence == null
                || sentence instanceof String && ((String) sentence).contains(value));
        return this;
    }
}
