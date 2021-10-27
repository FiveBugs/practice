package constants;

public interface Constants {

    enum Type {
        FORUM(1);

        private Integer value;

        Type(Integer value) {
            this.value = value;
        }

        Integer getValue() {
            return value;
        }

        public static Type getType (Integer integer) {
            for (Type type : Type.values()) {
                if (type.value.equals(integer)) {
                    return type;
                }
            }
            return null;
        }
    }
}
