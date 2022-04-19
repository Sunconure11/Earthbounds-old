package com.github.klyser8.earthbounds.entity;

import com.github.klyser8.earthbounds.registry.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustColorTransitionParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.List;

public class ShimmerShellEntity extends EarthenPersistentProjectile {

    public ShimmerShellEntity(EntityType<ShimmerShellEntity> type, World world) {
        super(type, world);
        pickupType = PickupPermission.DISALLOWED;
    }

    public ShimmerShellEntity(double x, double y, double z,
                              World world, LivingEntity owner) {
        super(EarthboundEntities.SHIMMER_SHELL, x, y, z, world, owner);
        pickupType = PickupPermission.DISALLOWED;
    }

    protected ShimmerShellEntity(LivingEntity owner, World world) {
        super(EarthboundEntities.SHIMMER_SHELL, owner, world);
        pickupType = PickupPermission.DISALLOWED;
    }

    @Override
    protected ItemStack asItemStack() {
        return EarthboundItems.SHIMMER_SHELL.getDefaultStack();
    }

    @Override
    public double getDamage() {
        return 15;
    }

    @Override
    public void tick() {
        playParticleTrail();
        if (getCollisionAge() >= 20) {
            if (!world.isClient) {
                explode();
            }
        }
        super.tick();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entityHit = entityHitResult.getEntity();
        setVelocity(getVelocity().negate().multiply(0.1));
        if (entityHit instanceof LivingEntity living) {
            attemptAdvancementTrigger(living);
            explode();
        }
    }

    private void explode() {
        playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0f, 2.0f);
        List<Entity> entities = world.getOtherEntities(this, Box.of(getPos(), 4, 4, 4),
                entity -> entity instanceof LivingEntity);
        for (Entity entity : entities) {
            LivingEntity living = (LivingEntity) entity;
            float dmg = Math.max((float) (getDamage() / distanceTo(entity)), (float) (getDamage() / getPos().distanceTo(entity.getEyePos())));
            living.damage(EarthboundDamageSource.shimmerExplosion(
                    (LivingEntity) getOwner()), (float) Math.min(dmg, getDamage()));
            attemptAdvancementTrigger(living);
        }
        if (!world.isClient) {
            ((ServerWorld) world).spawnParticles(EarthboundParticles.AMETHYST_SHIMMER,
                    getX(), getY(), getZ(), 50, 0, 0, 0, 0.1);
            DustColorTransitionParticleEffect effect = new DustColorTransitionParticleEffect(
                    new Vec3f(201 / 255f, 94 / 255f, 1),
                    new Vec3f(0.8f, 0.8f, 0.8f), 1.5f);
            ((ServerWorld) world).spawnParticles(effect,
                    getX(), getY() + 0.5, getZ(), 25, 0.5, 0.5, 0.5, 0);
            ((ServerWorld) world).spawnParticles(ParticleTypes.POOF,
                    getX(), getY(), getZ(), 25, 0, 0, 0, 0.1);
            discard();
        }
    }

    private void attemptAdvancementTrigger(LivingEntity entity) {
        if (entity.getHealth() <= 0) {
            if (getOwner() instanceof ServerPlayerEntity player) {
                EarthboundsAdvancementCriteria.KILLED_BY_SHIMMER_SHELL.trigger(player, entity);
            }
        }
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT;
    }

    private void playParticleTrail() {
        Vec3d vel = getVelocity().normalize();
        if (world.isClient && getCollisionAge() == 0) {
            for (int i = 0; i < 4; ++i) {
                Vec3d origin = new Vec3d(
                        getParticleX(0.5) - vel.x / 2,
                        getRandomBodyY() / 2 + getRandomBodyY() / 2 - vel.y / 2,
                        getParticleZ(0.5) - vel.z / 2);
                this.world.addParticle(EarthboundParticles.AMETHYST_CRIT,
                        origin.x + vel.x * i / 4.0,
                        origin.y + vel.y * i / 8.0,
                        origin.z + vel.z * i / 4.0,
                        -vel.x / 2, (-vel.y + 0.2) / 2, -vel.z / 2);
            }
        }
    }
}
