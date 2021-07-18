package com.legobmw99.allomancy.modules.combat;

import com.legobmw99.allomancy.Allomancy;
import com.legobmw99.allomancy.modules.combat.client.CombatClientSetup;
import com.legobmw99.allomancy.modules.combat.entity.ProjectileNuggetEntity;
import com.legobmw99.allomancy.modules.combat.item.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CombatSetup {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Allomancy.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Allomancy.MODID);
    public static final RegistryObject<CoinBagItem> COIN_BAG = ITEMS.register("coin_bag", CoinBagItem::new);
    public static final RegistryObject<ObsidianDaggerItem> OBSIDIAN_DAGGER = ITEMS.register("obsidian_dagger", ObsidianDaggerItem::new);
    public static final RegistryObject<GlassDaggerItem> GLASS_DAGGER = ITEMS.register("glass_dagger", GlassDaggerItem::new);
    public static final RegistryObject<ObsidianAxeItem> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", ObsidianAxeItem::new);
    public static final RegistryObject<DuelingCaneItem> DUELING_CANE = ITEMS.register("dueling_cane", DuelingCaneItem::new);
    public static final RegistryObject<KolossBladeItem> KOLOSS_BLADE = ITEMS.register("koloss_blade", KolossBladeItem::new);
    public static final RegistryObject<EntityType<ProjectileNuggetEntity>> NUGGET_PROJECTILE = ENTITIES.register("nugget_projectile",
                                                                                                                 () -> EntityType.Builder.<ProjectileNuggetEntity>of(
                                                                                                                         ProjectileNuggetEntity::new, EntityClassification.MISC)
                                                                                                                         .setShouldReceiveVelocityUpdates(true)
                                                                                                                         .setUpdateInterval(20)
                                                                                                                         .setCustomClientFactory(
                                                                                                                                 (spawnEntity, world) -> new ProjectileNuggetEntity(
                                                                                                                                         world, spawnEntity.getEntity()))
                                                                                                                         .sized(0.25F, 0.25F)
                                                                                                                         .build("nugget_projectile"));
    public static final IArmorMaterial WoolArmor = new IArmorMaterial() {
        @Override
        public int getDurabilityForSlot(EquipmentSlotType slotIn) {
            return 50;
        }

        @Override
        public int getDefenseForSlot(EquipmentSlotType slotIn) {
            return slotIn == EquipmentSlotType.CHEST ? 4 : 0;
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.GRAY_WOOL);
        }

        @Override
        public String getName() {
            return "allomancy:wool";
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }

    };
    public static final RegistryObject<MistcloakItem> MISTCLOAK = ITEMS.register("mistcloak", MistcloakItem::new);

    public static void register() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static void clientInit(final FMLClientSetupEvent e) {
        CombatClientSetup.registerEntityRenders();
    }
}
