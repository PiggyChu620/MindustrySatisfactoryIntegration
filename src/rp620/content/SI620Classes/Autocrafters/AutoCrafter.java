package rp620.content.SI620Classes.Autocrafters;

import arc.struct.EnumSet;
import arc.struct.Seq;
import arc.util.Log;
import mindustry.gen.Sounds;
import mindustry.world.Block;
import mindustry.world.meta.BlockFlag;
import multicraft.MultiCrafter;

public class AutoCrafter extends Block
{
    Seq<Recipe> recipes;

    public AutoCrafter(String name)
    {
        super(name);
        update = true;
        solid = true;
        sync = true;
        flags = EnumSet.of(BlockFlag.factory);
        ambientSound = Sounds.machine;
        configurable = true;
        saveConfig = true;
        ambientSoundVolume = 0.03f;
        config(Integer.class, MultiCrafter.MultiCrafterBuild::setCurRecipeIndexFromRemote);
        Log.info("MultiCrafter[" + this.name + "] loaded.");
    }

    @Override
    public void init()
    {
        hasItems = false;
        hasPower = false;
        hasLiquids = false;
        outputsPower = false;

    }
}