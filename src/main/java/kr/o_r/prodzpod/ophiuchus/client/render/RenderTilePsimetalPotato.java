/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package kr.o_r.prodzpod.ophiuchus.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import kr.o_r.prodzpod.ophiuchus.common.block.templates.ModBlocks;
import kr.o_r.prodzpod.ophiuchus.common.tile.TilePsimetalPotato;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

public class RenderTilePsimetalPotato extends TileEntityRenderer<TilePsimetalPotato> {

    private static final ResourceLocation texture = new ResourceLocation(ThisMod.TEXTURE + "model/psimetal_potato.png");
    private final ModelRenderer potatoModel = new ModelRenderer(16, 16, 0, 0);

    public RenderTilePsimetalPotato(TileEntityRendererDispatcher manager) {
        super(manager);
        potatoModel.addBox(0F, 0F, 0F, 4, 6, 4);
        potatoModel.setRotationPoint(-2F, 18F, -2F);
        potatoModel.setTextureSize(64, 32);
    }

    @Override
    public void render(TilePsimetalPotato potato, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffers, int light, int overlay) {
        if (potato.getBlockState().getBlock() != ModBlocks.psimetalPotato) return;
        RenderType layer = RenderType.getEntitySolid(texture);

        ms.push();
        ms.translate(0.5F, 1.5F, 0.5F);
        ms.scale(1F, -1F, -1F);

        Direction potatoFacing = potato.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
        float rotY = 0;
        switch (potatoFacing) {
            default:
            case SOUTH:
                break;
            case NORTH:
                rotY = 180F;
                break;
            case EAST:
                rotY = 270F;
                break;
            case WEST:
                rotY = 90F;
                break;
        }
        ms.rotate(Vector3f.YP.rotationDegrees(rotY));

        float jump = potato.jumpTicks;
        if (jump > 0) {
            jump -= partialTicks;
        }
        float up = (float) -Math.abs(Math.sin(jump / 10 * Math.PI)) * 0.2F;
        float rotZ = (float) Math.sin(jump / 10 * Math.PI) * 2;
        ms.translate(0F, up, 0F);
        ms.rotate(Vector3f.ZP.rotationDegrees(rotZ));

        ms.push();
        IVertexBuilder buffer = buffers.getBuffer(layer);
        potatoModel.render(ms, buffer, light, overlay, 1, 1, 1, 1);
        ms.pop();

        ms.rotate(Vector3f.ZP.rotationDegrees(-rotZ));
        ms.rotate(Vector3f.YP.rotationDegrees(-rotY));
        ms.scale(1F, -1F, -1F);
        ms.pop();
    }
}