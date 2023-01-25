package com.fusionflux.portalcubed.accessor;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface BlockCollisionTrigger {
    default void onEntityEnter(BlockState state, World world, BlockPos pos, Entity entity) {
    }

    default void onEntityLeave(BlockState state, World world, BlockPos pos, Entity entity) {
    }
}
