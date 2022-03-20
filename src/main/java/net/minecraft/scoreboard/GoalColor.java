package net.minecraft.scoreboard;

import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class GoalColor implements IScoreObjectiveCriteria {
    private static final String __OBFID = "CL_00001961";
    private final String field_178794_j;

    public GoalColor(String p_i45549_1_, EnumChatFormatting p_i45549_2_) {
        field_178794_j = p_i45549_1_ + p_i45549_2_.getFriendlyName();
        IScoreObjectiveCriteria.INSTANCES.put(field_178794_j, this);
    }

    @Override
    public String getName() {
        return field_178794_j;
    }

    @Override
    public int func_96635_a(List p_96635_1_) {
        return 0;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public IScoreObjectiveCriteria.EnumRenderType func_178790_c() {
        return IScoreObjectiveCriteria.EnumRenderType.INTEGER;
    }
}
