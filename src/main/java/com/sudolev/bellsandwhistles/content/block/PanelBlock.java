package com.sudolev.bellsandwhistles.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PanelBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected static final int AABB_THICKNESS = 3;


	public PanelBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.UP));
    }
    public static BlockState getMaterial(BlockGetter reader, BlockPos targetPos) {
        return Blocks.MOSSY_COBBLESTONE.defaultBlockState();
    }
    public boolean canFaceBeOccluded(BlockState state, Direction face) {
        return state.getValue(FACING)
                .getOpposite() == face;
    }
    public boolean shouldFaceAlwaysRender(BlockState state, Direction face) {
        return canFaceBeOccluded(state, face.getOpposite());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState stateForPlacement = super.getStateForPlacement(pContext);
        return stateForPlacement.setValue(FACING, pContext.getNearestLookingDirection()
                .getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder.add(FACING));
	}




    public static boolean isOccluded(BlockState state, BlockState other, Direction pDirection) {
        Direction facing = state.getValue(FACING);
        if (facing.getOpposite() == other.getValue(FACING) && pDirection == facing)
            return true;
        if (other.getValue(FACING) != facing)
            return false;
        return pDirection.getAxis() != facing.getAxis();
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		switch (pState.getValue(FACING)) {
			case NORTH:
			default:
				return Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
			case SOUTH:
				return Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
			case WEST:
				return Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
			case EAST:
				return Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
			case UP:
				return Block.box(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
			case DOWN:
				return Block.box(0, 0, 0, 16, 3, 16);
		}
	}

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }
}
