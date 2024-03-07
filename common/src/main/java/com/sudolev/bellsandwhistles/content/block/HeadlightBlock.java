package com.sudolev.bellsandwhistles.content.block;

import com.sudolev.bellsandwhistles.Utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeadlightBlock extends FaceAttachedHorizontalDirectionalBlock {
	public HeadlightBlock(Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, FACE);
	}

	public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
		return 1.0F;
	}

	public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
		return true;
	}

	private static final VoxelShape SHAPE = Shapes.or(Block.box(4.5, 4.5, 13, 11.5, 11.5, 16), Block.box(4, 4, 14, 12, 12, 16));

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
		Direction facing = switch(state.getValue(FACE)) {
			case FLOOR -> Direction.UP;
			case CEILING -> Direction.DOWN;
			default -> state.getValue(FACING);
		};

		return switch(facing) {
			case NORTH -> SHAPE;
			case SOUTH -> Utils.rotateShape(Direction.NORTH, Direction.WEST, SHAPE);
			case WEST -> Utils.rotateShape(Direction.NORTH, Direction.EAST, SHAPE);
			case EAST -> Utils.rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE);
			case UP -> Utils.rotateShape(Direction.NORTH, Direction.UP, SHAPE);
			case DOWN -> Utils.rotateShape(Direction.NORTH, Direction.DOWN, SHAPE);
		};
	}
}
