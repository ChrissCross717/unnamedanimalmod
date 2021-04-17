package mod.coda.unnamedanimalmod.client.renderer;

import mod.coda.unnamedanimalmod.UnnamedAnimalMod;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

public class MangroveBoatRenderer extends BoatRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/boat/mangrove.png");

    public MangroveBoatRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(BoatEntity entity) {
        return TEXTURE;
    }
}
