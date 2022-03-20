package info.sigmaclient.module.data;

import com.google.gson.annotations.Expose;

import java.lang.reflect.Type;

public class Setting<E> {
    private final String name;
    private final String desc;
    private final Type type;
    private final double inc;
    private final double min;
    private final double max;
    private String[] options;
    private String selectedOption;
    @Expose
    private E value;
    public Setting(String name, E value, String desc) {
        this.name = name;
        this.value = value;
        this.type = value.getClass().getGenericSuperclass();
        this.desc = desc;
        if (value instanceof Number) {
            inc = 0.5;
            min = 1;
            max = 20;
        } else {
            inc = 0;
            min = 0;
            max = 0;
        }
    }

    public Setting(String name, E value, String desc, double inc, double min, double max) {
        this.name = name;
        this.value = value;
        this.type = value.getClass().getGenericSuperclass();
        this.desc = desc;
        this.inc = inc;
        this.min = min;
        this.max = max;
    }

    public String getDesc() {
        return desc;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public double getInc() {
        return inc;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public void update(Setting setting) {
        value = (E) setting.value;
    }
}
