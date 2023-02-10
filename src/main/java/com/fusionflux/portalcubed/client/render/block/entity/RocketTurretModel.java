package com.fusionflux.portalcubed.client.render.block.entity;

import com.fusionflux.portalcubed.blocks.blockentities.RocketTurretBlockEntity;
import com.fusionflux.portalcubed.util.BlockEntityWrapperEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class RocketTurretModel extends SinglePartEntityModel<BlockEntityWrapperEntity<RocketTurretBlockEntity>> {
    private final ModelPart root, turret, chassis, neck;

    public RocketTurretModel(ModelPart root) {
        super(RenderLayer::getEntityCutoutNoCull);
        this.root = root;
        turret = root.getChild("turret");
        chassis = turret.getChild("chassis");
        neck = chassis.getChild("segment_1").getChild("segment_2").getChild("segment_3").getChild("neck");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData turret = modelPartData.addChild("turret", ModelPartBuilder.create().uv(0, 29).cuboid(-4.0F, -17.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 25.0F, 0.0F));

        ModelPartData chassis = turret.addChild("chassis", ModelPartBuilder.create().uv(26, 32).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, 0.0F));

        chassis.addChild(
            "cube_r1", ModelPartBuilder.create().uv(42, 21).cuboid(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F,
                                                                   new Dilation(0.0F)
            ), ModelTransform.of(0.0F, -1.5F, 1.5F, -0.7854F, 0.0F, 0.0F));

        ModelPartData segment_1 = chassis.addChild("segment_1", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.0429F, 1.9571F, 0.3491F, 0.0F, 0.0F));

        segment_1.addChild(
            "cube_r2", ModelPartBuilder.create().uv(0, 46).cuboid(-2.5F, -1.75F, -2.0F, 5.0F, 3.0F, 4.0F,
                                                                  new Dilation(0.0F)
            ), ModelTransform.of(0.0F, -2.9874F, 2.841F, 0.7854F, 0.0F, 0.0F));

        segment_1.addChild(
            "cube_r3", ModelPartBuilder.create().uv(0, 38).cuboid(-2.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F,
                                                                  new Dilation(0.0F)
            ), ModelTransform.of(0.0F, -0.5126F, -0.341F, 0.7854F, 0.0F, 0.0F));

        ModelPartData segment_2 = segment_1.addChild("segment_2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.6137F, 3.4751F, 0.1309F, 0.0F, 0.0F));

        segment_2.addChild(
            "cube_r4", ModelPartBuilder.create().uv(42, 21).cuboid(-3.5F, -0.8826F, -1.0891F, 7.0F, 2.0F, 2.0F,
                                                                   new Dilation(0.0F)
            ), ModelTransform.of(0.0F, -0.4742F, 3.3266F, -1.1781F, 0.0F, 0.0F));

        segment_2.addChild(
            "cube_r5", ModelPartBuilder.create().uv(14, 42).cuboid(-3.0F, 0.75F, -2.0F, 6.0F, 1.0F, 4.0F,
                                                                   new Dilation(0.0F)
            ), ModelTransform.of(0.0F, -1.4951F, 1.4872F, 0.0436F, 0.0F, 0.0F));

        ModelPartData segment_3 = segment_2.addChild("segment_3", ModelPartBuilder.create(), ModelTransform.pivot(0.0083F, -0.4755F, 3.1777F));

        segment_3.addChild(
            "cube_r6", ModelPartBuilder.create().uv(42, 21).cuboid(-3.5F, -0.7298F, -1.2949F, 7.0F, 2.0F, 2.0F,
                                                                   new Dilation(0.0F)
            ), ModelTransform.of(-0.0083F, -3.1352F, 1.5022F, -2.7925F, 0.0F, 0.0F));

        segment_3.addChild(
            "cube_r7", ModelPartBuilder.create().uv(30, 42).cuboid(-3.0F, -0.354F, 0.02F, 6.0F, 1.0F, 3.0F,
                                                                   new Dilation(0.0F)
            ), ModelTransform.of(-0.0083F, 0.0013F, 0.1489F, 1.1781F, 0.0F, 0.0F));

        ModelPartData neck = segment_3.addChild("neck", ModelPartBuilder.create(), ModelTransform.of(0.0167F, -3.6138F, 1.5099F, -0.5105F, 0.0F, 0.0F));

        neck.addChild(
            "cube_r8", ModelPartBuilder.create().uv(8, 16).cuboid(-0.5F, -2.5728F, -0.4052F, 1.0F, 3.0F, 1.0F,
                                                                  new Dilation(0.0F)
            ), ModelTransform.of(0.0F, -0.8232F, -2.5263F, -1.8326F, 0.0F, 0.0F));

        ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(12, 52).cuboid(-2.25F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new Dilation(0.0F))
            .uv(16, 0).cuboid(-3.75F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.25F, -0.7007F, -5.6938F));

        ModelPartData eye = head.addChild("eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 31.7538F, -2.3749F));

        eye.addChild(
            "green", ModelPartBuilder.create().uv(24, 25).cuboid(-1.5F, -0.75F, -0.25F, 3.0F, 3.0F, 0.0F,
                                                                 new Dilation(0.0F)
            ), ModelTransform.pivot(-0.25F, -32.5F, -0.875F));

        eye.addChild(
            "yellow", ModelPartBuilder.create().uv(30, 25).cuboid(-1.5F, -0.75F, -0.25F, 3.0F, 3.0F, 0.0F,
                                                                  new Dilation(0.0F)
            ), ModelTransform.pivot(-0.25F, -32.5F, -0.75F));

        eye.addChild(
            "red", ModelPartBuilder.create().uv(36, 25).cuboid(-1.5F, -0.75F, -0.25F, 3.0F, 3.0F, 0.0F,
                                                               new Dilation(0.0F)
            ), ModelTransform.pivot(-0.25F, -32.5F, -0.575F));

        ModelPartData hatch = head.addChild("hatch", ModelPartBuilder.create().uv(37, 7).cuboid(0.0F, -2.75F, -3.75F, 2.0F, 7.0F, 7.0F, new Dilation(0.0F))
            .uv(44, 41).cuboid(-3.0694F, -2.2721F, -2.7033F, 5.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(5.25F, -0.75F, 0.25F));

        hatch.addChild(
            "missile_r1",
            ModelPartBuilder.create().uv(38, 54).mirrored().cuboid(5.5374F, -8.5667F, -3.0513F, 1.0F, 0.0F, 6.0F,
                                                                   new Dilation(0.0F)
                ).mirrored(false)
                .uv(38, 54).mirrored().cuboid(
                    8.2947F, -9.9106F, -3.0208F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(38, 54).mirrored().cuboid(
                    6.527F, -8.1428F, -3.0208F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(38, 54).mirrored().cuboid(
                    7.2338F, -7.436F, -2.9903F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(38, 54).mirrored().cuboid(
                    7.6577F, -6.4464F, -2.9597F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false),
            ModelTransform.of(-12.25F, 1.0F, -0.25F, 0.0F, 0.0F, 0.7854F)
        );

        hatch.addChild(
            "missile_r2", ModelPartBuilder.create().uv(38, 54).cuboid(-1.4639F, -3.4932F, -3.0513F, 1.0F, 0.0F, 6.0F,
                                                                      new Dilation(0.0F)
                )
                .uv(38, 54).cuboid(-0.12F, -0.7359F, -3.0208F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(38, 54).cuboid(-1.8878F, -2.5036F, -3.0208F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(38, 54).cuboid(-2.5946F, -1.7968F, -2.9903F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(38, 54).cuboid(-3.5842F, -1.3729F, -2.9597F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)),
            ModelTransform.of(1.2F, 1.0F, -0.25F, 0.0F, 0.0F, -0.7854F)
        );

        ModelPartData gun = hatch.addChild("gun", ModelPartBuilder.create(), ModelTransform.pivot(0.95F, 1.4845F, 0.265F));

        gun.addChild(
            "gun_r1", ModelPartBuilder.create().uv(43, 25).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F,
                                                                  new Dilation(0.0F)
            ), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData barrel = gun.addChild("barrel", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.1952F, -4.9748F));

        barrel.addChild(
            "barrel_r1", ModelPartBuilder.create().uv(52, 27).cuboid(-1.1574F, -0.1961F, -6.9597F, 1.0F, 1.0F, 5.0F,
                                                                     new Dilation(0.0F)
            ), ModelTransform.of(0.25F, -0.6797F, 4.4597F, 0.0F, 0.0F, -0.7854F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(BlockEntityWrapperEntity<RocketTurretBlockEntity> entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        getPart().traverse().forEach(ModelPart::resetTransform);
        chassis.setAngles(0, (float)Math.toRadians(headYaw - 90), 0);
        neck.setAngles((float)Math.toRadians(headPitch - 30), (float)Math.toRadians(-0.5105f), 0);
        m_rrbozhsc(entity.getBlockEntity().activatingAnimation, RocketTurretAnimations.ACTIVATE, animationProgress);
        m_rrbozhsc(entity.getBlockEntity().deactivatingAnimation, RocketTurretAnimations.DEACTIVATE, animationProgress);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        turret.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}