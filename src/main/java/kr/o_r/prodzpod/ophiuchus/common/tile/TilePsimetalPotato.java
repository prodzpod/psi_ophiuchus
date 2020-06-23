package kr.o_r.prodzpod.ophiuchus.common.tile;

import kr.o_r.prodzpod.ophiuchus.common.block.templates.ModBlocks;
import kr.o_r.prodzpod.ophiuchus.common.tile.templates.TileSimpleInventory;
import kr.o_r.prodzpod.ophiuchus.common.util.NameBlocks;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ObjectHolder;
import vazkii.psi.api.internal.VanillaPacketDispatcher;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TilePsimetalPotato extends TileSimpleInventory implements ITickableTileEntity, INameable {
    @ObjectHolder(ThisMod.ID + ":" + NameBlocks.PSIMETAL_POTATO) public static TileEntityType<TilePsimetalPotato> TYPE;
    private static final String TAG_NAME = "name";
    private static final int JUMP_EVENT = 0;

    public int jumpTicks = 0;
    public ITextComponent name = new StringTextComponent("");
    private int nextDoIt = 0;

    public TilePsimetalPotato() {
        super(TYPE);
    }

    public void interact(PlayerEntity player, Hand hand, ItemStack stack, Direction side) {
        int index = side.getIndex();
        if (index >= 0) {
            ItemStack stackAt = getItemHandler().getStackInSlot(index);
            if (!stackAt.isEmpty() && stack.isEmpty()) {
                player.setHeldItem(hand, stackAt);
                getItemHandler().setStackInSlot(index, ItemStack.EMPTY);
            } else if (!stack.isEmpty()) {
                ItemStack copy = stack.split(1);

                if (stack.isEmpty()) {
                    player.setHeldItem(hand, stackAt);
                } else if (!stackAt.isEmpty()) {
                    ItemHandlerHelper.giveItemToPlayer(player, stackAt);
                }

                getItemHandler().setStackInSlot(index, copy);
            }
        }

        if (!world.isRemote) {
            jump();
            player.sendMessage(new StringTextComponent("i havent coded this properly yet please wait"));

//            for (int i = 0; i < getSizeInventory(); i++) {
//                ItemStack stackAt = getItemHandler().getStackInSlot(i);
//                if (!stackAt.isEmpty() && stackAt.getItem() == ModBlocks.psimetalPotato.asItem()) {
//                    player.sendMessage(new StringTextComponent("Don't talk to me or my son ever again."));
//                    return;
//                }
//            }
        }
    }

    private void jump() {
        if (jumpTicks == 0) {
            world.addBlockEvent(getPos(), getBlockState().getBlock(), JUMP_EVENT, 20);
        }
    }

    @Override
    public void tick() {
        if (jumpTicks > 0) {
            jumpTicks--;
        }

        if (!world.isRemote) {
            if (world.rand.nextInt(250) == 0) {
                jump();
            }
            if (nextDoIt > 0) {
                nextDoIt--;
            }
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
    }

    @Override
    public void writePacketNBT(CompoundNBT cmp) {
        super.writePacketNBT(cmp);
        cmp.putString(TAG_NAME, ITextComponent.Serializer.toJson(name));
    }

    @Override
    public void readPacketNBT(CompoundNBT cmp) {
        super.readPacketNBT(cmp);
        name = ITextComponent.Serializer.fromJson(cmp.getString(TAG_NAME));
    }

    @Override
    public int getSizeInventory() {
        return 6;
    }

    @Nonnull
    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent(ModBlocks.psimetalPotato.getTranslationKey());
    }

    @Nullable
    @Override
    public ITextComponent getCustomName() {
        return name.getString().isEmpty() ? null : name;
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return hasCustomName() ? getCustomName() : getName();
    }
}
