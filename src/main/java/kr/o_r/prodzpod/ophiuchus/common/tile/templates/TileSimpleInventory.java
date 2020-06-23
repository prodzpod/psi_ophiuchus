/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * ALTERED: merged with TileMod
 */
package kr.o_r.prodzpod.ophiuchus.common.tile.templates;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;

public abstract class TileSimpleInventory extends TileEntity {

    protected SimpleItemStackHandler itemHandler = createItemHandler();
    private final LazyOptional<IItemHandler> automationItemHandler = LazyOptional.of(() -> itemHandler);

    public TileSimpleInventory(TileEntityType<?> type) {
        super(type);
    }

    @Nonnull
    @Override
    public CompoundNBT write(CompoundNBT tag) {
        CompoundNBT ret = super.write(tag);
        writePacketNBT(ret);
        return ret;
    }

    @Nonnull
    @Override
    public final CompoundNBT getUpdateTag() {
        return write(new CompoundNBT());
    }

    @Override
    public void read(CompoundNBT tag) {
        super.read(tag);
        readPacketNBT(tag);
    }

    public void readPacketNBT(CompoundNBT tag) {
        itemHandler = createItemHandler();
        itemHandler.deserializeNBT(tag);
    }

    public void writePacketNBT(CompoundNBT tag) {
        tag.merge(itemHandler.serializeNBT());
    }

    @Override
    public final SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT tag = new CompoundNBT();
        writePacketNBT(tag);
        return new SUpdateTileEntityPacket(pos, -999, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        super.onDataPacket(net, packet);
        readPacketNBT(packet.getNbtCompound());
    }

    public abstract int getSizeInventory();

    protected SimpleItemStackHandler createItemHandler() {
        return new SimpleItemStackHandler(this, true);
    }

    public final IItemHandlerModifiable getItemHandler() {
        return itemHandler;
    }

    public final RecipeWrapper getRecipeWrapper() {
        return new RecipeWrapper(getItemHandler());
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, automationItemHandler);
    }

    /* Extension of ItemStackHandler that uses our own slot array, allows for control of writing,
    allows control over stack limits, and allows for itemstack-slot validation */
    protected static class SimpleItemStackHandler extends ItemStackHandler {

        private final boolean allowWrite;
        private final TileSimpleInventory tile;

        public SimpleItemStackHandler(TileSimpleInventory inv, boolean allowWrite) {
            super(inv.getSizeInventory());
            this.allowWrite = allowWrite;
            tile = inv;
        }

        @Nonnull
        @Override
        public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
            if (allowWrite) {
                return super.insertItem(slot, stack, simulate);
            } else {
                return stack;
            }
        }

        @Nonnull
        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (allowWrite) {
                return super.extractItem(slot, amount, simulate);
            } else {
                return ItemStack.EMPTY;
            }
        }

        @Override
        public void onContentsChanged(int slot) {
            tile.markDirty();
        }
    }
}