package rp620.content;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.type.CellLiquid;
import mindustry.type.Liquid;
import rp620.content.SI620Classes.SimplifiedTechNode;

import static rp620.content.SI620Classes.SI620Vars.*;

public class SI620Liquids
{//₀₁₂₃₄₅₆₇₈₉ₓ
    public static Liquid nitrogenOxide,nitrogenDioxide,ammonia,glycerin,nitricAcid,nitroglycerin,hydrazine;
    public static Liquid test_0_0,test_0_5,test_0_10,test_5_0,test_5_5,test_5_10,test_10_0,test_10_5,test_10_10;

    public static void load()
    {
        Liquids.gallium=new CellLiquid("gallium",Color.valueOf("9a9dbf"))
        {{
            coolant=false;

        }};
        nitrogenOxide=new Liquid("nitrogen-oxide", Color.valueOf("0077be"))
        {{
            localizedName="Nitrogen Oxide";
            gas=true;
            alwaysUnlocked=true;
           //TBD
            erekirContents.add(new SimplifiedTechNode(Liquids.nitrogen, this, 0));
            allContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
        }};
        nitrogenDioxide=new Liquid("nitrogen-dioxide", Color.valueOf("A52A2A"))
        {{
            localizedName="Nitrogen Dioxide";
            gas=true;
            heatCapacity=0;
            coolant=false;
            boilPoint=0;
            alwaysUnlocked=true;
            erekirContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
        }};
        ammonia=new Liquid("ammonia", Color.valueOf("0073CF"))
        {{
            localizedName="Ammonia";
            gas=true;
            alwaysUnlocked=true;
            coolant=true;
            heatCapacity=0.342683338966f;
            erekirContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
        }};
        glycerin=new Liquid("glycerin",Color.valueOf("66CCCC"))
        {{
            localizedName="Glycerin";
            viscosity=0.75f;
            explosiveness=0.75f;
            coolant=true;
            heatCapacity=0.196012166272f;
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(SI620Items.lye,this,2));
            allContents.add(new SimplifiedTechNode(SI620Items.lye,this,2));
        }};
        nitricAcid=new Liquid("nitric-acid", Color.valueOf("ffff00"))
        {{
            localizedName="Nitric Acid";
            viscosity=0.6f;
            coolant=false;
            heatCapacity=0.114903683677f;
            alwaysUnlocked=true;
            erekirContents.add(new SimplifiedTechNode(Liquids.ozone,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.ozone,this,0));
        }};
        nitroglycerin=new Liquid("nitroglycerin", Color.valueOf("ff3f3f"))
        {{
            localizedName="Nitroglycerin";
            flammability=10;
            viscosity=.35f;
            explosiveness=1.54f;
            coolant=false;
            heatCapacity=0.0337952010814f;
            effect= StatusEffects.blasted;
            alwaysUnlocked=true;
            allContents.add(new SimplifiedTechNode(glycerin,this,3));
        }};
        hydrazine=new Liquid("hydrazine",Color.purple)
        {{

            localizedName="Hydrazine";
            flammability=0;
            explosiveness=0;
            coolant=true;
            heatCapacity=0.162216965191f;
            alwaysUnlocked=true;
            erekirContents.add(new SimplifiedTechNode(ammonia,this,1));
            allContents.add(new SimplifiedTechNode(ammonia,this,1));
        }};
    }
    public static void postProcess()
    {

    }
}
