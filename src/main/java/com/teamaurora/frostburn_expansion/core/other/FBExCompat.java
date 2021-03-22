package com.teamaurora.frostburn_expansion.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.frostburn_expansion.common.data.FrozenSporeDispenseBehavior;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FBExItems;
import net.minecraft.block.DispenserBlock;

public class FBExCompat {
    public static void registerDispenserBehaviors() {
        DispenserBlock.registerDispenseBehavior(FBExItems.FROZEN_SPORES.get(), new FrozenSporeDispenseBehavior());
    }
}
