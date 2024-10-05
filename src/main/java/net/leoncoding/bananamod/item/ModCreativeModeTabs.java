package net.leoncoding.bananamod.item;

import net.leoncoding.bananamod.BananaMod;
import net.leoncoding.bananamod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BananaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GOOD_BANANA_TAB = CREATIVE_MODE_TABS.register("good_banana_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BANANA.get()))
                    .title(Component.translatable("creativetab.bananamod.good_bananas"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BANANA.get());
                        output.accept(ModItems.THREEDIMBANANA.get());
                        output.accept(ModBlocks.BANANA_BLOCK.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> BAD_BANANA_TAB = CREATIVE_MODE_TABS.register("bad_banana_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUTATEDBANANA.get()))
                    .withTabsBefore(GOOD_BANANA_TAB.getId())
                    .title(Component.translatable("creativetab.bananamod.bad_bananas"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MUTATEDBANANA.get());
                        output.accept(ModBlocks.MUTATED_BANANA_BLOCK.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
