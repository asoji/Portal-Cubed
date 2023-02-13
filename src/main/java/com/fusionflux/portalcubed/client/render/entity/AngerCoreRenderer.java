package com.fusionflux.portalcubed.client.render.entity;

import com.fusionflux.portalcubed.client.render.EmissiveFeatureRenderer;
import com.fusionflux.portalcubed.client.render.entity.model.AngerCoreModel;
import com.fusionflux.portalcubed.entity.AngerCoreEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static com.fusionflux.portalcubed.PortalCubed.id;

public class AngerCoreRenderer extends MobEntityRenderer<AngerCoreEntity, AngerCoreModel> {

    private static final Identifier TEXTURE = id("textures/entity/portal_1_cores.png");

    public AngerCoreRenderer(EntityRendererFactory.Context context) {
        super(context, new AngerCoreModel(context.getPart(AngerCoreModel.ANGER_CORE_LAYER)), 0.5f);
        this.addFeature(new EmissiveFeatureRenderer<>(this) {

            private static final Identifier EMISSIVE_TEXTURE = id("textures/entity/portal_1_cores_e.png");

            @Override
            public Identifier getEmissiveTexture(AngerCoreEntity entity) {
                return EMISSIVE_TEXTURE;
            }

        });
    }

    @Override
    public Identifier getTexture(AngerCoreEntity entity) {
        return TEXTURE;
    }

}
