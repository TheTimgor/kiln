package moe.timgor.kilnmod;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.world.World;

public class KilnBlock extends AbstractFurnaceBlock {
    public KilnBlock(Properties p_i48393_1_) {
        super(p_i48393_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));
    }

    @Override
    protected void openContainer(World p_220089_1_, BlockPos p_220089_2_, PlayerEntity p_220089_3_) {
        TileEntity tileentity = p_220089_1_.getBlockEntity(p_220089_2_);
        if (tileentity instanceof FurnaceTileEntity) {
            p_220089_3_.openMenu((INamedContainerProvider)tileentity);
            p_220089_3_.awardStat(Stats.INTERACT_WITH_FURNACE);
        }

    }

    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new KilnTileEntity();
    }


}