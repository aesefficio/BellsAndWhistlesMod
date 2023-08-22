package net.aaw.bellsandwhistles.block.custom;

import com.simibubi.create.content.decoration.MetalLadderBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class MetalGrabRailsBlock extends MetalLadderBlock {
    public MetalGrabRailsBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return super.isLadder(state, level, pos, entity);
    }
}
