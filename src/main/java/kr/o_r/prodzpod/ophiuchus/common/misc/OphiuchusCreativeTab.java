package kr.o_r.prodzpod.ophiuchus.common.misc;

import kr.o_r.prodzpod.ophiuchus.common.item.templates.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class OphiuchusCreativeTab extends ItemGroup {
    public static final OphiuchusCreativeTab INSTANCE = new OphiuchusCreativeTab();
    private NonNullList<ItemStack> list;

    public OphiuchusCreativeTab() {
        super("psi_ophiuchus");
    }

    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ModItems.debugItem);
    }

    public boolean hasSearchBar() {
        return true;
    }
}
