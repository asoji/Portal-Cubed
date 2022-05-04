package com.fusionflux.portalcubed.client.render;

import com.fusionflux.portalcubed.PortalCubed;
import com.fusionflux.portalcubed.client.render.model.entity.CompanionCubeModel;
import com.fusionflux.portalcubed.client.render.model.entity.StorageCubeModel;
import com.fusionflux.portalcubed.entity.CompanionCubeEntity;
import com.fusionflux.portalcubed.entity.StorageCubeEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CompanionCubeRenderer extends MobEntityRenderer<CompanionCubeEntity, CompanionCubeModel> {
    private static final Identifier BASE_TEXTURE = new Identifier(PortalCubed.MODID, "textures/entity/companion_cube.png");
    protected final CompanionCubeModel model = new CompanionCubeModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(CompanionCubeModel.COMPANION_CUBE_MAIN_LAYER));

    public CompanionCubeRenderer(EntityRendererFactory.Context context) {
        super(context, new CompanionCubeModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(CompanionCubeModel.COMPANION_CUBE_MAIN_LAYER)), 0.5f);
    }




    @Override
    public Identifier getTexture(CompanionCubeEntity entity) {
        return BASE_TEXTURE;
    }
}