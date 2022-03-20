package net.minecraft.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RegistrySimple implements IRegistry {
    private static final Logger logger = LogManager.getLogger();
    private static final String __OBFID = "CL_00001210";
    /**
     * Objects registered on this registry.
     */
    protected final Map registryObjects = createUnderlyingMap();

    /**
     * Creates the Map we will use to map keys to their registered values.
     */
    protected Map createUnderlyingMap() {
        return Maps.newHashMap();
    }

    @Override
    public Object getObject(Object p_82594_1_) {
        return registryObjects.get(p_82594_1_);
    }

    /**
     * Register an object on this registry.
     */
    @Override
    public void putObject(Object p_82595_1_, Object p_82595_2_) {
        Validate.notNull(p_82595_1_);
        Validate.notNull(p_82595_2_);

        if (registryObjects.containsKey(p_82595_1_)) {
            RegistrySimple.logger.debug("Adding duplicate key \'" + p_82595_1_ + "\' to registry");
        }

        registryObjects.put(p_82595_1_, p_82595_2_);
    }

    /**
     * Gets all the keys recognized by this registry.
     */
    public Set getKeys() {
        return Collections.unmodifiableSet(registryObjects.keySet());
    }

    /**
     * Does this registry contain an entry for the given key?
     */
    public boolean containsKey(Object p_148741_1_) {
        return registryObjects.containsKey(p_148741_1_);
    }

    @Override
    public Iterator iterator() {
        return registryObjects.values().iterator();
    }
}
