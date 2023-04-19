package rp620.content;

import arc.graphics.Color;
import arc.math.Rand;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import rp620.content.RP620Classes.SimplifiedTechNode;
import static rp620.content.RP620Classes.RP620Vars.*;

import java.time.LocalDateTime;

public class RP620Items
{
    public static Item sulfur,salt,lye,soap,celluloseFiber,dynamite,onc,azidoazideAzide,oac;
    public static Item ice,sludge,cryocube,arkyciteIce,neoplasmIce,oxygenIce,wax,galliumIce,hydrogenIce,nitrogenIce,cyanogenIce;

    public static void load()
    {
        sulfur=new Item("sulfur", Color.yellow)
        {{
            localizedName="Sulfur";
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(Items.copper,this,0));
            erekirContents.add(new SimplifiedTechNode(Items.beryllium,this,0));
            allContents.add(new SimplifiedTechNode(Items.copper,this,0));
        }};
        salt=new Item("salt", Color.white)
        {{
            localizedName="Salt";
            Blocks.salt.itemDrop=this;
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(Items.copper,this,0));
            erekirContents.add(new SimplifiedTechNode(Items.beryllium,this,0));
            allContents.add(new SimplifiedTechNode(Items.copper,this,0));
        }};
        lye=new Item("lye",Color.white)
        {{
            localizedName="Lye";
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(salt,this,1));
            allContents.add(new SimplifiedTechNode(salt,this,1));
        }};
        soap=new Item("soap", Color.pink)
        {{
            localizedName="Soap";
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(lye,this,2));
            allContents.add(new SimplifiedTechNode(lye,this,2));
        }};
        celluloseFiber=new Item("cellulose-fiber", Color.lightGray)
        {{
            localizedName="Cellulose Fiber";
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(Items.sporePod,this,0));
            allContents.add(new SimplifiedTechNode(Items.sporePod,this,0));
        }};
        dynamite=new Item("dynamite",Color.red)
        {{
            localizedName="Dynamite";
            flammability=10;
            explosiveness=2;
            alwaysUnlocked=true;
            allContents.add(new SimplifiedTechNode(celluloseFiber,this,1));
        }};
        onc=new Item("onc", Color.sky)
        {{
            localizedName="ONC";
            description="Octanitrocubane\nThe most explosive compound to date that had successfully been synthesized (by Philip Eaton).";
            flammability=10;
            explosiveness=2.38f;
            alwaysUnlocked=true;
            allContents.add(new SimplifiedTechNode(dynamite,this,2));
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
            erekirContents.add(new SimplifiedTechNode(azidoazideAzide,this,3));
            allContents.add(new SimplifiedTechNode(azidoazideAzide,this,3));
        }};
        //region Ices
        ice=new Item("ice",Color.valueOf("368BC1"))
        {{
            localizedName="Ice";
            description="Solid form of water";
            serpuloContents.add(new SimplifiedTechNode(Liquids.water,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.water,this,0));
        }};
        sludge=new Item("sludge",Color.valueOf("ffa166"))
        {{
            localizedName="Sludge";
            description="Solid form of slag";
            serpuloContents.add(new SimplifiedTechNode(Liquids.slag,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.slag,this,0));
        }};
        wax=new Item("wax",Color.valueOf("000000"))
        {{
            localizedName="Wax";
            description="Solid form of oil";
            flammability = 1.2f;
            explosiveness = 1.2f;
            serpuloContents.add(new SimplifiedTechNode(Liquids.oil,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.oil,this,0));
        }};
        cryocube=new Item("cryocube",Color.valueOf("6ecdec"))
        {{
            localizedName="Cryocube";
            description="Solid form of cryofluid";
            serpuloContents.add(new SimplifiedTechNode(Liquids.cryofluid,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.cryofluid,this,0));
        }};
        neoplasmIce=new Item("neoplasm-ice",Color.valueOf("c33e2b"))
        {{
            localizedName="Neoplasm Ice";
            description="Solid form of neoplasm";
            allContents.add(new SimplifiedTechNode(Liquids.neoplasm,this,0));
        }};
        arkyciteIce=new Item("arkycite-ice",Color.valueOf("84a94b"))
        {{
            localizedName="Arkycite Ice";
            description="Solid form of arkycite";
            flammability = 0.4f;
            allContents.add(new SimplifiedTechNode(Liquids.arkycite,this,0));
        }};
        //endregion
    }
    public static void postProcess()
    {
        erekirContents.add(new SimplifiedTechNode(RP620Liquids.hydrazine,azidoazideAzide,2));
        allContents.add(new SimplifiedTechNode(RP620Liquids.hydrazine,azidoazideAzide,2));
    }
}
