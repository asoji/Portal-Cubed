package com.fusionflux.portalcubed.client.render.entity;

import com.fusionflux.portalcubed.client.render.EmissiveFeatureRenderer;
import com.fusionflux.portalcubed.client.render.entity.model.FactCoreModel;
import com.fusionflux.portalcubed.entity.FactCoreEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static com.fusionflux.portalcubed.PortalCubed.id;

public class FactCoreRenderer extends MobEntityRenderer<FactCoreEntity, FactCoreModel> {

    private static final Identifier BASE_TEXTURE = id("textures/entity/portal_2_cores.png");

    public FactCoreRenderer(EntityRendererFactory.Context context) {
        super(context, new FactCoreModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(FactCoreModel.FACT_CORE_LAYER)), 0.5f);
        this.addFeature(new EmissiveFeatureRenderer<>(this) {

            private static final Identifier EMISSIVE_TEXTURE = id("textures/entity/portal_2_cores_e.png");

            @Override
            public Identifier getEmissiveTexture(FactCoreEntity entity) {
                return EMISSIVE_TEXTURE;
            }

        });
    }

    @Override
    public Identifier getTexture(FactCoreEntity entity) {
        return BASE_TEXTURE;
    }

}
