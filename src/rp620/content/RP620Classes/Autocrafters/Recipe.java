package rp620.content.RP620Classes.Autocrafters;

import arc.util.Nullable;
import mindustry.type.ItemStack;

public class Recipe
{
    public Ingredient inputs;
    public Ingredient outputs;
    public float heat;
    public float power;

    public int maxItemAmount()
    {
        return Math.max(inputs.maxItemAmount(), outputs.maxItemAmount());
    }
    public float maxLiquidAmount()
    {
        return Math.max(inputs.maxLiquidAmount(), outputs.maxLiquidAmount());
    }
}
