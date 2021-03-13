package com.fusionflux.fluxtech.mixin;

import com.fusionflux.fluxtech.accessor.VelocityTransfer;
import com.fusionflux.fluxtech.blocks.FluxTechBlocks;
import com.fusionflux.fluxtech.entity.EntityAttachments;
import com.qouteall.immersive_portals.portal.Portal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityAttachments, VelocityTransfer {

    @Unique
    private static final TrackedData<Boolean> IS_ROLLING = DataTracker.registerData(Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    private static final TrackedData<Direction> DIRECTION = DataTracker.registerData(Entity.class, TrackedDataHandlerRegistry.FACING);

    @Unique
    private double maxFallSpeed = 0;
    @Unique
    private double storeVelocity1= 0;
    @Unique
    private double storeVelocity2= 0;
    @Unique
    private double storeVelocity3 = 0;
    @Unique
    private double speedTransformApply =0 ;

    //private Portal portal;

public Vec3d movementTest = new Vec3d(0,0,0);

    @Override
    public double getMaxFallSpeed() {
        return maxFallSpeed;
    }

    @Override
    public void setMaxFallSpeed(double maxFallSpeed) {
        this.maxFallSpeed = maxFallSpeed;
    }

    @Shadow
    public World world;

    @Shadow
    public abstract BlockPos getBlockPos();

    @Shadow
    public abstract Vec3d getVelocity();

    @Shadow public abstract void setVelocity(Vec3d velocity);

    @Shadow public abstract void addVelocity(double deltaX, double deltaY, double deltaZ);

    @Shadow public abstract boolean collidesWith(Entity other);

    @Shadow protected abstract boolean doesNotCollide(Box box);

    @Shadow public abstract Box getBoundingBox();

    @Shadow public boolean horizontalCollision;

    @Shadow public abstract boolean isInsideWall();

    @Shadow public boolean verticalCollision;

    @Shadow public boolean noClip;

    @Shadow public float horizontalSpeed;

    @Shadow public abstract boolean isOnGround();

    @Shadow protected boolean onGround;

    @Shadow public abstract boolean collides();

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tick(CallbackInfo ci) {
        if ((maxFallSpeed > 0 && maxFallSpeed != 10) || !(world.getBlockState(this.getBlockPos()).getBlock() == FluxTechBlocks.PROPULSION_GEL)) {
            maxFallSpeed--;
        }

        Vec3d expand = new Vec3d (this.getVelocity().x*1.3,this.getVelocity().y*1.3,this.getVelocity().z*1.3);

        List<Portal> portallist = this.world.getEntitiesByClass(Portal.class,this.getBoundingBox().stretch(expand),null);
        for (Portal portal : portallist) {
            //if(this.getBoundingBox().stretch(expand).intersects(portal.getBoundingBox()))
                if(this.getBoundingBox().stretch(expand).intersects(portal.getBoundingBox())) {
                //\ ((IEEntity) this).notifyCollidingWithPortal(portal);
                if(this.world.isClient) {
                    if (Math.abs(this.getVelocity().x + this.getVelocity().z) > Math.abs(this.getVelocity().y)) {
                        this.horizontalCollision = false;
                        //this.verticalCollision=true;
                    }
                    if (Math.abs(this.getVelocity().x + this.getVelocity().z) < Math.abs(this.getVelocity().y)) {
                        this.verticalCollision = false;
                        //this.horizontalCollision=false;
                    }
                    if (Math.abs(this.getVelocity().x + this.getVelocity().z) == Math.abs(this.getVelocity().y)) {
                        this.verticalCollision = false;
                        this.horizontalCollision=false;
                    }
                }
            }
        }

        if (world.isClient) {
            storeVelocity2 = storeVelocity1;
            storeVelocity1 = this.getVelocity().length();

            /*-----------
            if (storeVelocity3 > storeVelocity1 && storeVelocity3 > storeVelocity2) {
                speedTransformApply=storeVelocity3;
            }
            -----------*/
        }

            speedTransformApply = Math.max(storeVelocity1, storeVelocity2);

    }

    @Override
    public void setVelocityTransfer(double speedValueTransferDuck) {
        this.speedTransformApply = speedValueTransferDuck;
    }

    @Override
    public double getVelocityTransfer() {
        return this.speedTransformApply;
    }

    /*----------
    @Inject(method = "calculateDimensions", at = @At("TAIL"))
    public void calculateDimensions(CallbackInfo ci) {
        EntityPose entityPose2 = this.getPose();
        EntityDimensions entityDimensions3 = this.getDimensions(entityPose2);
        this.standingEyeHeight = this.getEyeHeight(entityPose2, entityDimensions3) - 1;
    }
    ----------*/
}
