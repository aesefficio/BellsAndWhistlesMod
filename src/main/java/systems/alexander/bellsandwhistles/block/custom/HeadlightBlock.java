package systems.alexander.bellsandwhistles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeadlightBlock extends FaceAttachedHorizontalDirectionalBlock {
    public HeadlightBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, FACE);
    }

    public float getShadeBrightness(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 1.0F;
    }

    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return true;
    }
    private static final VoxelShape SHAPE = Shapes.join(Block.box(4.5, 4.5, 13, 11.5, 11.5, 16), Block.box(4, 4, 14, 12, 12, 16), BooleanOp.OR);

    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, Shapes.empty()};

        int times = (to.ordinal() - from.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(FACE) == AttachFace.FLOOR) {
            return Shapes.join(Block.box(4.5, 0, 5, 11.5, 3, 12), Block.box(4, 0, 4.5, 12, 2, 12.5), BooleanOp.OR);
        } else if (pState.getValue(FACE) == AttachFace.CEILING) {
            return Shapes.join(Block.box(4.5, 13, 5, 11.5, 16, 12), Block.box(4, 14, 4.5, 12, 16, 12.5), BooleanOp.OR);
        } else {
            switch ((Direction) pState.getValue(FACING)) {
                case NORTH:
                    return SHAPE;
                case SOUTH:
                    return rotateShape(Direction.NORTH, Direction.WEST, SHAPE);
                case WEST:
                    return rotateShape(Direction.NORTH, Direction.EAST, SHAPE);
                case EAST:
                default:
                    return rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE);
            }
        }
    }
}
