package com.github.klyser8.earthbounds.item;

import com.github.klyser8.earthbounds.entity.CopperBuckEntity;
import com.github.klyser8.earthbounds.item.flingshot.Flingable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CopperBuckItem extends Item implements Flingable {
    public CopperBuckItem(Settings settings) {
        super(settings);
    }

    @Override
    public ProjectileEntity createFlingableEntity(World world, ItemStack stack, LivingEntity shooter) {
        Vec3d eyePos = shooter.getEyePos();
        Vec3d dir = shooter.getRotationVec(1).normalize();
        return new CopperBuckEntity(eyePos.x + dir.x * 0.2,
                eyePos.y + dir.y * 0.2,
                eyePos.z + dir.z * 0.2, world, shooter);
    }
}
