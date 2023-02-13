package com.fusionflux.portalcubed.client.render.entity;

import com.fusionflux.portalcubed.client.render.EmissiveFeatureRenderer;
import com.fusionflux.portalcubed.client.render.entity.model.AdventureCoreModel;
import com.fusionflux.portalcubed.entity.AdventureCoreEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static com.fusionflux.portalcubed.PortalCubed.id;

public class AdventureCoreRenderer extends MobEntityRenderer<AdventureCoreEntity, AdventureCoreModel> {

    private static final Identifier TEXTURE = id("textures/entity/portal_2_cores.png");

    public AdventureCoreRenderer(EntityRendererFactory.Context context) {
        super(context, new AdventureCoreModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(AdventureCoreModel.ADVENTURE_CORE_LAYER)), 0.5f);
        this.addFeature(new EmissiveFeatureRenderer<>(this) {
            private static final Identifier EMISSIVE_TEXTURE = id("textures/entity/portal_2_cores_e.png");

            @Override
            public Identifier getEmissiveTexture(AdventureCoreEntity entity) {
                return EMISSIVE_TEXTURE;
            }

        });
    }

    @Override
    public Identifier getTexture(AdventureCoreEntity entity) {
        return TEXTURE;
    }

}
