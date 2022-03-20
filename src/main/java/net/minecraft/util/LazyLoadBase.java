package net.minecraft.util;

public abstract class LazyLoadBase {
    private static final String __OBFID = "CL_00002263";
    private Object value;
    private boolean isLoaded = false;

    public Object getValue() {
        if (!isLoaded) {
            isLoaded = true;
            value = load();
        }

        return value;
    }

    protected abstract Object load();
}
