package com.legobmw99.allomancy.modules.combat.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class GlassDaggerItem extends SwordItem {

    private static final int ATTACK_DAMAGE = 5;
    private static final float ATTACK_SPEED = 1F;

    private static final IItemTier tier = new IItemTier() {
        @Override
        public int getUses() {
            return 16;
        }

        @Override
        public float getSpeed() {
            return 0;
        }

        @Override
        public float getAttackDamageBonus() {
            return ATTACK_DAMAGE;
        }

        @Override
        public int getLevel() {
            return 0;
        }

        @Override
        public int getEnchantmentValue() {
            return 1;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Blocks.GLASS);
        }
    };

    public GlassDaggerItem() {
        super(tier, ATTACK_DAMAGE, ATTACK_SPEED, new Properties().tab(ItemGroup.TAB_COMBAT));
    }

    // prevent dagger from mining
    @Override
    public boolean isCorrectToolForDrops(BlockState blockIn) {
        return false;
    }

    // Disable mending on daggers
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return super.isBookEnchantable(stack, book);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public float getXpRepairRatio(ItemStack stack) {
        return 1f;
    }

}
