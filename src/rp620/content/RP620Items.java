package rp620.content;

import arc.graphics.Color;
import arc.math.Rand;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.type.Item;
import mindustry.type.ItemStack;

import java.time.LocalDateTime;

public class RP620Items
{
    public static Item sulfur,salt,lye,soap,celluloseFiber,dynamite,onc,azidoazideAzide,oac;
    public static void load()
    {
        sulfur=new Item("sulfur", Color.yellow)
        {{
            localizedName="Sulfur";
            alwaysUnlocked=true;
        }};
        salt=new Item("salt", Color.white)
        {{
            localizedName="Salt";
            Blocks.salt.itemDrop=this;
            alwaysUnlocked=true;
        }};
        lye=new Item("lye",Color.white)
        {{
            localizedName="Lye";
            alwaysUnlocked=true;
        }};
        soap=new Item("soap", Color.pink)
        {{
            localizedName="Soap";
            alwaysUnlocked=true;
        }};
        celluloseFiber=new Item("cellulose-fiber", Color.lightGray)
        {{
            localizedName="Cellulose Fiber";
            alwaysUnlocked=true;
        }};
        dynamite=new Item("dynamite",Color.red)
        {{
            localizedName="Dynamite";
            flammability=10;
            explosiveness=2;
            alwaysUnlocked=true;
        }};
        onc=new Item("onc", Color.sky)
        {{
            localizedName="ONC";
            description="Octanitrocubane\nThe most explosive compound to date that had successfully been synthesized (by Philip Eaton).";
            flammability=10;
            explosiveness=2.38f;
            alwaysUnlocked=true;
        }};
        azidoazideAzide=new Item("azidoazide-azide", Color.valueOf("fdfd96"))
        {{
            localizedName="Azidoazide Azide";
            description="The most unstable compound known to man, it's so unstable that it'll explode when studying it, some believe that it's even more explosive than ONC.";
            flammability=10;
            explosiveness=3;
            alwaysUnlocked=true;
        }};
        oac=new Item("oac",Color.red)
        {{
            localizedName="OAC";
            description="Octaazacubane\nThe most ever explosive hypothetical compound, it's 8 nitrogen atoms arranged into a perfect cube, it's predicted to be over 5 times more powerful than standard TNT.";
            flammability=10;
            explosiveness=5+ 5 * new Rand(LocalDateTime.now().getSecond()).nextFloat();
            alwaysUnlocked=true;
        }};
    }
}
