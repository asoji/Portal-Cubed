package com.fusionflux.portalcubed.mixin.client;

import com.fusionflux.portalcubed.accessor.LevelRendererExt;
import com.fusionflux.portalcubed.client.PortalCubedClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin implements LevelRendererExt {
    @Shadow private Frustum cullingFrustum;

    @Mutable
    @Shadow @Final private RenderBuffers renderBuffers;

    @Inject(method = "prepareCullFrustum", at = @At("HEAD"))
    private void modifyCameraRotation(PoseStack poseStack, Vec3 cameraPos, Matrix4f projectionMatrix, CallbackInfo ci) {
        PortalCubedClient.interpCamera().ifPresent(q -> poseStack.mulPose(q.toQuaternionf()));
    }

    @Override
    public Frustum getCullingFrustum() {
        return cullingFrustum;
    }

    @Override
    public void setCullingFrustum(Frustum cullingFrustum) {
        this.cullingFrustum = cullingFrustum;
    }

    @Override
    public RenderBuffers getRenderBuffers() {
        return renderBuffers;
    }

    @Override
    public void setRenderBuffers(RenderBuffers renderBuffers) {
        this.renderBuffers = renderBuffers;
    }
}