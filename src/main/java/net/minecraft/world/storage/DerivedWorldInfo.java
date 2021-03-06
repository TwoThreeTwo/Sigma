package net.minecraft.world.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

public class DerivedWorldInfo extends WorldInfo {
    private static final String __OBFID = "CL_00000584";
    /**
     * Instance of WorldInfo.
     */
    private final WorldInfo theWorldInfo;

    public DerivedWorldInfo(WorldInfo p_i2145_1_) {
        this.theWorldInfo = p_i2145_1_;
    }

    /**
     * Gets the NBTTagCompound for the worldInfo
     */
    public NBTTagCompound getNBTTagCompound() {
        return this.theWorldInfo.getNBTTagCompound();
    }

    /**
     * Creates a new NBTTagCompound for the world, with the given NBTTag as the "Player"
     */
    public NBTTagCompound cloneNBTCompound(NBTTagCompound nbt) {
        return this.theWorldInfo.cloneNBTCompound(nbt);
    }

    /**
     * Returns the seed of current world.
     */
    public long getSeed() {
        return this.theWorldInfo.getSeed();
    }

    /**
     * Returns the x spawn position
     */
    public int getSpawnX() {
        return this.theWorldInfo.getSpawnX();
    }

    /**
     * Set the x spawn position to the passed in value
     */
    public void setSpawnX(int p_76058_1_) {
    }

    /**
     * Return the Y axis spawning point of the player.
     */
    public int getSpawnY() {
        return this.theWorldInfo.getSpawnY();
    }

    /**
     * Sets the y spawn position
     */
    public void setSpawnY(int p_76056_1_) {
    }

    /**
     * Returns the z spawn position
     */
    public int getSpawnZ() {
        return this.theWorldInfo.getSpawnZ();
    }

    /**
     * Set the z spawn position to the passed in value
     */
    public void setSpawnZ(int p_76087_1_) {
    }

    public long getWorldTotalTime() {
        return this.theWorldInfo.getWorldTotalTime();
    }

    /**
     * Get current world time
     */
    public long getWorldTime() {
        return this.theWorldInfo.getWorldTime();
    }

    /**
     * Set current world time
     */
    public void setWorldTime(long p_76068_1_) {
    }

    public long getSizeOnDisk() {
        return this.theWorldInfo.getSizeOnDisk();
    }

    /**
     * Returns the player's NBTTagCompound to be loaded
     */
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.theWorldInfo.getPlayerNBTTagCompound();
    }

    /**
     * Get current world name
     */
    public String getWorldName() {
        return this.theWorldInfo.getWorldName();
    }

    public void setWorldName(String p_76062_1_) {
    }

    /**
     * Returns the save version of this world
     */
    public int getSaveVersion() {
        return this.theWorldInfo.getSaveVersion();
    }

    /**
     * Sets the save version of the world
     */
    public void setSaveVersion(int p_76078_1_) {
    }

    /**
     * Return the last time the player was in this world.
     */
    public long getLastTimePlayed() {
        return this.theWorldInfo.getLastTimePlayed();
    }

    /**
     * Returns true if it is thundering, false otherwise.
     */
    public boolean isThundering() {
        return this.theWorldInfo.isThundering();
    }

    /**
     * Sets whether it is thundering or not.
     */
    public void setThundering(boolean p_76069_1_) {
    }

    /**
     * Returns the number of ticks until next thunderbolt.
     */
    public int getThunderTime() {
        return this.theWorldInfo.getThunderTime();
    }

    /**
     * Defines the number of ticks until next thunderbolt.
     */
    public void setThunderTime(int p_76090_1_) {
    }

    /**
     * Returns true if it is raining, false otherwise.
     */
    public boolean isRaining() {
        return this.theWorldInfo.isRaining();
    }

    /**
     * Sets whether it is raining or not.
     */
    public void setRaining(boolean p_76084_1_) {
    }

    /**
     * Return the number of ticks until rain.
     */
    public int getRainTime() {
        return this.theWorldInfo.getRainTime();
    }

    /**
     * Sets the number of ticks until rain.
     */
    public void setRainTime(int p_76080_1_) {
    }

    /**
     * Gets the GameType.
     */
    public WorldSettings.GameType getGameType() {
        return this.theWorldInfo.getGameType();
    }

    public void incrementTotalWorldTime(long p_82572_1_) {
    }

    public void setSpawn(BlockPos spawnPoint) {
    }

    /**
     * Get whether the map features (e.g. strongholds) generation is enabled or disabled.
     */
    public boolean isMapFeaturesEnabled() {
        return this.theWorldInfo.isMapFeaturesEnabled();
    }

    /**
     * Returns true if hardcore mode is enabled, otherwise false
     */
    public boolean isHardcoreModeEnabled() {
        return this.theWorldInfo.isHardcoreModeEnabled();
    }

    public WorldType getTerrainType() {
        return this.theWorldInfo.getTerrainType();
    }

    public void setTerrainType(WorldType p_76085_1_) {
    }

    /**
     * Returns true if commands are allowed on this World.
     */
    public boolean areCommandsAllowed() {
        return this.theWorldInfo.areCommandsAllowed();
    }

    public void setAllowCommands(boolean allow) {
    }

    /**
     * Returns true if the World is initialized.
     */
    public boolean isInitialized() {
        return this.theWorldInfo.isInitialized();
    }

    /**
     * Sets the initialization status of the World.
     */
    public void setServerInitialized(boolean initializedIn) {
    }

    /**
     * Gets the GameRules class Instance.
     */
    public GameRules getGameRulesInstance() {
        return this.theWorldInfo.getGameRulesInstance();
    }

    public EnumDifficulty getDifficulty() {
        return this.theWorldInfo.getDifficulty();
    }

    public void setDifficulty(EnumDifficulty newDifficulty) {
    }

    public boolean isDifficultyLocked() {
        return this.theWorldInfo.isDifficultyLocked();
    }

    public void setDifficultyLocked(boolean locked) {
    }
}
