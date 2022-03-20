package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderSettings;

public class GenLayerBiome extends GenLayer {
    private static final String __OBFID = "CL_00000555";
    private final ChunkProviderSettings field_175973_g;
    private BiomeGenBase[] field_151623_c;
    private BiomeGenBase[] field_151621_d;
    private BiomeGenBase[] field_151622_e;
    private BiomeGenBase[] field_151620_f;

    public GenLayerBiome(long p_i45560_1_, GenLayer p_i45560_3_, WorldType p_i45560_4_, String p_i45560_5_) {
        super(p_i45560_1_);
        this.field_151623_c = new BiomeGenBase[]{BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.savanna, BiomeGenBase.savanna, BiomeGenBase.plains};
        this.field_151621_d = new BiomeGenBase[]{BiomeGenBase.forest, BiomeGenBase.roofedForest, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.birchForest, BiomeGenBase.swampland};
        this.field_151622_e = new BiomeGenBase[]{BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.taiga, BiomeGenBase.plains};
        this.field_151620_f = new BiomeGenBase[]{BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.coldTaiga};
        this.parent = p_i45560_3_;

        if (p_i45560_4_ == WorldType.DEFAULT_1_1) {
            this.field_151623_c = new BiomeGenBase[]{BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga};
            this.field_175973_g = null;
        } else if (p_i45560_4_ == WorldType.CUSTOMIZED) {
            this.field_175973_g = ChunkProviderSettings.Factory.createFactory(p_i45560_5_).func_177864_b();
        } else {
            this.field_175973_g = null;
        }
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] var5 = this.parent.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] var6 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int var7 = 0; var7 < areaHeight; ++var7) {
            for (int var8 = 0; var8 < areaWidth; ++var8) {
                this.initChunkSeed((long) (var8 + areaX), (long) (var7 + areaY));
                int var9 = var5[var8 + var7 * areaWidth];
                int var10 = (var9 & 3840) >> 8;
                var9 &= -3841;

                if (this.field_175973_g != null && this.field_175973_g.field_177779_F >= 0) {
                    var6[var8 + var7 * areaWidth] = this.field_175973_g.field_177779_F;
                } else if (isBiomeOceanic(var9)) {
                    var6[var8 + var7 * areaWidth] = var9;
                } else if (var9 == BiomeGenBase.mushroomIsland.biomeID) {
                    var6[var8 + var7 * areaWidth] = var9;
                } else if (var9 == 1) {
                    if (var10 > 0) {
                        if (this.nextInt(3) == 0) {
                            var6[var8 + var7 * areaWidth] = BiomeGenBase.mesaPlateau.biomeID;
                        } else {
                            var6[var8 + var7 * areaWidth] = BiomeGenBase.mesaPlateau_F.biomeID;
                        }
                    } else {
                        var6[var8 + var7 * areaWidth] = this.field_151623_c[this.nextInt(this.field_151623_c.length)].biomeID;
                    }
                } else if (var9 == 2) {
                    if (var10 > 0) {
                        var6[var8 + var7 * areaWidth] = BiomeGenBase.jungle.biomeID;
                    } else {
                        var6[var8 + var7 * areaWidth] = this.field_151621_d[this.nextInt(this.field_151621_d.length)].biomeID;
                    }
                } else if (var9 == 3) {
                    if (var10 > 0) {
                        var6[var8 + var7 * areaWidth] = BiomeGenBase.megaTaiga.biomeID;
                    } else {
                        var6[var8 + var7 * areaWidth] = this.field_151622_e[this.nextInt(this.field_151622_e.length)].biomeID;
                    }
                } else if (var9 == 4) {
                    var6[var8 + var7 * areaWidth] = this.field_151620_f[this.nextInt(this.field_151620_f.length)].biomeID;
                } else {
                    var6[var8 + var7 * areaWidth] = BiomeGenBase.mushroomIsland.biomeID;
                }
            }
        }

        return var6;
    }
}
