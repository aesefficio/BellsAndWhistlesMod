package systems.alexander.bellsandwhistles.block.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllShapes;
import com.simibubi.create.content.decoration.copycat.CopycatBlockEntity;
import com.simibubi.create.content.decoration.copycat.CopycatPanelBlock;
import com.simibubi.create.content.decoration.copycat.CopycatSpecialCases;
import com.simibubi.create.foundation.placement.IPlacementHelper;
import com.simibubi.create.foundation.placement.PlacementHelpers;
import com.simibubi.create.foundation.placement.PlacementOffset;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.function.Predicate;

public class PanelBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    protected static final int AABB_THICKNESS = 3;


    private static final int placementHelperId = PlacementHelpers.register(new PlacementHelper());

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

    @Override
    public boolean supportsExternalFaceHiding(BlockState state) {
        return true;
    }

    @Override
    public boolean hidesNeighborFace(BlockGetter level, BlockPos pos, BlockState state, BlockState neighborState,
                                     Direction dir) {
        if (state.is(this) == neighborState.is(this)) {
            if (CopycatSpecialCases.isBarsMaterial(getMaterial(level, pos))
                    && CopycatSpecialCases.isBarsMaterial(getMaterial(level, pos.relative(dir))))
                return state.getValue(FACING) == neighborState.getValue(FACING);
            if (getMaterial(level, pos).skipRendering(getMaterial(level, pos.relative(dir)), dir.getOpposite()))
                return isOccluded(state, neighborState, dir.getOpposite());
        }

        return state.getValue(FACING) == dir.getOpposite()
                && getMaterial(level, pos).skipRendering(neighborState, dir.getOpposite());
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
        return AllShapes.CASING_3PX.get(pState.getValue(FACING));
    }


    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }


    @MethodsReturnNonnullByDefault
    private static class PlacementHelper implements IPlacementHelper {
        @Override
        public Predicate<ItemStack> getItemPredicate() {
            return AllBlocks.COPYCAT_PANEL::isIn;
        }

        @Override
        public Predicate<BlockState> getStatePredicate() {
            return AllBlocks.COPYCAT_PANEL::has;
        }

        @Override
        public PlacementOffset getOffset(Player player, Level world, BlockState state, BlockPos pos,
                                         BlockHitResult ray) {
            List<Direction> directions = IPlacementHelper.orderedByDistanceExceptAxis(pos, ray.getLocation(),
                    state.getValue(FACING)
                            .getAxis(),
                    dir -> world.getBlockState(pos.relative(dir))
                            .getMaterial()
                            .isReplaceable());

            if (directions.isEmpty())
                return PlacementOffset.fail();
            else {
                return PlacementOffset.success(pos.relative(directions.get(0)),
                        s -> s.setValue(FACING, state.getValue(FACING)));
            }
        }
    }


}
