package net.minecraft.util;

public class TupleIntJsonSerializable {
    private static final String __OBFID = "CL_00001478";
    private int integerValue;
    private IJsonSerializable jsonSerializableValue;

    /**
     * Gets the integer value stored in this tuple.
     */
    public int getIntegerValue() {
        return integerValue;
    }

    /**
     * Sets this tuple's integer value to the given value.
     */
    public void setIntegerValue(int p_151188_1_) {
        integerValue = p_151188_1_;
    }

    /**
     * Gets the JsonSerializable value stored in this tuple.
     */
    public IJsonSerializable getJsonSerializableValue() {
        return jsonSerializableValue;
    }

    /**
     * Sets this tuple's JsonSerializable value to the given value.
     */
    public void setJsonSerializableValue(IJsonSerializable p_151190_1_) {
        jsonSerializableValue = p_151190_1_;
    }
}
