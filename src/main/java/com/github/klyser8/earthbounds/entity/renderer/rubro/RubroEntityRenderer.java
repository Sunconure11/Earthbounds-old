package com.github.klyser8.earthbounds.entity.renderer.rubro;

import com.github.klyser8.earthbounds.entity.RubroEntity;
import com.github.klyser8.earthbounds.entity.model.RubroEntityModel;
import com.github.klyser8.earthbounds.entity.renderer.EarthenMobRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoModel;

public class RubroEntityRenderer extends EarthenMobRenderer<RubroEntity> {

    public RubroEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RubroEntityModel());
        this.shadowRadius = 0f;
        addLayer(new RubroRedstoneLayer(this));
        addLayer(new RubroMaskLayer(this));
    }

    @Override
    public RenderLayer getRenderType(RubroEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void render(GeoModel model, RubroEntity rubro, float partialTicks, RenderLayer type,
                       MatrixStack matrixStackIn, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                       int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        boolean shouldPop = false;
        renderMask(model, rubro);
        if (rubro.getPower() < 0) {
            babify(matrixStackIn, 1.0f + rubro.getPower() / 1000f);
            shouldPop = true;
        }
        super.render(model, rubro, partialTicks, type, matrixStackIn, renderTypeBuffer, vertexBuilder,
                packedLightIn, packedOverlayIn, red, green, blue, alpha);
        if (shouldPop) {
            matrixStackIn.pop();
        }
    }

    private void renderShadow(RubroEntity rubro) {
        GameOptions options = MinecraftClient.getInstance().options;
        float h;
        double g;
        if (options.entityShadows
                && !rubro.isInvisible()
                && (h = (float)((1.0 - (g = MinecraftClient.getInstance().getEntityRenderDispatcher().getSquaredDistanceToCamera(rubro.getX(), rubro.getY(), rubro.getZ()))
                / 256.0) * shadowOpacity)) > 0.0f) {
            EntityRenderDispatcher.renderShadow(matrices, vertexConsumers, entity, h, tickDelta, this.world, entityRenderer.shadowRadius);
        }
    }

    //REMEMBER: push, scale/rotate/translate, pop
    private void babify(MatrixStack matrixStackIn, float scale) {
        matrixStackIn.push();
        matrixStackIn.scale(scale, scale, scale);
        this.shadowRadius = scale / 2;
    }

    private void renderMask(GeoModel model, RubroEntity rubro) {
        if (model.getBone("mask").isEmpty()) {
            System.err.println("RubroEntityRenderer: Mask is missing!");
        } else {
            if (!rubro.isFromFossil()) {
                if (!model.getBone("mask").get().isHidden()) {
                    model.getBone("mask").ifPresent(geoBone -> geoBone.setHidden(true));
                }
            } else {
                if (model.getBone("mask").get().isHidden()) {
                    model.getBone("mask").ifPresent(geoBone -> geoBone.setHidden(false));
                }
            }
        }
    }
}
