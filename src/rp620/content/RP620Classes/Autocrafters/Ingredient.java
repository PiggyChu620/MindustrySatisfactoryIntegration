package rp620.content.RP620Classes.Autocrafters;

import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import arc.struct.Seq;

public class Ingredient
{
    public Seq<ItemStack> items;
    public Seq<LiquidStack> liquids;

    public int maxItemAmount()
    {
        int max=0;
        for(ItemStack i:items)
        {
            if(i.amount>max) max=i.amount;
        }
        return max;
    }
    public float maxLiquidAmount()
    {
        float max=0;
        for(LiquidStack l:liquids)
        {
            if(l.amount>max) max=l.amount;
        }
        return max;
    }
}
