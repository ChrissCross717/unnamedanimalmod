package teamdraco.unnamedanimalmod.client;

import net.minecraft.client.renderer.color.BlockColors;
import net.minecraftforge.api.distmarker.Dist;
import teamdraco.unnamedanimalmod.UnnamedAnimalMod;
import teamdraco.unnamedanimalmod.client.renderer.item.*;
import teamdraco.unnamedanimalmod.common.block.SaltPowderBlock;
import teamdraco.unnamedanimalmod.init.UAMBlocks;
import teamdraco.unnamedanimalmod.init.UAMEntities;
import teamdraco.unnamedanimalmod.common.item.UAMSpawnEggItem;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import teamdraco.unnamedanimalmod.client.renderer.*;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = UnnamedAnimalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.BLACK_DIAMOND_STINGRAY.get(), BlackDiamondStingrayRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.TOMATO_FROG.get(), TomatoFrogRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.SOUTHERN_RIGHT_WHALE.get(), SouthernRightWhaleRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.GREATER_PRAIRIE_CHICKEN.get(), GreaterPrairieChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.GREATER_PRAIRIE_CHICKEN_EGG.get(), GreaterPrairieChickenEggRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.FLASHLIGHT_FISH.get(), FlashlightFishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.HUMPHEAD_PARROTFISH.get(), HumpheadParrotfishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MUSK_OX.get(), MuskOxRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.BANANA_SLUG.get(), BananaSlugRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MARINE_IGUANA.get(), MarineIguanaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.PLATYPUS.get(), PlatypusRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.PLATYPUS_EGG.get(), PlatypusEggRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MARINE_IGUANA_EGG.get(), MarineIguanaEggRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.ELEPHANTNOSE_FISH.get(), ElephantnoseFishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.PACMAN_FROG.get(), PacmanFrogRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.CAPYBARA.get(), CapybaraRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.ROCKET_KILLIFISH.get(), RocketKillifishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MANGROVE_SNAKE.get(), MangroveSnakeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MANGROVE_BOAT.get(), MangroveBoatRenderer::new);
        // RenderingRegistry.registerEntityRenderingHandler(UAMEntities.BLUBBER_JELLY.get(), BlubberJellyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.FIDDLER_CRAB.get(), FiddlerCrabRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MANGROVE_SNAKE_EGG.get(), MangroveSnakeEggRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.LEAFY_SEADRAGON.get(), LeafySeadragonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.SPOTTED_GARDEN_EEL.get(), SpottedGardenEelRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.MUDSKIPPER.get(), MudskipperRenderer::new);
    }

    @SubscribeEvent
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((UAMSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (UAMSpawnEggItem e : UAMSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }

    @SubscribeEvent
    public static void setRenderLayers(FMLClientSetupEvent event) {
        Set<RegistryObject<Block>> blocks = new HashSet<>(UAMBlocks.BLOCKS.getEntries());

        blocks.stream().filter(b -> {
            final Block block = b.get();
            return block instanceof BushBlock || block instanceof LeavesBlock || block instanceof TrapDoorBlock || block instanceof DoorBlock || block instanceof SaltPowderBlock;
        }).forEach(ClientEvents::setCutout);
    }

    public static void setCutout(RegistryObject<Block> b) {
        RenderTypeLookup.setRenderLayer(b.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void blockColors(ColorHandlerEvent.Block event) {
        BlockColors handler = event.getBlockColors();
        handler.register((p_228059_0_, p_228059_1_, p_228059_2_, p_228059_3_) -> SaltPowderBlock.getColor(), UAMBlocks.SALT.get());
    }
}
