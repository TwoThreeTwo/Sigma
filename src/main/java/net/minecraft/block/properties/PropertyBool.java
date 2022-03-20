package net.minecraft.block.properties;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;

public class PropertyBool extends PropertyHelper {
    private static final String __OBFID = "CL_00002017";
    private final ImmutableSet allowedValues = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));

    protected PropertyBool(String name) {
        super(name, Boolean.class);
    }

    public static PropertyBool create(String name) {
        return new PropertyBool(name);
    }

    public Collection getAllowedValues() {
        return this.allowedValues;
    }

    /**
     * Synthetic method called by getName
     */
    public String getName0(Boolean value) {
        return value.toString();
    }

    /**
     * Get the name for the given value.
     */
    public String getName(Comparable value) {
        return this.getName0((Boolean) value);
    }
}
